package RoundRobin;

import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {

		int timeQuantum = 2;
		System.out.println("The time quantum is " + timeQuantum);
		//String filePath = "/Users/Helen/Desktop/NYIT/CS/2021 Spring/CSCI509/Project/Process.csv";

		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter file path: ");
		String filePath = userInput.nextLine();
		System.out.println("The file path is: " + filePath);
		userInput.close();
		
		RoundRobinScheduling roundRobinSimulation = new RoundRobinScheduling();
		
        FileReader data = new FileReader(filePath);
        Object[] processId = data.getProcessId();
        Object[] arrivalTime = data.getArrivalTime();
        Object[] burstTime = data.getBurstTime();
        
        int throughput = roundRobinSimulation.findThroughput(processId);
        
        int[] completionTime = roundRobinSimulation.findCompletionTime(throughput, processId, burstTime, timeQuantum, arrivalTime);

        int[] turnaroundTime = roundRobinSimulation.findTurnaroundTime(throughput, completionTime, arrivalTime);

        int[] waitingTime = roundRobinSimulation.findWaitingTime(throughput, burstTime, turnaroundTime);

        roundRobinSimulation.findAverageTime(throughput, turnaroundTime, waitingTime);
		
	}

}
