package com.sqli.challenge;

import com.sqli.challenge.operating_system.OperatingSystem;
import com.sqli.challenge.operating_system.process.Process;
import com.sqli.challenge.operating_system.process.ProcessFactory;
import com.sqli.challenge.scheduling.FIFOSchedulingStrategy;
import com.sqli.challenge.scheduling.SchedulingStrategy;
import com.sqli.challenge.scheduling.roundRobin.RoundRobinSchedulingStrategy;

public class OsFacade {
    private final OperatingSystem operatingSystem;
    private final ProcessFactory processFactory;
    private SchedulingStrategy schedulingStrategy;
    public OsFacade() {
        this.operatingSystem = new OperatingSystem();
        this.processFactory = new ProcessFactory();
        this.schedulingStrategy = FIFOSchedulingStrategy.getInstance();
    }

    public void createProcess(String processId, String instructions) {
        Process process = processFactory.createProcess(processId,instructions);
        operatingSystem.addProcess(process);
    }

    public void run(){
        this.operatingSystem.run(this.schedulingStrategy);
    }

    public String getExecutionResult() {
        return this.operatingSystem.getExecutionResult();
    }

    public void useRoundRobin(int quantum) {
        this.schedulingStrategy = new RoundRobinSchedulingStrategy(quantum);
    }
}
