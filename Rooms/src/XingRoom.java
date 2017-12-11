
public class XingRoom extends Room 
{
	public XingRoom(int x, int y) 
	{
		super(x, y);
	}
	public void enterRoom(Person x)
	{
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		System.out.println("Literally Dead");
		Runner.gameOff();
	}
}