package com.sqli.challenge.operating_system.process;

import com.sqli.challenge.operating_system.operation.Operation;

import java.util.List;

public class Process {
    private final String name;
    private final List<Operation> operations;
    private int operationToExecute;

    public Process(String name, List<Operation> operations) {
        this.name = name;
        this.operations = operations;
        this.operationToExecute = 0;
    }

    public Operation executeOperation() {
        if (this.hasOperationToExecute())
            return operations.get(operationToExecute++);
        return null;
    }

    public boolean hasOperationToExecute() {
        return this.operations.size() > operationToExecute;
    }

    public String print() {
        return this.name;
    }
}
