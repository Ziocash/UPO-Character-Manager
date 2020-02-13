package internal.classes;

public class Ability
{
	
	private int id;
	
	private String abilityName;
	
	private int levelRequired;
	
	private CharacterClasses charClassRequired;
	
	private String charSpecRequired;
	
	private String description;
	
	
	
	public Ability()
	{
		
	}
	
	public Ability(int id, String abi, int lev, CharacterClasses c, String s, String d)
	{
		this.id = id;
		this.abilityName = abi;
		this.levelRequired = lev;
		this.charClassRequired = c;
		this.charSpecRequired = s;
		this.description = d;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setAbName(String n)
	{
		this.abilityName = n;
	}
	
	public String getAbName()
	{
		return this.abilityName;
	}
	
	public void setLevRequired(int lev)
	{
		this.levelRequired = lev;
	}
	
	public int getLevRequired()
	{
		return this.levelRequired;
	}
	
	public void setClassRequired(CharacterClasses c)
	{
		this.charClassRequired = c;
	}
	
	public CharacterClasses getClassRequired()
	{
		return this.charClassRequired;
	}
	
	public void setSpecRequired(String s)
	{
		this.charSpecRequired = s;
	}
	
	public String getSpecRequired()
	{
		return this.charSpecRequired;
	}
	
	public void setDescription(String d)
	{
		this.description = d;
	}
	
	public String getDescription()
	{
		return this.description;
	}
}
