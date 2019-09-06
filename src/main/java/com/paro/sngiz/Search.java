package com.paro.sngiz;

public class Search {
    private SearchCriteria criteria;
    private String value;

    public Search(){

    }

    public Search(SearchCriteria criteria, String value) {
        this.criteria = criteria;
        this.value = value;
    }

    public SearchCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
