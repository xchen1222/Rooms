
public class WinningRoom extends Room {



	public WinningRoom(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void enterRoom(Person x) {
		// TODO Auto-generated method stub
		occupant = x;
		x.setxLoc(this.xLoc);
		x.setyLoc(this.yLoc);
		if (occupant.key == 10)
		{
			System.out.println("Congrats! You Win");
			Runner.gameOff();
		}
		else System.out.println("This room is locked, You need 10 keys");
		//Runner.gameOff();
	}
	public String display(Person x) {
		if ((x.getxLoc() == this.xLoc) && (x.getyLoc() == this.yLoc)) {
			return("[0]");
		}
		else if (discovered == true) {
			return("[W]");
		} else
			return("[W]");
	}
	

}

