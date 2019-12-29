package droneSimulation;

import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DroneInterface {
	
	private Scanner s;
	private DroneArena myArena;
	private String width;
	private String height;
	private String newHeight;
	private JFileChooser chooser;
	
	public DroneInterface() {
		s = new Scanner(System.in);
		myArena = new DroneArena(20,10);
		
		char ch = ' ';
		do {
			System.out.print("\n Enter (A)dd drone, get (I)nformation, (D)isplay in GUI, (M)ove all the drone, move drones (T)en times or e(X)it>");
			ch = s.next().charAt(0);
			s.nextLine();
			switch (ch) {
			case 'A':
			case 'a':
					myArena.addDrone();
					break;
			case 'I':
			case 'i':
					System.out.print(myArena.toString());
					break;
			case 'x': ch = 'X';
					break;
			case 'd' :
			case 'D':
					doDisplay();
					break;
			case 'm':
			case 'M':
					myArena.moveAllDrones();
					doDisplay();
					System.out.print(myArena.toString());
					break;
			case 't':
			case 'T':
					moveTenTimes();
					doDisplay();
					System.out.print(myArena.toString());
					break;
				
			} 
		}	while (ch != 'X');
				s.close();
	}
	public static void main(String[]args) {
		DroneInterface r = new DroneInterface();
	
	}
	public void doDisplay() {
		// TODO Auto-generated method stub
		ConsoleCanvas c = new ConsoleCanvas(20,10);
		myArena.showDrones(c);
		System.out.print(c.toString());
	}
	public void moveTenTimes() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {
				
				Thread.sleep(200);
				myArena.moveAllDrones();
				doDisplay();
			} catch (InterruptedException c) {
				System.err.format("IOException: %s%n", c);
			}
		}
	}
}
