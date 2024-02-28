package com.eduardo.analisecredito.service.strategy;

import com.eduardo.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}