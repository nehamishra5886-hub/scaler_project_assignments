package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.model.CashFlow;
import com.example.Evaluations.evaluation.model.News;

import java.util.List;

public class IStockService {
    List<News> getStockNews(String symbol);
    List<CashFlow> getCompanyCashFlow(String symbol);
}
