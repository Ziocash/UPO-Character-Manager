package internal.classes;

public class BerserkerClass extends Character
{
	private final double multiplier = 12.0;
	
	
	public BerserkerClass(int id) 
	{
		super(id);
		super.setConstitution(541968465);
	}
	
	public double getMultiplier()
	{
		return multiplier;
	}

}
