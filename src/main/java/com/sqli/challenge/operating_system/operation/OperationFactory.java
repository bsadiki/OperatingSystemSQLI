package com.sqli.challenge.operating_system.operation;

import java.util.ArrayList;
import java.util.List;

public class OperationFactory {
    private List<Operation> operations;

    public OperationFactory() {
        this.operations = new ArrayList<>();
    }

    public Operation getOperation(String operationName) {
        for (Operation operation : operations) {
            if (operation.hasName(operationName))
                return operation;
        }
        return newOperation(operationName);
    }

    private Operation newOperation(String operationName) {
        Operation operation = new Operation(operationName);
        operations.add(operation);
        return operation;
    }
}
