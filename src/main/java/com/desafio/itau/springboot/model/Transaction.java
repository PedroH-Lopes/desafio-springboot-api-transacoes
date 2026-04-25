package com.desafio.itau.springboot.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Transaction(BigDecimal valor, OffsetDateTime dataHora) {
}
