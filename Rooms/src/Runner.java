import java.util.Scanner;
import java.util.Random;

public class Runner {
	
	private static boolean gameOn = true;
	static int gotName = 0;
	static String name;
	static Random rand = new Random();
	static int gotSize = 0;
	static int size = 5;
	
	public static void main(String[] args)
	{
		System.out.println("Please input your name");
		Scanner in = new Scanner(System.in);
		if (gotName == 0) {
			name = in.nextLine();
			gotName++;			
		}
		System.out.println("Rules:"
				+ "Everytime you enter a room you will take 1 damage. \n"
				+ "The next time you enter that room you will take 1 more than the last. \n"
				+ "You must gather keys to enter the winning room\n");
		System.out.println("Please select one of the following:\"\n" + 
				"\"1. Small - 5 x 5\"\n" + 
				"\"2. Medium - 7x7\"\n" + 
				"\"3. Large - 10x10\"");
		while ((gotSize == 0) && (gotName == 1)) {
			gotSize++; 
			boardSize(in.nextLine());
			
		}
		System.out.println("Size Selected:" + size);
		

		
		Board[][] blankMap = new Board[size][size];
		Room[][] building = new Room[size][size];

		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		
		}
		for (int x = 0; x<blankMap.length; x++)
		{
			for (int y = 0; y < blankMap[x].length; y++)
			{
				blankMap[x][y] = new Board(x,y);
			}
		}
		
		
		//Create a random winning room.
		
		int x = (int)(Math.random()*building.length-1)+1;
		int y = (int)(Math.random()*building.length-1)+1;
		building[x][y] = new WinningRoom(x, y);
		int a = (int)(Math.random()*building.length-1)+1;
		int b = (int)(Math.random()*building.length-1)+1;
		building[a][b] = new XingRoom(5,5); 
		 //Setup player 1 and the input scanner
		Person player1 = new Person(name, 0, 0 , 101,0);
		int g = (int)(Math.random()*building.length-1)+1;
		int q = (int)(Math.random()*building.length-1)+1;
		building[q][g] = new KeyRoom(q,g) ; 
		System.out.println("Hello young traveler " + name + "\n"  + "Its dangerous to go alone here take this");
		building[0][0].enterRoom(player1);

		while(gameOn)
		{
			for (x = 0; x<blankMap.length; x++)
			{
				for (y = 0; y < blankMap[x].length; y++)
				{
					blankMap[x][y].printBoard(building, player1);
				}
				System.out.println();
			}
			System.out.println("Life:" + player1.health + " Key:" + player1.key);
			if (player1.health <= 0 )
			{
				System.out.println("You Lose"); 
				gameOff(); 
			}
			if (gameOn) 
			{
				System.out.println("Where would you like to move? (Choose W, S, D, A)");
			}
			String move = in.nextLine();
			
			
			if(validMove(move, player1, building))
			
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
			}
		}
	in.close();
	
	
}	

	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "w":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return false;
	}
	public static void gameOff()
	{
		gameOn = false;
	}
	public static void boardSize(String x) {
		if (x.toLowerCase().equals("small")|| x.toLowerCase().equals("1") ) {
			size = 5;
			gotSize = 1 ; 
		}
		else if (x.toLowerCase().equals("medium") || x.toLowerCase().equals("2") ) {
			size = 7;
			gotSize = 1; 

		}
		else if (x.toLowerCase().equals("large") || x.toLowerCase().equals("3") ) {
			size = 10;
			gotSize = 1; 

		}
		else {
		 gotSize = 0  ; 
		System.out.println("Invalid size, Please select one of the following:\n"
				+ "1. Small - 5 x 5\n"
				+ "2. Medium - 7x7\n"
				+ "3. Large - 10x10");
		}
	

}


}


