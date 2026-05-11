package com.newsapp.newsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.newsapp.newsapp.model.Article;

//this class represents the entire API response

public class NewsService {
    @Value("${newsapi.key}")
    private String apiKey; //obtain the API key from resources

    public List<Article> getArticles() { //method to get the top 15 headlines

    RestTemplate restTemplate = new RestTemplate(); //used to retrieve the API data

    String url = "https://newsapi.org/v2/top-headlines?country=us&pageSize=15&apiKey=" + apiKey; //url to get top 15 articles in the US
        
    //send GET request, retrieve full HTTP respnse, and convert JSON into NewsResponse
    ResponseEntity<NewsResponse> response = restTemplate.getForEntity(url, NewsResponse.class);

    return response.getBody().getArticles();

    }
}