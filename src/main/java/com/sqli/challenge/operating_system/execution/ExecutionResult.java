package com.sqli.challenge.operating_system.execution;

import com.sqli.challenge.operating_system.operation.Operation;
import com.sqli.challenge.operating_system.process.Process;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResult {
    private final List<ExecutedInstruction> executedInstructions;

    public ExecutionResult() {
        this.executedInstructions = new ArrayList<>();
    }

    public ExecutionResult(List<ExecutedInstruction> executedInstructions) {
        this.executedInstructions = executedInstructions;
    }

    public void addInstruction(Operation operation, Process process) {
        this.executedInstructions.add(new ExecutedInstruction(operation, process));
    }

    public String getExecutionResult() {
        StringBuilder executionResult = new StringBuilder();
        for (ExecutedInstruction executedInstruction : this.executedInstructions) {
            executionResult.append(executedInstruction.print());
        }
        return executionResult.toString();
    }

}
