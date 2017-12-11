import java.util.Scanner;

public class Runner {
	
	static String [][] map = new String[5][5];
	static int [][] blankMap =  new int [5][5];
	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[5][5];
		for (int n = 0; n<map.length; n++)
		{
			for (int m = 0; m < map[n].length; m++)
			{
				map[n][m] = "?";
			}
		}
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
			System.out.println();
		}
		//Create a random winning room.
		System.out.println("Hello young traveler \n"  + "Its dangerous to go alone here take this");
		
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);
		int a = (int)(Math.random()*building.length);
		int b = (int)(Math.random()*building.length);
		building[a][b] = new XingRoom(a,b); 
		 //Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0,0);
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			map[player1.getxLoc()][player1.getyLoc()] = "x";
			for (int n = 0; n<map.length; n++)
			{
				for (int m = 0; m < map[n].length; m++)
				{
					if (map[n][m].equals("x")) {
						map[n][m] = "0";
					}
					map[player1.getxLoc()][player1.getyLoc()] = "x";
					System.out.print(map[n][m]);
				}
				System.out.println();
			}
			System.out.println("Where would you like to move? (Choose W, S, D, A)");
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
	public static int Map(Person p) {
		map[p.getxLoc()][p.getyLoc()] = 1;
		return 1;
	}
	


}


