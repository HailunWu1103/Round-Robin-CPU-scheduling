package RoundRobin;

public class RoundRobinScheduling {

	CPU cpu = new CPU();	
	
	public int[] findCompletionTime(int throughput, Object[] processId, Object[] burstTime, int timeQuantum, Object[] arrivalTime) {
        
        int[] remainingTime = new int[throughput];
        int[] updatedArrivalTime = new int[throughput];
        boolean[] completed = new boolean[throughput];
        //int[] createdProcess = new int[throughput]; // CPU
        		
        for (int i = 0; i < throughput; i++) {
        	remainingTime[i] = (int) burstTime[i];
        	updatedArrivalTime[i] = (int) arrivalTime[i];
        	}
        
        int time = 0;
        int arrival = 0;
        int counter = 0; // count the completed process
        

        float contextSwitchCount = 0;
        float contextSwitchTime = 0;
        
        int[] completionTime= new int[throughput];
        long roundRobinStartTime;
        long roundRobinEndTime;
        
        roundRobinStartTime = System.nanoTime();
        while (counter!=throughput) {
            for (int i = 0; i < throughput; i++) {
            	if (updatedArrivalTime[i] <= arrival && completed[i] == false) {
            		
            		cpu.getProcess((int) processId[i]);
            		
            		contextSwitchCount++;
            		if (remainingTime[i] <= timeQuantum) {
            			time += remainingTime[i];
						completionTime[i] = time;
            			remainingTime[i] = 0;
            			completed[i] = true;
            			counter += 1;
            		}
            		else {
            			remainingTime[i] -= timeQuantum;
            			time += timeQuantum;
            			updatedArrivalTime[i] = time + 1;
            		}
            	}
            }
            arrival++;
        }
        roundRobinEndTime = System.nanoTime();
        
        float totalExecutionTime = roundRobinEndTime - roundRobinStartTime;
        contextSwitchTime = cpu.getContextSwitchTime();
        float cpuUtilization = (1 - contextSwitchTime * contextSwitchCount / totalExecutionTime) * 100;
        
        System.out.println("The throughput is " + throughput);
        
        System.out.println("The CPU utilization is " + cpuUtilization + " %");
        
        return completionTime;
        
    }
	
	public int[] findTurnaroundTime(int throughput, int[] completionTime, Object[] arrivalTime) {
		int[] turnaroundTime = new int[throughput];
		for (int i = 0; i < throughput; i++) {
        	turnaroundTime[i] = completionTime[i] - (int) arrivalTime[i];
        	}
		return turnaroundTime;
	}
	
    public int[] findWaitingTime(int throughput, Object[] burstTime, int[] turnaroundTime) {
    	int[] waitingTime = new int[throughput];
    	for (int i = 0; i < throughput; i++) {
        	waitingTime[i] = turnaroundTime[i] - (int) burstTime[i];
        	}
    	return waitingTime;
    }
 
    public int findThroughput(Object[] processId) {

    	int throughput = processId.length;
    	return throughput;
    }
    
    public void findAverageTime(int throughput, int[] turnaroundTime, int[] waitingTime) {
                
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        
        for (int i = 0; i < throughput; i++) {
        	totalWaitingTime = totalWaitingTime + waitingTime[i];
        	totalTurnaroundTime = totalTurnaroundTime + turnaroundTime[i];
            }

        System.out.println("Average waiting time = " + (float)totalWaitingTime / (float)throughput);
        System.out.println("Average turnaround time = " + + (float)totalTurnaroundTime / (float)throughput);
    	}

    }
