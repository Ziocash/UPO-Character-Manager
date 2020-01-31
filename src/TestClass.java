import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import handlers.*;
import internal.classes.Character;
import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations;
import models.TableModel;

class TestClass 
{
	CharacterHandler characterHandler = new CharacterHandler();
	Character character = new internal.classes.Character(1);
	FileHandler fHandler = new FileHandler();
	TableModel tableModel = new TableModel();

	@Test
	void testAddLine() 
	{		
		System.out.println("AddLine test");
		assertEquals(characterHandler.addLine("Test|0|30.0|30.0|30.0|30.0|30.0|MAGE|ARCANE WARRIOR"), true);		
		character.setAll("Test", CharacterClasses.MAGE, CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		assertEquals(character.compareTo(characterHandler.getCharactersList().get(0)), 0);
		System.out.println("Passed");
	}
	
	@Test
	void testSetDB()
	{
		System.out.println("Set FileHandler test");
		fHandler.setDb(characterHandler.parseList());
		assertEquals(fHandler.getDb(), characterHandler.parseList());
		System.out.println("Passed");
	}
	
	@Test
	void testWriteFile()
	{
		System.out.println("WriteFile test");
		assertEquals(fHandler.writeFile(), true);
		System.out.println("Passed");
	}
	
	@Test
	void testCharacter()
	{
		System.out.println("Character test");
		character.setName("Test");
		assertEquals(character.getName(), "Test");
		character.setLevel(120);
		assertEquals(character.getLevel(), 120);
		character.setCharClass(CharacterClasses.MAGE);
		assertEquals(character.getCharClass(), CharacterClasses.MAGE);
		character.setCharSpec(CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		assertEquals(character.getCharSpec(), CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		System.out.println("Passed");
	}
	
	@Test
	void testModel()
	{
		System.out.println("Table Model test");
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(fHandler.getDb());
		tableModel = new TableModel(data);
		for(int rowIndex = 0; rowIndex < tableModel.getRowCount(); rowIndex++)
			for(int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
				assertEquals(tableModel.getValueAt(rowIndex, columnIndex), data.get(rowIndex).get(columnIndex));
		System.out.println("Passed");
	}
	
}
