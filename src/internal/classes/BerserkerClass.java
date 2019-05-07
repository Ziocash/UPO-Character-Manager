package internal.classes;

public class BerserkerClass extends Character
{
	private final double multiplier = 1.20;
	
	
	public BerserkerClass(int id) 
	{
		super(id);
		super.setConstitution(200);
		super.setStrength(30);
	}
	
	public double getMultiplier()
	{
		return multiplier;
	}
	public void setLevelUpAttributes()
	{
		super.levelUp();
		double newCon = super.getConstitution()+(super.getLevel()*multiplier);
		double newStr = super.getStrength()+(super.getLevel()*multiplier);
		super.setConstitution(newCon);
		super.setStrength(newStr);	
	}
}
