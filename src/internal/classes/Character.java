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
	 * Character specialization
	 */
	private String charSpecName;
	
	/**
	 * Max character level
	 */
	private final int MAX_LEVEL = 20;
	
	/**
	 * Abilities
	 */
	private String abilities = "";
	
	/**
	 * Returns character specialization
	 * @return character specialization
	 */
	public String getCharSpecName() 
	{
		return charSpecName;
	}

	/**
	 * Sets character specialization
	 * @param charSpecName character specialization
	 */
	public void setCharSpecName(String charSpecName) 
	{
		this.charSpecName = charSpecName;
	}
	
	/**
	 * Sets character level
	 * @param level character level
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
	
	/**
	 * Set all parameters
	 * @return void
	 */
	public void setAll(String name, CharacterClasses charClass, String charSpec)
	{
		String tempString = charSpec;
	    this.name = name;
	    this.charClass = charClass;
	    this.charSpecName = charSpec.replace("_", " ");
	    this.level = 1;
	    
	    switch(tempString)
	    {
	      //Mage Specialization characterist------------------------
	      case "ARCANE_WARRIOR":
	        this.strength = 27;
	        this.constitution = 33;
	        this.intelligence = 35;
	        this.dexterity = 22;
	        this.charisma = 24;
	        break;
	      case "BLOOD_MAGE":
	        this.strength = 20;
	        this.constitution = 35;
	        this.intelligence = 37;
	        this.dexterity = 22;
	        this.charisma = 20;
	        break;
	      case "SHAPESHIFTER":
	        this.strength = 20;
	        this.constitution = 25;
	        this.intelligence = 37;
	        this.dexterity = 25;
	        this.charisma = 30;
	        break;
	      case "SPIRIT_HEALER":
	        this.strength = 20;
	        this.constitution = 25;
	        this.intelligence = 37;
	        this.dexterity = 22;
	        this.charisma = 36;
	        break;
	      //Rogue Specialization characterist------------------------
	      case "ASSASSIN":
	        this.strength = 27;
	        this.constitution = 25;
	        this.intelligence = 29;
	        this.dexterity = 37;
	        this.charisma = 25;
	        break;
	      case "BARD":
	        this.strength = 19;
	        this.constitution = 27;
	        this.intelligence = 33;
	        this.dexterity = 25;
	        this.charisma = 40;
	        break;
	      case "DUELIST":
	        this.strength = 32;
	        this.constitution = 28;
	        this.intelligence = 25;
	        this.dexterity = 37;
	        this.charisma = 33;
	        break;
	      case "RANGER":
	        this.strength = 25;
	        this.constitution = 33;
	        this.intelligence = 27;
	        this.dexterity = 35;
	        this.charisma = 32;
	        break;
	      //Warrior Specialization characterist------------------------
	      case "BERSERKER":
	        this.strength = 35;
	        this.constitution = 40;
	        this.intelligence = 25;
	        this.dexterity = 20;
	        this.charisma = 25;
	        break;
	      case "CHAMPION":
	        this.strength = 37;
	        this.constitution = 35;
	        this.intelligence = 27;
	        this.dexterity = 21;
	        this.charisma = 33;
	        break;
	      case "REAVER":
	    	this.strength = 30;
	        this.constitution = 35;
	        this.intelligence = 30;
	        this.dexterity = 20;
	        this.charisma = 15;
	        break;
	      case "TEMPLAR":
	        this.strength = 35;
	        this.constitution = 35;
	        this.intelligence = 25;
	        this.dexterity = 20;
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
		if(level < MAX_LEVEL)
		{
			level++;
			constitution = constitution + (level * multiplier * constitution);
			strength = strength + (level * multiplier * strength);
			intelligence = intelligence + (level * multiplier * intelligence);
			dexterity = dexterity + (level * multiplier * dexterity);
			charisma = charisma + (level * multiplier * charisma);
		}
	}
	
	/**
	 * Returns a boolean that represent if character reached max level
	 * @return a boolean that represent if character reached max level
	 */
	public boolean isMaxLevel() 
	{
		return level == MAX_LEVEL;
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
		String value = "";
		value += "ID: " + id + " ";
		value += "Name: " + name + " ";
		value += "Level: " + level + " ";
		value += "Strength: " + String.format("%.2f", strength) + " ";
		value += "Intelligence: " + String.format("%.2f", intelligence) + " ";
		value += "Dexterity: " + String.format("%.2f", dexterity) + " ";		
		value += "Charisma: " + String.format("%.2f", charisma) + " ";
		value += "Constitution: " + String.format("%.2f", constitution) + " ";
		value += "Abilities: " + abilities + " ";
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
		String value = "";
		value += id + "|";
		value += name + "|";
		value += level + "|";
		value += strength + "|";
		value += intelligence + "|";
		value += dexterity + "|";		
		value += charisma + "|";
		value += constitution + "|";
		value += abilities + "|";
		value += getCharClass() + "|";
		value += getCharSpec().replace('_', ' ') + "\n";
		return value;
	}
	
	/**
	 * Returns a well-formatted String with a preconfigured separator ('|') without ID
	 * 
	 * @return a well-formatted String with a preconfigured separator ('|') without ID
	 */
	public String toFileStringWithoutID()
	{
		String value = "";
		value += name + "|";
		value += level + "|";
		value += strength + "|";
		value += intelligence + "|";
		value += dexterity + "|";		
		value += charisma + "|";
		value += constitution + "|";
		value += abilities + "|";
		value += getCharClass() + "|";
		value += getCharSpec().replace('_', ' ') + "\n";
		return value;
	}

	@Override
	public int compareTo(Character character) 
	{
		return this.id > character.id ? 1 : this.id < character.id ? -1 : 0;
	}
	
	/**
	 * Sets character abilities
	 * @param abilities character abilities string
	 */
	public void setAbilities(String abilities) 
	{
		this.abilities = abilities;
	}
	
	/**
	 * Returns a string that represents character abilities
	 * @return a string that represents character abilities
	 */
	public String getAbilities()
	{
		return abilities;
	}

	
	
}
