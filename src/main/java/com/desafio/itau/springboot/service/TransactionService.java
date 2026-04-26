package com.desafio.itau.springboot.service;

import com.desafio.itau.springboot.dto.StatisticsResponse;
import com.desafio.itau.springboot.exception.UnprocessableEntityException;
import com.desafio.itau.springboot.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(BigDecimal valor, OffsetDateTime dataHora) {
        OffsetDateTime agora = OffsetDateTime.now();

        if (valor == null
                || valor.compareTo(BigDecimal.ZERO) < 0
                || dataHora == null
                || dataHora.isAfter(agora)) {

            throw new UnprocessableEntityException("Preencha com valores válidos");
        }

        transactions.add(new Transaction(valor, dataHora));
    }

    public void deleteTransactions() {
        transactions.clear();
    }

    public StatisticsResponse getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime limit = now.minusSeconds(60);

        DoubleSummaryStatistics stats = transactions.stream()
                .filter(t -> !t.dataHora().isBefore(limit))
                .map(Transaction::valor)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();

        if (stats.getCount() == 0) {
            return new StatisticsResponse(0, 0, 0, 0, 0);
        }

        return new StatisticsResponse(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}