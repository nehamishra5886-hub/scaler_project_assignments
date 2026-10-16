package com.example.Evaluations.evaluation.controller;
import com.example.Evaluations.evaluation.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private IStockService companyService;

    //Add your APIs here
}
