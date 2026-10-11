package com.example.Evaluations.evaluation.services;


import com.example.Evaluations.evaluation.model.InstallStatus;
import com.example.Evaluations.evaluation.model.UpdateStatus;
import com.example.Evaluations.evaluation.model.Version;

import java.util.UUID;

public interface IDeployService {
    InstallStatus install(UUID appId);

    UpdateStatus update(UUID appId, String version);

    Version getLatestVersion(UUID appId, String installedVersion);
}