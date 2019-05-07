package internal.classes;

public abstract class Character 
{
	private final int id;
	private String name;
	private int level = 1;
	private double strength = 0;
	private double constitution = 0;
	
	public Character(int id)
	{
		this.id = id;
	}
	
	public double getStrength() 
	{
		return strength;
	}

	public void setStrength(double strength) 
	{
		this.strength = strength;
	}

	public double getConstitution() 
	{
		return constitution;
	}

	public void setConstitution(double constitution) 
	{
		this.constitution = constitution;
	}
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void levelUp()
	{
		level++;
	}
	public int getLevel()
	{
		return level;
	}
}
