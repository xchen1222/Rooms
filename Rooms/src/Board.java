
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

}
