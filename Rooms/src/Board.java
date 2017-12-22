
public class Board {
	int size;
	Room[][] rooms;
	
	public Board(int size) {
		this.size = size;
	}

	public Board(Room[][] rooms) {
		this.rooms = rooms;
	}
	
	public void printBoard(Room[][] rooms, Person x) {
		System.out.print(rooms[size][size].display(x));
	}
	public void boardSize(String x) {
		switch(x) {
		case "small":
			size = 5;
		case "medium":
			size = 7;
		case "large":
			size = 10;
		default: 
			break;
		}
		System.out.println("Invalid size, Please select one of the following:\n"
				+ "1. Small - 5 x 5\n"
				+ "2. Medium - 7x7\n"
				+ "3. Large - 10x10");
		
	}

}
