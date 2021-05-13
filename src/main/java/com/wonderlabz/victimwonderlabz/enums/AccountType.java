package com.wonderlabz.victimwonderlabz.enums;


public enum AccountType {

    SAVINGS("SAVINGS"),
    CURRENT("CURRENT");

    private final String description;
    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
