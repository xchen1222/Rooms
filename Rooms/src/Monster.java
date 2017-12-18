
public class Monster extends Person {

	public Monster (String name, int xLoc, int yLoc, int health)
	{
		super (name , xLoc, yLoc, health) ; 
	}
	public void  setNameMonster(String name)
	{
		this.name = name ; 
	}
	public String getNameMonster() 
	{
		return name; 
	}
	public void sethealthMonster(int health) 
	{
		this.health = health;
	}
	public int getHealthMonster()
	{
		return health ; 
	}
	
	
}
