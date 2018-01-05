
public class KeyRoom extends Room {

	public KeyRoom(int x, int y)
	{
		super ( x ,y) ; 
	}
	
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		occupant.key++ ;
		new KeyRoom(2,2);
	}
	public String display(Person x) 
	{
		if ((x.getxLoc() == this.xLoc) && (x.getyLoc() == this.yLoc)) {
			discovered = true;
			if (x.getName().equals("")){ 
				return("[0]");
			} else {
				return("["+ occupant.getName().charAt(0) + "]");
			}
		}
		else if (discovered == true) {
			return("[K]");
		} else
			return("[K]");
		}
}
