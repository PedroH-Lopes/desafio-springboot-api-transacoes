package com.desafio.itau.springboot.controller;


import com.desafio.itau.springboot.exception.UnprocessableEntityException;
import com.desafio.itau.springboot.model.Transaction;
import com.desafio.itau.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transacoes")
public class TransactionController {

    private final TransactionService transacaoService;

    public TransactionController(TransactionService transactionService) {
        this.transacaoService = transactionService;
    }

    @PostMapping
    private ResponseEntity<Void> registerTransaction(@RequestBody Transaction newTransactionRequest) {
        try {
            transacaoService.addTransaction(newTransactionRequest.valor(), newTransactionRequest.dataHora());
            return ResponseEntity.accepted().build();

        } catch (UnprocessableEntityException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
