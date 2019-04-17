package handlers;

import java.util.ArrayList;
import java.util.List;

public class CharacterHandler<T>
{
	private List<T> list;
	
	public CharacterHandler()
	{
		list = new ArrayList<T>();
	}
	
	public void addCharacter(T character)
	{
		list.add(character);
	}
	
	public int countCharacters()
	{
		return list.size();
	}
	
	public List<T> getCharactersList()
	{
		return list;
	}
	
}
