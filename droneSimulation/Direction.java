package droneSimulation;

import java.util.Random;

public enum Direction {
	NORTH, SOUTH , EAST, WEST;
	
	public static Direction randomDirection() {
		Random rand = new Random();
		
		return values()[rand.nextInt(values().length)];
	}
	public Direction next() {
		return values()[(this.ordinal() + 1) % values().length];
	}
	
}
