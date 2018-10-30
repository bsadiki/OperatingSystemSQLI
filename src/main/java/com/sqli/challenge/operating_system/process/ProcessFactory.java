package com.sqli.challenge.operating_system.process;

import com.sqli.challenge.operating_system.operation.Operation;
import com.sqli.challenge.operating_system.operation.OperationFactory;

import java.util.ArrayList;
import java.util.List;

public class ProcessFactory {
    private static final OperationFactory OPERATION_FACTORY = new OperationFactory();;
    private static final String SEPRATOR = ";";
    public ProcessFactory() {
    }

    public Process createProcess(String processId, String instructions){
        String[] operationsNames = instructions.split(SEPRATOR);
        List<Operation> processOperations = new ArrayList<>();
        for (String operationsName: operationsNames){
            processOperations.add(OPERATION_FACTORY.getOperation(operationsName));
        }
        return new Process(processId,processOperations);
    }
}
