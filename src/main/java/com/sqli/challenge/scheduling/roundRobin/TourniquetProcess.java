package com.sqli.challenge.scheduling.roundRobin;

import com.sqli.challenge.operating_system.execution.ExecutedInstruction;
import com.sqli.challenge.operating_system.process.Process;

import java.util.ArrayList;
import java.util.List;

public class TourniquetProcess {
    private Process process;
    private int quantum;

    public TourniquetProcess(Process process, int quantum) {
        this.process = process;
        this.quantum = quantum;
    }

    public List<ExecutedInstruction> execute() {
        List<ExecutedInstruction> executedInstructions = new ArrayList<>();
        int tempQuantum = this.quantum;
        while (tempQuantum > 0 && process.hasOperationToExecute()) {
            executedInstructions.add(new ExecutedInstruction(process.executeOperation(), process));
            tempQuantum--;
        }
        return executedInstructions;
    }

    public boolean hasOperationToExecute() {
        return this.process.hasOperationToExecute();
    }
}