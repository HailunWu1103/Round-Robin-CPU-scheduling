package RoundRobin;

public class CPU {
	
	int pid;
	
	public CPU() {
		pid = 0;
	}

	public boolean createProcess(int pid) {
		if (isCreated()) {
			return false;
		}
		this.pid = pid;
		return true;
	}
	
	public boolean isCreated() {
		return pid != 0;
	}
	
	public boolean getProcess(int pid) {
		if (isCreated()) {
			this.pid = pid;
			return true;
		}
		else {
			createProcess(pid);
			return false;
		}
	}
	
	public long getContextSwitchTime() {
		long startTime = System.nanoTime();
		getProcess(pid);
		long endTime = System.nanoTime();
		long contextSwitchTime = endTime - startTime;
		return contextSwitchTime;
	}
}
