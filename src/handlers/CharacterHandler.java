package handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import internal.classes.Character;

public class CharacterHandler
{
	private List<Character> db;
	
	/**
	 * CharacterHandler constructor
	 */
	public CharacterHandler()
	{
		db = new ArrayList<Character>();
	}
	
	/**
	 * Adds a given-type character into list
	 * 
	 * @param character
	 */
	public void addCharacter(Character character)
	{
		db.add(character);
	}
	
	/**
	 * Returns how many characters are in the list
	 * 
	 * @return how many characters are in the list
	 */
	public int countCharacters()
	{
		return db.size();
	}
	
	/**
	 * Returns a list which contains all element loaded previously
	 * 
	 * @return a list which contains all element loaded previously
	 */
	public List<Character> getCharactersList()
	{
		return db;
	}
	
	/**
	 * Searches an element with a given id 
	 * 
	 * @param id Item Id to find
	 * @return the searched item ({@code ArrayList<String>}) else {@code null}
	 */
	public Character search(int id) 
	{
		if(db != null)
			for (Character item : db)
				if(item.getId() == id)				
					return item;
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNewID()
	{
		if(db.size() != 0 && !db.isEmpty())
			if(db.size() < (db.get(db.size()-1).getId()))
				return db.get(db.size()-1).getId() + 1;
			else
				return db.size()+1;		
		else
			return 1; //No elements in data file (empty file)
	}
	
	/**
	 * Writes the db array into the file at path {@link #pathOfFile}
	 * 
	 * @param line
	 * @return {@code true} if the line is correctly added to db array, {@code false} in the other cases
	 */
	public boolean addLine(String line)
	{
		try
		{
			Character ch = new Character(getNewID());
			ch.
			List<String> dati=Arrays.asList(line.split("\\|"));
			addCharacter(ch);
			return true;
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
			return false;
		}
	}
}
