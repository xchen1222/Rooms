
public class Room {
	Person occupant;
	int xLoc,yLoc;
	boolean discovered = false;
	
	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}
	public void Map(Person x) {
		if ((x.getxLoc() == this.xLoc) && (x.getyLoc() == this.yLoc)) {
			System.out.print("[0]");
		}
		else if (discovered == true) {
			System.out.print("[O]");
		} else
			System.out.print("[?]");
	}
	public void enterRoom(Person x)
	{
		System.out.println("You enter a plain old room");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		discovered = true;
	}
	
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
	
	public boolean canPrint() {
		return discovered;
	}
}
