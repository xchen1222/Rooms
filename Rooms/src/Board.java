
public class Board {
	int length;
	int width;
	Room[][] rooms;
	
	//Constructs board with a length and width
	public Board(int length, int width) {
		this.length = length;
		this.width = width;
	}
	//Constructs board with given constructed room
	public Board(Room[][] rooms) {
		this.rooms = rooms;
	}
	//Prints out display of board using the displays of each room and the location of given person
	public void printBoard(Room[][] rooms, Person x) {
		System.out.print(rooms[length][width].display(x));
	}
	//Changes size of board using given user input
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
