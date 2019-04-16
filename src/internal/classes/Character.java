package internal.classes;

public abstract class Character 
{
	private final int id;
	private String name;
	private int strength = 0;
	private int constitution = 0;
	
	public Character(int id)
	{
		this.id = id;
	}
	
	public int getStrength() 
	{
		return strength;
	}

	public void setStrength(int strength) 
	{
		this.strength = strength;
	}

	public int getConstitution() 
	{
		return constitution;
	}

	public void setConstitution(int constitution) 
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
}
