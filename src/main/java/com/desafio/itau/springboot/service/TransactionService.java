package com.desafio.itau.springboot.service;

import com.desafio.itau.springboot.exception.UnprocessableEntityException;
import com.desafio.itau.springboot.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
}