package droneSimulation;

public class Drone {

	private int x , y , DroneID;	
	private Direction direction;
	
	
	public Drone(int x , int y ,int ID, Direction direction){
	this.x = x;
	this.y = y;
	this.DroneID = ID;
	this.direction= direction;
	
		
}
	public boolean isHere (int sx, int sy) {
		if(x == sx && y == sy) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void tryToMove(DroneArena dArena) {
		int dx = x;
		int dy = y;
		
		switch (direction) {
		
		case NORTH:
			dx -= 1; //if drone facing north move north by 1
			break;
		case EAST:
			dy += 1;
			break;
		case SOUTH:
			dx += 1;
			break;
		case WEST:
			dy -= 1;
			break;
		}
		if (dArena.canMoveHere(dx, dy) == true) 
		{
		x = dx;
		y = dy;
		}
		else
		{
			direction = direction.next();
		}
	}
	
	public String toString() {
		return "Drone is at location " + '(' + x + ',' + y + ')' + " facing " + direction;
	}
	
	public void displayDrone(ConsoleCanvas c) {
		c.showIt(x, y, 'D');
	}

	public static void main(String[] args) {
		Drone d = new Drone(5, 3, 0, Direction.SOUTH); // create drone
		
		System.out.println(d.toString());
	}

}

