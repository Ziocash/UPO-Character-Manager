package handlers;

import java.util.ArrayList;
import java.util.List;
import internal.classes.Character;

public class CharacterHandler
{
	private List<Character> list;
	
	/**
	 * CharacterHandler constructor
	 */
	public CharacterHandler()
	{
		list = new ArrayList<Character>();
	}
	
	/**
	 * Adds a given-type character into list
	 * 
	 * @param character
	 */
	public void addCharacter(Character character)
	{
		list.add(character);
	}
	
	/**
	 * Returns how many characters are in the list
	 * 
	 * @return how many characters are in the list
	 */
	public int countCharacters()
	{
		return list.size();
	}
	
	/**
	 * Returns a list which contains all element loaded previously
	 * 
	 * @return a list which contains all element loaded previously
	 */
	public List<Character> getCharactersList()
	{
		return list;
	}
	
}
