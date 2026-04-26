package com.desafio.itau.springboot.controller;


import com.desafio.itau.springboot.exception.UnprocessableEntityException;
import com.desafio.itau.springboot.model.Transaction;
import com.desafio.itau.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    private ResponseEntity<Void> registerTransaction(@RequestBody Transaction newTransactionRequest) {
        try {
            transactionService.addTransaction(newTransactionRequest.valor(), newTransactionRequest.dataHora());
            return ResponseEntity.accepted().build();

        } catch (UnprocessableEntityException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteTransactions() {
        transactionService.deleteTransactions();
        return ResponseEntity.ok().build();
    }
}
