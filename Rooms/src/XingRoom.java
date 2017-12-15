import java.util.Random;

public class XingRoom extends Room 
{
	Random rand = new Random();
	int random = rand.nextInt(5);
	int random2 = rand.nextInt(5);
	
	public XingRoom(int x, int y) 
	{
		super(x, y);
	}
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(random);
		x.setyLoc(random2);
		System.out.println("Literally Dead");
	}
	
	public void Map(Person x) {
		if ((x.getxLoc() == this.xLoc) && (x.getyLoc() == this.yLoc)) {
			System.out.print("[0]");
		}
		else if (discovered == true) {
			System.out.print("[X]");
		} else
			System.out.print("[X]");
	}
	public void leaveRoom(Person x)
	{
		occupant = null;
	}
}