package com.example.Evaluations.evaluation.dtos;

import com.example.Evaluations.evaluation.model.CashFlow;
import lombok.Data;

@Data
public class RealTimeCashFlowData {
    private List<CashFlow> cash_flow;

}
