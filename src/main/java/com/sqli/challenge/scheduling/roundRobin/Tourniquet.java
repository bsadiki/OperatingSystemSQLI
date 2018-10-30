package com.sqli.challenge.scheduling.roundRobin;

import com.sqli.challenge.operating_system.execution.ExecutedInstruction;
import com.sqli.challenge.operating_system.execution.ExecutionResult;
import com.sqli.challenge.operating_system.process.Process;

import java.util.ArrayList;
import java.util.List;

public class Tourniquet {
    private List<TourniquetProcess> tourniquetProcesses;
    private final int quantum;

    public Tourniquet(int quantum) {
        this.quantum = quantum;
    }

    public void initProcesses(List<Process> processes) {
        this.tourniquetProcesses = new ArrayList<>();
        processes.forEach(this::addProcess);
    }

    private void addProcess(Process process) {
        tourniquetProcesses.add(new TourniquetProcess(process, this.quantum));
    }

    ExecutionResult execute() {
        List<ExecutedInstruction> executedInstructions = new ArrayList<>();
        while (!allProcessesAreOver()) {
            executedInstructions.addAll(browseTourniquet());
        }
        return new ExecutionResult(executedInstructions);
    }

    private boolean allProcessesAreOver() {
        for (TourniquetProcess tourniquetProcess : this.tourniquetProcesses) {
            if (tourniquetProcess.hasOperationToExecute())
                return false;
        }
        return true;
    }

    private List<ExecutedInstruction> browseTourniquet() {
        List<ExecutedInstruction> executedInstructionsInATurnOver = new ArrayList<>();
        for (TourniquetProcess tourniquetProcess : this.tourniquetProcesses) {
            if (tourniquetProcess.hasOperationToExecute())
                executedInstructionsInATurnOver.addAll(tourniquetProcess.execute());
        }
        return executedInstructionsInATurnOver;
    }

}
