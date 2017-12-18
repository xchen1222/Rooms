
public class Person {
	int xLoc;
	String name;
	int health;
	int yLoc;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getxLoc() {
		return xLoc;
	}

	public void setxLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getyLoc() {
		return yLoc;
	}

	public void setyLoc(int yLoc) {
		this.yLoc = yLoc;
	}
	public int gethealth() {
		return health;
	}
	
	public void sethealth(int health) {
		this.health = health;
	}

	public Person (String name, int xLoc, int yLoc, int health)
	{
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.name = name;
		this.health = health;
	}


}
