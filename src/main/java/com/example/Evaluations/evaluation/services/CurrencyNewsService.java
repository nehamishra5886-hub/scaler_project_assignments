package com.example.Evaluations.evaluation.services;

import com.example.Evaluations.evaluation.model.News;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CurrencyNewsService implements ICurrencyService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<News> getCurrencyNews(String fromCurrency, String toCurrency) {
        //Add your implementation here
        return null;
    }
}