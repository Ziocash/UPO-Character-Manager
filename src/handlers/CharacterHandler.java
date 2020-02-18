package handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import internal.classes.Character;
import internal.classes.CharacterClasses;

public class CharacterHandler
{
	/**
	 * CharacterHandler db
	 */
	private List<Character> db;
	
	/**
	 * CharacterHandler constructor
	 */
	public CharacterHandler()
	{
		db = new ArrayList<Character>();
	}
	
	/**
	 * Returns a parsed ArrayList for external handlers
	 * 
	 * @return a parsed ArrayList for external handlers
	 */
	public ArrayList<ArrayList<String>> parseList()
	{
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(Character c : db)
		{
			ArrayList<String> value = new ArrayList<String>();
			value.add(Integer.toString(c.getId())); 
			value.add(c.getName());
			value.add(Integer.toString(c.getLevel()));
			value.add(Double.toString(c.getStrength()));
			value.add(Double.toString(c.getConstitution()));
			value.add(Double.toString(c.getIntelligence()));
			value.add(Double.toString(c.getDexterity()));
			value.add(Double.toString(c.getCharisma()));
			value.add(c.getAbilities());
			value.add(c.getCharClass().name());
			value.add(c.getCharSpec().replace('_', ' '));
			list.add(value);
		}
		return list;
	}
	
	/**
	 * Loads an ArrayList into internal collection
	 * 
	 * @param db Collection that contains data which will be loaded into internal collection
	 */
	public void loadList(ArrayList<ArrayList<String>> db)
	{
		for(ArrayList<String> row : db)
		{
			String content = "";
			int i = 0;
			int maxI = row.size() - 1;
			for(String item : row)
			{
				if(i > 0)
				{	
					content += item;
					if(maxI > i)
						content += "|";
				}
				i++;
			}
			addLine(content);			
		}
	}
	
	/**
	 * Adds a given-type character into list
	 * 
	 * @param character
	 */
	public boolean addCharacter(Character character)
	{
		return db.add(character);
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
	 * Returns an unassigned id
	 * 
	 * @return an unassigned id
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
			ch.setLevel(Integer.parseInt(dati[1]));
			ch.setStrength(Double.parseDouble(dati[2]));
			ch.setConstitution(Double.parseDouble(dati[3]));			
			ch.setIntelligence(Double.parseDouble(dati[4]));
			ch.setDexterity(Double.parseDouble(dati[5]));
			ch.setCharisma(Double.parseDouble(dati[6]));
			ch.setAbilities(dati[7]);
			ch.setCharClass(CharacterClasses.valueOf(dati[dati.length-2]));
			dati[dati.length-1] = dati[dati.length-1].replace(' ', '_');
			ch.setCharSpec(dati[dati.length-1]);
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
	 * Add a line into a selected index
	 * @param line Character line
	 * @param id 
	 * @return {@code true} if added correctly, else {@code false}
	 */
	private boolean addAtIndex(String line, int id)
	{
		try
		{
			Character ch = new Character(id);
			String[] dati = line.split("\\|");
			ch.setName(dati[0]);
			ch.setLevel(Integer.parseInt(dati[1]));
			ch.setStrength(Double.parseDouble(dati[2]));
			ch.setConstitution(Double.parseDouble(dati[3]));			
			ch.setIntelligence(Double.parseDouble(dati[4]));
			ch.setDexterity(Double.parseDouble(dati[5]));
			ch.setCharisma(Double.parseDouble(dati[6]));
			ch.setAbilities(dati[7]);
			ch.setCharClass(CharacterClasses.valueOf(dati[dati.length-2]));
			dati[dati.length-1] = dati[dati.length-1].replace(' ', '_');
			ch.setCharSpec(dati[dati.length-1]);
			addCharacter(ch);
			Collections.sort(db);
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
	public boolean editChar(String line, int id)
	{
		if(db.remove(search(id)))
			return addAtIndex(line, id);
		return false;
	}
	
	/**
	 * Deletes the line with the given id
	 * @param id character id
	 * @return {@code true} if the character is correctly deleted, {@code false} in the other cases
	 */
	public boolean delete(int id)
	{
		Character ch = search(id);
			return db.remove(ch);
		
	}
}
