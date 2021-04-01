# Round-Robin-CPU-scheduling
User input:
Process (.csv)

Output:
CPU Utilization
Throughput
Average Waiting Time
Average Turnaround Time

Steps:
1.	FileReader reads the csv file and feeds the data to RoundRobinScheduling
2.	RoundRobinScheduling calls the CPU to create/access specific process
3.	output the analytical values

Round Robin Scheduling Algorithm:
1.	Parameters Initiation
initiate a remainingTime array copying the values of the burstTime array
initiate a updatedArrivalTime array copying the values of arrivalTime array
initiate two integers time and arrival
initiate completionTime, waitingTime, and turnaroundTime arrays
initiate a counter of 0
initiate a boolean array to store the status of each process
initiate a contextSwitchCount of 0

2.	run Round Robin Scheduling Algorithm to obtain completionTime and cpuUtilization
```
while loop to increase arrival by 1when counter != throughput
    traverse the remainingTime array with index i using for loop
    	if updatedArrivalTime[i] <= arrival && completed[i] == false
		cpu.getProcess(processId[i])
		contextSwitchCount ++
		if remainingTime[i] <= timeQuantum
      time += remainingTime[i]
			completionTime[i] = time
			remainingTime[i] = 0
			completed[i] = true
			counter += 1
		else
			remainingTime[i] -= timeQuantum
			time += timeQuantum
			updatedArrivalTime[i] = time + 1
arrival++
```

3.	compute the values for turnaroundTime
```
turnaroundTime[i] = competionTime[i] – arrivalTime[i]
```

4.	compute the values for waitingTime
```
waitingTime[i] = turnaroundTime[i] – burstTime[i]
```

5.	compute the average turnaround time and waiting time
