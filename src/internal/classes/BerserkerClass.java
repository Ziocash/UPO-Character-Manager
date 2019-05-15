package internal.classes;

public class BerserkerClass extends Character
{
	//Class-specific multiplier
	private final double multiplier = 1.20;
	
	/**
	 * Class constructor
	 * 
	 * @param id Character UniqueID 
	 */
	public BerserkerClass(int id) 
	{
		super(id);
		super.setConstitution(200);
		super.setStrength(30);
	}
	
	/**
	 * Returns multiplier value {@code double}
	 * 
	 * @return multiplier value {@code double}
	 */
	public double getMultiplier()
	{
		return multiplier;
	}
	
	/**
	 * Completes values (level, constitution and strength)
	 */
	public void setLevelUpAttributes()
	{
		super.levelUp();
		double newCon = super.getConstitution() + (super.getLevel() * multiplier);
		double newStr = super.getStrength() + (super.getLevel() * multiplier);
		super.setConstitution(newCon);
		super.setStrength(newStr);	
	}
	
	/**
	 * Returns a String which contains all configured fields
	 * 
	 * @return a String which contains all configured fields
	 */
	@Override
	public String toString()
	{
		String text = "ID: " + super.getId() + " Name: " + super.getName() + " Constitution: " + super.getConstitution() + " Strength: " + super.getStrength()+ " Level: " + super.getLevel();
		return text;
	}
}
