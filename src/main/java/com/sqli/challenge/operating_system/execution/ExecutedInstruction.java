package com.sqli.challenge.operating_system.execution;

import com.sqli.challenge.operating_system.operation.Operation;
import com.sqli.challenge.operating_system.process.Process;

public class ExecutedInstruction {
    private Operation operation;
    private Process process;

    public ExecutedInstruction(Operation operation, Process process) {
        this.operation = operation;
        this.process = process;
    }

    String print() {
        return "<<" + process.print() + ">>" + operation.print();
    }
}