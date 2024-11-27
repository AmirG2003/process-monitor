package com.example;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSorting;
import java.util.List;

public class ProcessMonitor {
    private SystemInfo systemInfo;
    private OperatingSystem os;

    // Constructor to initialize SystemInfo and OperatingSystem objects
    public ProcessMonitor() {
        systemInfo = new SystemInfo();
        os = systemInfo.getOperatingSystem();
    }

    // Method to display information about the top 10 processes sorted by CPU usage
    public void displayProcesses() {
        // Get the top 10 processes sorted by CPU usage
        List<OSProcess> processes = os.getProcesses(OperatingSystem.ProcessFiltering.ALL_PROCESSES, ProcessSorting.CPU_DESC, 10);

        // Print table header
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "PID", "Type", "CPU (%)", "Memory", "I/O (MB)", "Bound");

        // Iterate through the list of processes and print their details
        for (OSProcess process : processes) {
            // Determine if the process is a system process or a user process
            String processType = process.getUser() == null ? "System" : "User";
            // Calculate the CPU load percentage
            double cpuLoad = process.getProcessCpuLoadCumulative() * 100;
            // Get the memory usage in bytes
            long memoryUsage = process.getResidentSetSize();
            // Calculate the I/O usage in megabytes
            double ioMB = (process.getBytesRead() + process.getBytesWritten()) / (1024.0 * 1024.0);
            // Determine if the process is CPU-bound or I/O-bound
            String boundType = cpuLoad > 50 ? "CPU-bound" : "I/O-bound";

            // Print the process details in a formatted manner
            System.out.printf("%-10d %-10s %-10.2f %-10d %-10.2f %-10s%n",
                    process.getProcessID(), processType, cpuLoad, memoryUsage, ioMB, boundType);
        }
    }

    // Main method to create a ProcessMonitor object and display the processes
    public static void main(String[] args) {
        ProcessMonitor processMonitor = new ProcessMonitor();
        processMonitor.displayProcesses();
    }
}