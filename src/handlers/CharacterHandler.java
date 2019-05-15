package handlers;

import java.util.ArrayList;
import java.util.List;

public class CharacterHandler<T>
{
	private List<T> list;
	
	/**
	 * CharacterHandler constructor
	 */
	public CharacterHandler()
	{
		list = new ArrayList<T>();
	}
	
	/**
	 * Adds a given-type character into list
	 * 
	 * @param character
	 */
	public void addCharacter(T character)
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
	public List<T> getCharactersList()
	{
		return list;
	}
	
}
