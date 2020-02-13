package handlers;

import java.util.ArrayList;

import internal.classes.Ability;
import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations;

public class AbilityHandler
{
	private ArrayList<String> dbAbility = new ArrayList<String>();
	private ArrayList<Ability> dbCharAbility = new ArrayList<Ability>(); 
	
	public AbilityHandler()
	{
		FileHandler fh = new FileHandler();
		dbAbility = fh.getDbAbilities();
	}

	public ArrayList<Ability> getCharacterAbility(CharacterClasses c, String s)
	{
		setCharacterAbilityDB(c,s);
		return this.dbCharAbility;
	}
	
	private void setCharacterAbilityDB(CharacterClasses c, String s)
	{
		
		for(int i=0;i<dbAbility.size();i+=16)
		{
			if(CharacterClasses.valueOf(dbAbility.get(i).toUpperCase())==c)
			{
				String[] dati = dbAbility.get(1+i).split("#");
				Ability a= new Ability(Integer.parseInt(dati[0]),dati[1],Integer.parseInt(dati[2]),c,"",dati[3]);
				dbCharAbility.add(a);
				dati = dbAbility.get(2+i).split("#");
				a= new Ability(Integer.parseInt(dati[0]),dati[1],Integer.parseInt(dati[2]),c,"",dati[3]);
				dbCharAbility.add(a);
				for(int j=i+3;j<dbAbility.size();j+=3)
				{
					String actualSpec=dbAbility.get(j).toUpperCase();
					if(actualSpec.equals(s))
					{
						dati = dbAbility.get(1+j).split("#");
						a= new Ability(Integer.parseInt(dati[0]),dati[1],Integer.parseInt(dati[2]),c,s,dati[3]);
						dbCharAbility.add(a);
						dati = dbAbility.get(2+j).split("#");
						a= new Ability(Integer.parseInt(dati[0]),dati[1],Integer.parseInt(dati[2]),c,s,dati[3]);
						dbCharAbility.add(a);
						break;
					}
					if(dbAbility.get(j).equals(System.lineSeparator()))
						break;
				}
			}
			
		}
	}
}
