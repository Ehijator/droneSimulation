package droneSimulation;

public class ConsoleCanvas {

	private char[][] CanvasArena;
	private int xSize;
	private int ySize;
	
	public ConsoleCanvas(int x, int y) {
		xSize = x;
		ySize = y;
		
		CanvasArena = new char[x][y];
		
		
		for (int i = 0; i < CanvasArena.length; i++) {
			for (int j = 0; j < CanvasArena[i].length; j++) {
				if (((j >= 0) && ((i == 0)||(i == x - 1)))||((i>= 0) && ((j == 0) || (j == y - 1)))) {
					CanvasArena[i][j] = '#';
				}
				else {
					CanvasArena[i][j] = ' ';
				}
			}
		}
	}
	
	
	
	public void showIt(int x, int y,char c) {
		CanvasArena[x][y] = c;
	}
	
	public String toString() {
		
		int i = 0;
		int j = 0;
		
		String Canvas = "";
		
		for (i = 0; i < xSize; i++) {
			for (j = 0; j < ySize; j++) {
				Canvas += CanvasArena[i][j];
			}
			Canvas += "\n";
		}
		return Canvas;
	}
	public static void main(String[] args) {
		
		ConsoleCanvas c = new ConsoleCanvas (10, 5);
		c.showIt(4, 3, 'D');
		System.out.println(c.toString());
	}
}
