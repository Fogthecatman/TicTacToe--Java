package net.fogthecatman;

public class Tile {
	
	public String tileValue;
	
	public Tile()
	{
		tileValue = "_";
	}

	public boolean tileHasValue()
	{
		if(!tileValue.equals("_"))
			return true;
		else
			return false;
	}
	
	public String returnValue()
	{
		return tileValue;
	}
	
	public void setValue(String playerVal)
	{
		tileValue = playerVal;
	}
	public String toString()
	{
		System.out.println("This tile has a value of " + tileValue);
		return "";
	}
	public boolean equalsObj(Tile inTile)
	{
		if(inTile.returnValue().equals("_"))
			return false;
		
		if(tileValue.equals("_"))
			return false;
		
		if(inTile.returnValue().equals(tileValue))
			return true;
		else
			return false;
	}
}
