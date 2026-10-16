package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.model.CashFlow;
import com.example.Evaluations.evaluation.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CompanyStockService implements IStockService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<News> getStockNews(String symbol) {
        //Add your implementation here
        return null;
    }

    public List<CashFlow> getCompanyCashFlow(String symbol) {
        //Add your implementation here
        return null;
    }
}
