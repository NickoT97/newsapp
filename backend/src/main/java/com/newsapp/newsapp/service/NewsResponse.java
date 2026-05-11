package com.newsapp.newsapp.service;

import java.util.List;

import com.newsapp.newsapp.model.Article;

//class for the JSON response from NewsAPI

public class NewsResponse {

    //the variables in the JSON response from NewsAPI
    private String status;
    private int totalResults;
    private List<Article> articles;

    public NewsResponse() {}

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getTotalResults(){
        return totalResults;
    }

    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;
    }

    public List<Article> getArticles(){
        return articles;
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
    }
}
