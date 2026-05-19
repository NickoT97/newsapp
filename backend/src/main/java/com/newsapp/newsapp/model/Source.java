package com.newsapp.newsapp.model;

//used for the source list in the JSON response of an Article object

public class Source {
    private String id;
    private String name;

    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
