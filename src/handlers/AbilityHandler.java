package handlers;

import java.util.ArrayList;

import internal.classes.Ability;
import internal.classes.CharacterClasses;

public class AbilityHandler
{
	private ArrayList<String> dbAbility = new ArrayList<String>();
	private ArrayList<Ability> dbCharAbility = new ArrayList<Ability>(); 
	
	public AbilityHandler()
	{
		FileHandler fh = new FileHandler();
		dbAbility = fh.getDbAbilities();
	}

	/**
	 * 
	 * @param characterClass
	 * @param specialization
	 * @return
	 */
	public ArrayList<Ability> getCharacterAbility(CharacterClasses characterClass, String specialization)
	{
		setCharacterAbilityDB(characterClass, specialization);
		return this.dbCharAbility;
	}
	
	/**
	 * 
	 * @param characterClass
	 * @param specialization
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
}
