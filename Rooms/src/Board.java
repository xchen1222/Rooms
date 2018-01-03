
public class Board {
	int length;
	int width;
	Room[][] rooms;
	
	public Board(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public Board(Room[][] rooms) {
		this.rooms = rooms;
	}
	
	public void printBoard(Room[][] rooms, Person x) {
		System.out.print(rooms[length][width].display(x));
	}
	
	public void boardSize(String x) {
		switch(x) {
		case "small":
			length = 5;
			width = 5;
		case "medium":
			length = 7;
			width = 7;
		case "large":
			length = 10;
			width = 10;
		default: 
			break;
		}
		System.out.println("Invalid size, Please select one of the following:\n"
				+ "1. Small - 5 x 5\n"
				+ "2. Medium - 7x7\n"
				+ "3. Large - 10x10");
		
	}

}
