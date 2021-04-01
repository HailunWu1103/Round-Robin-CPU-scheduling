package RoundRobin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	ArrayList<Integer> processId = new ArrayList<Integer> ();
	ArrayList<Integer> arrivalTime = new ArrayList<Integer> ();
	ArrayList<Integer> burstTime = new ArrayList<Integer> ();
	
	public FileReader(String filePath) {
		
		List<List<String>> process = new ArrayList<List<String>> ();
		
		try {
			File processes = new File(filePath);
			
			Scanner input = new Scanner(processes);
			input.useDelimiter("\n"); // to recognize the line break
			while (input.hasNext() ) {
				String[] data = input.nextLine().split(",");
				process.add(Arrays.asList(data));
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(List<String> row: process) {
        	processId.add(Integer.valueOf(row.get(0)));
        	arrivalTime.add(Integer.valueOf(row.get(1)));
        	burstTime.add(Integer.valueOf(row.get(2)));
        }
	}
	
	public Object[] getProcessId() {
        Object[] processId = this.processId.toArray();
        
        
		return processId;
	}
	
	public Object[] getArrivalTime() {
		Object[] arrivalTime = this.arrivalTime.toArray();
		return arrivalTime;
	}
	
	public Object[] getBurstTime() {
		Object[] burstTime = this.burstTime.toArray();
		return burstTime;
	}
	
}
