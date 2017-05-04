package game;

public class ChessTimer{

	private long startTime = 0;
	private long stopTime = 0;
	private boolean running = false;


	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}


	public void stop() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}

	//elaspsed time in seconds
	public double getTotalTimeSecs() {
		double elapsed;
		if (running) {
			elapsed = ((System.currentTimeMillis() - startTime) / 1000);
		}
		else {
			elapsed = ((stopTime - startTime) / 1000);
		}
		return elapsed;
	}
}