package com.paro.sngiz;

public enum SearchCriteria {
    ALL("all"),
    ID("id"),
    FIRSTNAME("firstname"),
    SURNAME("surname"),
    FATHERSNAME("fathersname"),
    INTPASSPORT("intpassport"),
    DOMPASSPORT("dompassport"),
    NATIONALITY("nationality"),
    BIRTHDAY("birthday"),
    EDUCATION("education"),
    FAMILYSTATUS("familyStatus"),
    EMAIL("email"),
    SEX("sex");

    public String getName() {
        return name;
    }

    private final String name;

    SearchCriteria(String name) {
        this.name = name;
    }
}
