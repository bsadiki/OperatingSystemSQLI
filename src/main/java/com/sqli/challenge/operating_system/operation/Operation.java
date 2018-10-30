package com.sqli.challenge.operating_system.operation;

public class Operation {
    private final String name;

    Operation(String name) {
        this.name = name;
    }

    boolean hasName(String operationName) {
        return this.name.equals(operationName);
    }

    public String print() {
        return this.name;
    }
}
