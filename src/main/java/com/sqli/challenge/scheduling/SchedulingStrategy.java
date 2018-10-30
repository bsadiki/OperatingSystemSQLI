package com.sqli.challenge.scheduling;

import com.sqli.challenge.operating_system.execution.ExecutionResult;
import com.sqli.challenge.operating_system.process.Process;

import java.util.List;

public interface SchedulingStrategy {
    ExecutionResult executeProcesses(List<Process> processes);
}
