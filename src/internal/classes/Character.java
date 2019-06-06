package internal.classes;

import handlers.SettingsHandler;
import internal.classes.CharacterSpecializations.*;

public class Character 
{
	/**
	 * CharacterID
	 */
	private final int id;
	/**
	 * Character name
	 */
	private String name;
	/**
	 * Character level
	 */
	private int level = 1;
	/**
	 * Character strength
	 */
	private double strength = 0;
	/**
	 * Character constitution
	 */
	private double constitution = 0;
	/**
	 * Character class (ROGUE, MAGE or WARRIOR)
	 */
	private CharacterClasses charClass;
	/**
	 * Character specialization
	 */
	private Class<?> charSpec;
	
	/**
	 * Represents a Character with his own customization
	 * @param id CharacterID
	 */
	public Character(int id)
	{
		this.id = id;
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
		return charSpec.getDeclaredFields()[0].getName();
	}

	/**
	 * Sets the character specialization
	 * @param charSpec Character specialization ({@code MageType})
	 */
	public void setCharSpec(MageType charSpec)
	{
		this.charSpec = charSpec.getClass();
	}
	
	/**
	 * Sets the character specialization
	 * @param charSpec Character specialization ({@code RogueType})
	 */
	public void setCharSpec(RogueType charSpec)
	{
		this.charSpec = charSpec.getClass();
	}
	
	/**
	 * Sets the character specialization
	 * @param charSpec Character specialization ({@code WarriorType})
	 */
	public void setCharSpec(WarriorType charSpec)
	{
		this.charSpec = charSpec.getClass();
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
		value += "Strength: " + strength + " ";
		value += "Constitution: " + constitution + " ";
		value += "Class: " + getCharClass() + " ";
		value += "Specialization: " + getCharSpec().replace('_', ' ') + " ";
		
		return value;
	}
	
	public String toFileString()
	{
		String value = new String();
		value += id + "|";
		value += name + "|";
		value += level + "|";
		value += strength + "|";
		value += constitution + "|";
		value += getCharClass() + "|";
		value += getCharSpec().replace('_', ' ') + "\n";
		return value;
	}
	
}
