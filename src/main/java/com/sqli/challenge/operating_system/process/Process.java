package com.sqli.challenge.operating_system.process;

import com.sqli.challenge.operating_system.operation.Operation;

import java.util.List;

public class Process {
    private final String name;
    private final List<Operation> operations;
    private int operationsToExecute;

    public Process(String name, List<Operation> operations) {
        this.name = name;
        this.operations = operations;
        this.operationsToExecute = operations.size()-1;
    }

    public Operation executeOperation() {
        if (this.hasOperationToExecute())
            return operations.get(operationsToExecute--);
        return null;
    }

    public boolean hasOperationToExecute() {
        return operationsToExecute >= 0;
    }

    public String print() {
        return this.name;
    }
}
