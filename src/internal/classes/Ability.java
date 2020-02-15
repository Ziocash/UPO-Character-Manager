package internal.classes;

public class Ability
{
	
	private int id;
	
	private String abilityName;
	
	private int levelRequired;
	
	private CharacterClasses charClassRequired;
	
	private String charSpecRequired;
	
	private String description;
	
	
	/**
	 * Sets a new instance of Ability
	 */ 
	public Ability()
	{
		
	}
	
	/**
	 * Sets a new instance of Ability
	 * 
	 * @param id Ability ID
	 * @param ability Ability name
	 * @param levelRequired Ability minimum required level
	 * @param characterClass Character class
	 * @param specialization Character specialization
	 * @param description Ability description
	 */
	public Ability(int id, String ability, int levelRequired, CharacterClasses characterClass, String specialization, String description)
	{
		this.id = id;
		this.abilityName = ability;
		this.levelRequired = levelRequired;
		this.charClassRequired = characterClass;
		this.charSpecRequired = specialization;
		this.description = description;
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
