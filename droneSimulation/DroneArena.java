package droneSimulation;

import java.util.ArrayList;
import java.util.Random;

public class DroneArena {

	private int xmax , ymax;
	ArrayList<Drone> drones;
	
	
	
	
	public DroneArena(int xmax , int ymax) {
		this.xmax = xmax;
		this.ymax = ymax;
	
		drones = new ArrayList<Drone>();
	}
	
	
	
	
	public void addDrone() {
		Random rand = new Random(); 	// declaring and creating random object
		int x; 		//produces random x for drone
		int y; 		// produces random y for drone
		
		do {
			x = rand.nextInt(xmax - 2)+ 1;	// makes sure drone is not added outside or on the border
			y = rand.nextInt(ymax - 2)+ 1;	// makes sure drone is not added outside or on the border
		} while (getDroneAt(x,y) != null);	
	
	
	Direction direction = Direction.randomDirection();
	
	drones.add(new Drone(x, y, drones.size()+ 1, direction));	// parse x y
	}
	public Drone getDroneAt(int x, int y) {
		Drone drone = null;
		
		for (int i = 0; i < drones.size(); i++) {
			if (drones.get(i).isHere(x,y)) {
				drone = drones.get(i);
			}
		}
		
		if (drone == null)
		{
			return null;
		}
		
		else
		{
			return drone;
		}
	}
	public void moveAllDrones() {
		for (Drone drone : drones) {
			drone.tryToMove(this);
		}
	}
	
	public void showDrones(ConsoleCanvas c) {
		for (Drone drone : drones) {
			drone.displayDrone(c);
		}
	}
	public String toString() {
		String output = ("Arena has size " + xmax + " by " + ymax ) ;
		for (int i = 0; i < drones.size(); i++) {
			output += "\n" + drones.get(i).toString();
		}
		return output;
	}
	
	public Boolean canMoveHere(int x, int y) {
		
		if ((getDroneAt(x, y) != null) || (x + y == 0) || (x == xmax - 1) || (y == ymax - 1)|| (x == 0) || (y == 0)) {
			return false;
		}
		
		else {
			return true;
			
		}
	}
	public static void main(String[] args) {
		DroneArena a = new DroneArena(20, 10);	// create drone arena
		a.addDrone();
		a.addDrone();
		a.addDrone();
		
		System.out.println(a.toString());	// print where is
	}	
}
