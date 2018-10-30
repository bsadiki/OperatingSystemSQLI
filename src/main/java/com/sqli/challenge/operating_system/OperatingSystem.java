package com.sqli.challenge.operating_system;

import com.sqli.challenge.operating_system.execution.ExecutionResult;
import com.sqli.challenge.operating_system.process.Process;
import com.sqli.challenge.scheduling.SchedulingStrategy;

import java.util.List;

public class OperatingSystem {
    private final List<Process> processes;
    private ExecutionResult executionResult;

    public OperatingSystem(List<Process> processes) {
        this.processes = processes;
    }

    public void addProcess(Process process) {
        this.processes.add(process);
    }

    public void run(SchedulingStrategy schedulingStrategy) {
        this.executionResult= schedulingStrategy.executeProcesses(processes);
    }

    public String getExecutionResult() {
        return this.executionResult.getExecutionResult();
    }
}
