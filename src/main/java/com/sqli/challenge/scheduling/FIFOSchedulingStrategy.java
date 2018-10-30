package com.sqli.challenge.scheduling;

import com.sqli.challenge.operating_system.execution.ExecutionResult;
import com.sqli.challenge.operating_system.process.Process;

import java.util.List;

public class FIFOSchedulingStrategy implements SchedulingStrategy {
    private static FIFOSchedulingStrategy ourInstance = new FIFOSchedulingStrategy();

    public static FIFOSchedulingStrategy getInstance() {
        return ourInstance;
    }

    private FIFOSchedulingStrategy() {
    }

    @Override
    public ExecutionResult executeProcesses(List<Process> processes) {
        ExecutionResult executionResult = new ExecutionResult();
        processes.forEach(process->{
            while (process.hasOperationToExecute()){
                executionResult.addInstruction(process.executeOperation(),process);
            }
        });
        return executionResult;
    }
}
