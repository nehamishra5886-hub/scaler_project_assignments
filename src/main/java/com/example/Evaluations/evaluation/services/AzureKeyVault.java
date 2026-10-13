package com.example.Evaluations.evaluation.services;
import java.util.TreeMap;

import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.stereotype.Service;

@Service("azureKeyVault")
public class AzureKeyVault implements IKeyVault {
    private final TreeMap<String, String> secrets = new TreeMap<>();

    @Override
    public void saveSecret(String secretName, String secretValue) {
        secrets.put(secretName, secretValue);
    }

    @Override
    public String retrieveSecret(String secretName) {
        return secrets.get(secretName);
        //return null;
    }
}
