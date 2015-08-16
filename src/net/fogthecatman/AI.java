package net.fogthecatman;

import java.util.Random;

public class AI {
	
	public AI()
	{
		
	}
	
	public int randomNum()
	{
		Random rand = new Random();
		int randomInt = rand.nextInt(8);
		return randomInt;
	}

}
