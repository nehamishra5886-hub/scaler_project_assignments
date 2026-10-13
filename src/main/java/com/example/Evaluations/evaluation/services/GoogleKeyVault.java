package com.example.Evaluations.evaluation.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service("googleKeyVault")
public class GoogleKeyVault implements IKeyVault{

    private final HashMap<String, String> secrets = new HashMap<>();

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
