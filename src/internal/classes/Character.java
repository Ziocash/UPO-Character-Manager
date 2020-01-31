package internal.classes;

public class Character implements Comparable<Character>
{
	/**
	 * CharacterID
	 */
	private final int id;
	/**
	 * Character multiplier
	 */
	private final double multiplier = 0.1;
	/**
	 * Character name
	 */
	private String name;
	/**
	 * Character level
	 */
	private int level = 0;
	/**
	 * Character strength
	 */
	private double strength = 0;
	/**
	 * Character constitution
	 */
	private double constitution = 0;
	/**
	 * Character intelligence
	 */
	private double intelligence = 0;
	/**
	 * Character dexterity
	 */
	private double dexterity = 0;
	/**
	 * Character charisma
	 */
	private double charisma = 0;
	/**
	 * Character class (ROGUE, MAGE or WARRIOR)
	 */
	private CharacterClasses charClass;
	/**
	 * 
	 */
	private String charSpecName;
	
	public String getCharSpecName() 
	{
		return charSpecName;
	}

	public void setCharSpecName(String charSpecName) 
	{
		this.charSpecName = charSpecName;
	}
	
	/**
	 * .
	 * @param level
	 */
	public void setLevel(int level)
	{
		this.level = level;
	}

	/**
	 * Represents a Character with his own customization
	 * @param id CharacterID
	 */
	public Character(int id)
	{
		this.id = id;
	}
	
	public final int getFieldCount()
	{
		return getClass().getDeclaredFields().length;
	}
	
	/**
	 * set all parameters
	 * @return void
	 */
	public void setAll(String name, CharacterClasses charClass, String charSpec)
	{
		String tempString = charSpec;
	    this.name=name;
	    this.charClass=charClass;
	    this.charSpecName = charSpec.replace("_", " ");
	    
	    switch(tempString)
	    {
	      //Mage Specialization characterist------------------------
	      case "ARCANE_WARRIOR":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "BLOOD_MAGE":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "SHAPESHIFTER":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "SPIRIT_HEALER":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      //Rogue Specialization characterist------------------------
	      case "ASSASSIN":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "BARD":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "DUELIST":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "RANGER":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      //Warrior Specialization characterist------------------------
	      case "BERSERKER":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "CHAMPION":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "REAVER":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	      case "TEMPLAR":
	        this.strength = 30;
	        this.constitution = 30;
	        this.intelligence = 30;
	        this.dexterity = 30;
	        this.charisma = 30;
	        break;
	    }
	  }
	
	/**
	 * Returns the character strength
	 * @return character strength ({@code double}) 
	 */
	public double getStrength() 
	{
		return strength;
	}

	/**
	 * Sets the character strength
	 * @param strength Character strength
	 */
	public void setStrength(double strength) 
	{
		this.strength = strength;
	}

	/**
	 * Returns the character constitution
	 * @return character constitution ({@code double})
	 */
	public double getConstitution() 
	{
		return constitution;
	}

	/**
	 * Sets the character constitution
	 * @param constitution Character strength
	 */
	public void setConstitution(double constitution) 
	{
		this.constitution = constitution;
	}

	/**
	 * Returns the character intelligence
	 * @return character intelligence ({@code double})
	 */
	public double getIntelligence() 
	{
		return intelligence;
	}

	/**
	 * Sets the character intelligence
	 * @param intelligence Character intelligence
	 */
	public void setIntelligence(double intelligence) 
	{
		this.intelligence = intelligence;
	}

	/**
	 * Returns the character dexterity
	 * @return character dexterity ({@code double})
	 */
	public double getDexterity() 
	{
		return dexterity;
	}

	/**
	 * Sets the character dexterity
	 * @param dexterity Character dexterity
	 */
	public void setDexterity(double dexterity) 
	{
		this.dexterity = dexterity;
	}

	/**
	 * Returns the character charisma
	 * @return character charisma ({@code double})
	 */
	public double getCharisma() 
	{
		return charisma;
	}

	/**
	 * Sets the character charisma
	 * @param charisma Character charisma
	 */
	public void setCharisma(double charisma) 
	{
		this.charisma = charisma;
	}
	/**
	 * Returns the CharacterID
	 * @return character id ({@code int})
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Returns the character name 
	 * @return character name ({@code String})
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the character name
	 * @param name Character name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Levels up the character
	 */
	public void levelUp()
	{
		level++;
		constitution = constitution + (level * multiplier * constitution);
		strength = strength + (level * multiplier * strength);
		intelligence = intelligence + (level * multiplier * intelligence);
		dexterity = dexterity + (level * multiplier * dexterity);
		charisma = charisma + (level * multiplier * charisma);
	}
	
	/**
	 * Returns the character level 
	 * @return character level ({@code int})
	 */
	public int getLevel()
	{
		return level;
	}

	/**
	 * Returns the character specialization
	 * @return character specialization ({@code String})
	 */
	public String getCharSpec()
	{
		return charSpecName;
	}

	/**
	 * Returns the character class
	 * @return character class ({@code CharacterClasses})
	 */
	public CharacterClasses getCharClass()
	{
		return charClass;
	}

	/**
	 * Sets the character class
	 * @param charClass Character class
	 */
	public void setCharClass(CharacterClasses charClass)
	{
		this.charClass = charClass;
	}
	
	public void setCharSpec(String string) 
	{
		this.charSpecName = string;		
	}
	
	/**
	 * Returns a String which contains all configured fields
	 * 
	 * @return a String which contains all configured fields
	 */
	@Override
	public String toString()
	{
		String value = new String();
		value += "ID: " + id + " ";
		value += "Name: " + name + " ";
		value += "Level: " + level + " ";
		value += "Strength: " + String.format("%.2f", strength) + " ";
		value += "Intelligence: " + String.format("%.2f", intelligence) + " ";
		value += "Dexterity: " + String.format("%.2f", dexterity) + " ";		
		value += "Charisma: " + String.format("%.2f", charisma) + " ";
		value += "Constitution: " + String.format("%.2f", constitution) + " ";
		value += "Class: " + getCharClass() + " ";
		value += "Specialization: " + getCharSpec().replace('_', ' ') + " ";
		
		return value;
	}
	
	/**
	 * Returns a well-formatted String with a preconfigured separator ('|')
	 * 
	 * @return a well-formatted String with a preconfigured separator ('|')
	 */
	public String toFileString()
	{
		String value = new String();
		value += id + "|";
		value += name + "|";
		value += level + "|";
		value += strength + "|";
		value += intelligence + "|";
		value += dexterity + "|";		
		value += charisma + "|";
		value += constitution + "|";
		value += getCharClass() + "|";
		value += getCharSpec().replace('_', ' ') + "\n";
		return value;
	}

	@Override
	public int compareTo(Character character) 
	{
		return this.id > character.id ? 1 : this.id < character.id ? -1 : 0;
	}

	
	
}
