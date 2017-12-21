import java.util.Random;

public class XingRoom extends Room 
{
	Random rand = new Random();
	//int random = rand.nextInt(5);
	//int random2 = rand.nextInt(5);
	
	public XingRoom(int x, int y) 
	{
		super(x, y);
	}
	public void enterRoom(Person x)
	{
		occupant = x;
		discovered = true;
		x.setxLoc(rand.nextInt(5));
		x.setyLoc(rand.nextInt(5));
		System.out.println("Random Teleport");
	}
	
	public String display(Person x) {
		if ((x.getxLoc() == this.xLoc) && (x.getyLoc() == this.yLoc)) {
			discovered = true;
			if (x.getName().equals("")){ 
				return("[0]");
			} else {
				return("["+ occupant.getName().charAt(0) + "]");
			}
		}
		else if (discovered == true) {
			return("[X]");
		} else
			return("[X]");
	}
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
}