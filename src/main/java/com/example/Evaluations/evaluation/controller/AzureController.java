package com.example.Evaluations.evaluation.controller;

import com.example.Evaluations.evaluation.dtos.SecretDto;
import com.example.Evaluations.evaluation.services.IKeyVault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eval/api/azure/secrets")
public class AzureController {

    @Autowired
    @Qualifier("azureKeyVault")
    private IKeyVault keyVault;

    @PostMapping
    public void storeSecret(@RequestBody SecretDto secret) {
        keyVault.saveSecret(secret.getName(),secret.getValue());
    }

    @GetMapping("/{name}")
    public String getSecret(@PathVariable("name") String secretName) {
        return keyVault.retrieveSecret(secretName);
    }
}