package com.desafio.itau.springboot.controller;

import com.desafio.itau.springboot.dto.StatisticsResponse;
import com.desafio.itau.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransactionService transactionService;

    StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> returnStatistics() {
        return ResponseEntity.ok(transactionService.getStatistics());
    }
}
