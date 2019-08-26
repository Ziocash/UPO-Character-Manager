package handlers;

import java.util.ArrayList;
import java.util.List;
import internal.classes.Character;
import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations.MageType;
import internal.classes.CharacterSpecializations.RogueType;
import internal.classes.CharacterSpecializations.WarriorType;

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
			String[] dati = line.split("\\|");
			ch.setName(dati[0]);
			ch.setStrength(Double.parseDouble(dati[2]));
			ch.setConstitution(Double.parseDouble(dati[3]));
			ch.setCharClass(CharacterClasses.valueOf(dati[4]));
			CharacterClasses var = ch.getCharClass();
			dati[5] = dati[5].replace(' ', '_');
			switch(var)
			{
				case MAGE :
					ch.setCharSpec(MageType.valueOf(dati[5]));
					break;
				case ROGUE :
					ch.setCharSpec(RogueType.valueOf(dati[5]));
					break;
				case WARRIOR:
					ch.setCharSpec(WarriorType.valueOf(dati[5]));
					break;
			}
			addCharacter(ch);
			return true;
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Writes the db array into the file at path {@link #pathOfFile}
	 * 
	 * @param db line id
	 * @return {@code true} if the file is correctly written, {@code false} in the other cases
	 */
	public boolean editChar(String line,int id)
	{
		if(db.remove(search(id)))
			return addLine(line);
		return false;		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id)
	{
		Character ch = search(id);
		if(db.remove(ch))
		{
			return true;
		} 
		else
		{
			return false;
		}
	}
}
