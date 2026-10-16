package com.example.Evaluations.evaluation.dtos;

import com.example.Evaluations.evaluation.model.News;
import lombok.Data;

@Data
public class RealTimeNewsData {
    private List<News> news;
}
