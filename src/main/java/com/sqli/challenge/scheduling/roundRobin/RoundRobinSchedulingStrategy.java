package com.sqli.challenge.scheduling.roundRobin;

import com.sqli.challenge.operating_system.execution.ExecutionResult;
import com.sqli.challenge.operating_system.process.Process;
import com.sqli.challenge.scheduling.SchedulingStrategy;

import java.util.List;

public class RoundRobinSchedulingStrategy implements SchedulingStrategy {
    private Tourniquet tourniquet;

    public RoundRobinSchedulingStrategy(int quantum) {
        this.tourniquet = new Tourniquet(quantum);
    }

    @Override
    public ExecutionResult executeProcesses(List<Process> processes) {
        this.tourniquet.initProcesses(processes);
        return tourniquet.execute();
    }
}
