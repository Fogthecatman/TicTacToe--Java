package net.fogthecatman;

import java.util.Scanner;

public class Board {
	
	public  Tile tile_0, tile_1, tile_2, tile_3, tile_4, tile_5, tile_6, tile_7, tile_8;
	public final Tile[] boardTiles = new Tile[9];
	public String player = "";
	
	public Board()
	{	
		tile_0 = new Tile();			
		tile_1 = new Tile();
		tile_2 = new Tile();
		tile_3 = new Tile();
		tile_4 = new Tile();
		tile_5 = new Tile(); 
		tile_6 = new Tile();
		tile_7 = new Tile();
		tile_8 = new Tile();
		boardTiles[0] = tile_0;
		boardTiles[1] = tile_1;
		boardTiles[2] = tile_2;
		boardTiles[3] = tile_3;
		boardTiles[4] = tile_4;
		boardTiles[5] = tile_5;
		boardTiles[6] = tile_6;
		boardTiles[7] = tile_7;
		boardTiles[8] = tile_8;
	}
	
	public void printBoard()
	{
		System.out.println("\nPlayer: " + player);
		System.out.println("\t\t" + boardTiles[0].returnValue() + " | " + boardTiles[1].returnValue() + " | " + boardTiles[2].returnValue());
		System.out.println("\t\t---------");
		System.out.println("\t\t" + boardTiles[3].returnValue() + " | " + boardTiles[4].returnValue() + " | " + boardTiles[5].returnValue());
		System.out.println("\t\t---------");
		System.out.println("\t\t" + boardTiles[6].returnValue() + " | " + boardTiles[7].returnValue() + " | " + boardTiles[8].returnValue());
	}
	
	public void startGame(){
		Scanner keyboard = new Scanner(System.in);
		player = "X";
		boolean gameRunning = true;
		boolean goodPick;
		boolean gameWon = false;
		boolean isAI = false;
		int playerInput;
		int numPlayers = 0;
		int turnCount = 0;
		
		//Check for number of players or AI
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("How many players? (1, 2): ");		
		numPlayers = keyboard.nextInt();
		
		if(numPlayers == 1)
			isAI = true;
		
		
		printBoard();
		while(gameRunning)
		{
			goodPick = false;
			//Game Logic
			while(!goodPick)
			{
				System.out.println("\nInput Values as (#) for tile number");
				playerInput = keyboard.nextInt();
				
				boolean checkIndex = false;
				while(!checkIndex)
				{
					if(playerInput >= 0 && playerInput <= 8)
						checkIndex = true;
					else
					{
						System.out.println("\nBAD INPUT: Input Values as (#) for tile number");
						playerInput = keyboard.nextInt();
					}
						
				}

				if(!boardTiles[playerInput].tileHasValue())
				{
					boardTiles[playerInput].setValue(player);
					goodPick = true;
				}
				else
					System.out.println("Please pick another tile");
			
			}
			
			
			//Gameover Condition
			gameWon = checkWin();
			
			if(gameWon)
			{
				System.out.println("\nWinner is " + player);
				gameRunning = false;
			}
			
			if(turnCount > 7 && gameWon)
			{
				System.out.println("\nWinner is " + player);
				gameRunning = false;
			}
			else if(turnCount > 7)
			{
				System.out.println("\nTIE GAME");
				gameRunning = false;
			}
			
			
			if(!isAI)
			{
				if(player.equals("X"))
					player = "O";
				else
					player = "X";
			}
			if(isAI)
			{
				boolean goodPickAI = false;
				AI computadora = new AI();
				int random = computadora.randomNum();
				while(!goodPickAI)
				{
					if(!boardTiles[random].tileHasValue())
					{
						boardTiles[random].setValue("O");
						goodPickAI = true;
					}
					else
					{
						random = computadora.randomNum();
						goodPickAI = false;
					}
				}
				
			}
			
			if(!gameWon) printBoard();
			
			turnCount++;		
		}
		printBoard();
		keyboard.close();
		System.out.println("\tGame Over");
	}
	
	public boolean checkWin()
	{	
		
		if(isWin(0,3,6)) 		return true;
		else if(isWin(1,4,7)) 	return true;
		else if(isWin(2,5,8))	return true;
		else if(isWin(0,1,2))	return true;
		else if(isWin(3,4,5))	return true;
		else if(isWin(6,7,8))	return true;
		else if(isWin(0,4,8))	return true;
		else if(isWin(2,4,6))	return true;
		else
			return false;
		
	}
	public boolean isWin(int first, int second, int third)
	{
		if(boardTiles[first].equalsObj(boardTiles[second]) && boardTiles[first].equalsObj(boardTiles[third]))
			return true;
		else
			return false;
	}
	
	
}
