
public class Room {
	Person occupant;
	int xLoc,yLoc;
	boolean discovered = false;
	int n = 0 ; 
	//constructs room
	public Room(int x, int y)
	{
		xLoc = x;
		yLoc = y;
	}
	//defines the shown display used in printBoard 
	public String display (Person x) {
		//checks if player is in the current room, makes current room 'discovered' if true.
		if ((x.getxLoc() == this.xLoc) && (x.getyLoc() == this.yLoc)) {
			discovered = true;
			//if user has no name, displays damage with + + to show current position. 
			if (x.getName().equals("")){ 
				return ("["+n+"]");
			//displays user name as current position
			} else {
				return ("["+ x.getName().charAt(0) + "]");
			}
		}
		//displays rooms after discovered
		else if (discovered == true) {
			return ("["+(n+1)+"]");
		//if room has not been discovered, display [?]
		} else
			return ("[?]");
	}
	//message upon entering room, sets all variables of player
	public void enterRoom(Person x)
	{
		System.out.println("You enter a plain old room");
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		n++ ; 
		occupant.health -= n  ;
		discovered = true;		
	}
	
	//sets room to have no occupants upon leaving
	public void leaveRoom(Person x)
	
	{
		occupant = null;
	}
	
	public boolean canPrint() {
		return discovered;
	}
}
