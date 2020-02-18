package handlers;

import java.util.ArrayList;

import internal.classes.Ability;
import internal.classes.CharacterClasses;

public class AbilityHandler
{
	private ArrayList<String> dbAbility = new ArrayList<String>();
	private ArrayList<Ability> dbCharAbility = new ArrayList<Ability>(); 
	
	/**
	 * Ability Handler constructor
	 * 
	 * This class handles abilities correctly
	 */
	public AbilityHandler()
	{
		FileHandler fh = new FileHandler();
		dbAbility = fh.getDbAbilities();
	}

	/**
	 * Returns an Ability ArrayList which contains all abilities based on specialization and class
	 * @param characterClass character class
	 * @param specialization character specialization
	 * @return an Ability ArrayList which contains all abilities based on specialization and class
	 */
	public ArrayList<Ability> getCharacterAbility(CharacterClasses characterClass, String specialization)
	{
		setCharacterAbilityDB(characterClass, specialization);
		return this.dbCharAbility;
	}
	
	/**
	 * Sets AbilityDB based on CharacterClass and specialization
	 * @param characterClass character class
	 * @param specialization character specialization 
	 */
	private void setCharacterAbilityDB(CharacterClasses characterClass, String specialization)
	{
		
		for(int i = 0; i < dbAbility.size(); i += 16)
		{
			if(CharacterClasses.valueOf(dbAbility.get(i).toUpperCase())  == characterClass)
			{
				String[] dati = dbAbility.get(1 + i).split("#");
				Ability tempAbility = new Ability(Integer.parseInt(dati[0]), dati[1], Integer.parseInt(dati[2]), characterClass, "", dati[3]);
				dbCharAbility.add(tempAbility);
				dati = dbAbility.get(2 + i).split("#");
				tempAbility = new Ability(Integer.parseInt(dati[0]), dati[1], Integer.parseInt(dati[2]), characterClass, "", dati[3]);
				dbCharAbility.add(tempAbility);
				for(int j = i + 3; j < dbAbility.size(); j += 3)
				{
					String actualSpec = dbAbility.get(j).toUpperCase();
					if(actualSpec.equals(specialization))
					{
						dati = dbAbility.get(1+j).split("#");
						tempAbility = new Ability(Integer.parseInt(dati[0]), dati[1], Integer.parseInt(dati[2]), characterClass, specialization, dati[3]);
						dbCharAbility.add(tempAbility);
						
						dati = dbAbility.get(2+j).split("#");
						tempAbility = new Ability(Integer.parseInt(dati[0]), dati[1], Integer.parseInt(dati[2]), characterClass, specialization, dati[3]);
						dbCharAbility.add(tempAbility);
						break;
					}
					if(dbAbility.get(j).equals(System.lineSeparator()))
						break;
				}
			}
			
		}
	}

	/**
	 * Parse an {@code int} array into a {@code string} 
	 * @param ownedAbilities {@code int} array that contains all owned abilities
	 * @return
	 * a parsed string that represents character owned or bought abilities
	 */
	public String parseAbilities(int[] ownedAbilities)
	{
		String tempString = "";
		for(int i = 0; i < ownedAbilities.length; i++)
		{
			tempString += ownedAbilities[i]; 
			if(ownedAbilities.length - 1  > i)
				tempString += "#";
		}
		return tempString;
	}
	
	/**
	 * Parse an ability string into an {@code int} array
	 * @param abilities Abilities
	 * @return 
	 * an {@code int} array that contains owned or bought abilities
	 */
	public int[] buildAbilityArray(String abilities)
	{
	    int [] arrayAbilities = new int[] { 0, 0, 0, 0};
	    if(!abilities.isEmpty())
	    {
		    String [] arrString = abilities.split("#");
		    for(int i = 0; i < arrString.length; i++)
		    	arrayAbilities[i] = Integer.parseInt(arrString[i]);
	    }
	    return arrayAbilities; 
	}
	
	/**
	 * Returns an {@code int} value that represents a valid ability counter
	 * @param abilities ability array
	 * @return
	 * an {@code int} value that represents a valid ability counter
	 */
	public int countAbilities(int[] abilities)
 	{
		int i=0;
	    for(int ability : abilities)
	    	if(ability > 0)
	    		i++;
	    return i;
 	}
	
	/**
	 * Returns a {@code boolean} that represents if an ability has already owned
	 * @param abilities Ability array
	 * @param ability Value to check
	 * @return
	 * a {@code boolean} that represents if an ability has already owned
	 */
	public boolean isAlreadyOwned(int[] abilities, int ability)
	{
		for(int temp : abilities)
	    	if(ability == temp)
	    		return true;
		return false;
	}
}
