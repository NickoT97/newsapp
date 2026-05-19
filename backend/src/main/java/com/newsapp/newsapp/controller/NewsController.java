package com.newsapp.newsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newsapp.newsapp.model.Article;
import com.newsapp.newsapp.service.NewsService;

@RestController  //Return values are written as JSON
@RequestMapping("/api")   // All of the endpoints in this class are start with /api
public class NewsController {

    @Autowired            // Spring injects the NewsService bean it created with @Service
    private NewsService newsService;

    @GetMapping("/news")  // Handles get requests to /api/news
    public List<Article> getTopHeadlines() {
        return newsService.getArticles();  // Returns the 15 articles as a JSON array by calling .getArticles()
    }
}