package com.example.search.model;

public class Search {
    private String search;
    private String result;

    public Search() {
    }

    public Search(String search, String result) {
        this.search = search;
        this.result = result;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
