import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.System.out;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import handlers.*;
import internal.classes.Ability;
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
	AbilityHandler aHandler = new AbilityHandler();

	@Test
	void testAddLine() 
	{		
		out.println("AddLine test");
		assertTrue(characterHandler.addLine("Test|0|30.0|30.0|30.0|30.0|30.0||MAGE|ARCANE WARRIOR"));		
		character.setAll("Test", CharacterClasses.MAGE, CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		assertEquals(character.compareTo(characterHandler.getCharactersList().get(0)), 0);
		out.println("Passed");
	}
	
	@Test
	void testSetDB()
	{
		out.println("Set FileHandler test");
		fHandler.setDb(characterHandler.parseList());
		assertEquals(fHandler.getDb(), characterHandler.parseList());
		out.println("Passed");
	}
	
	@Test
	void testWriteFile()
	{
		out.println("WriteFile test");
		assertTrue(fHandler.writeFile());
		out.println("Passed");
	}
	
	@Test
	void testCharacter()
	{
		out.println("Character test");
		character.setName("Test");
		assertEquals(character.getName(), "Test");
		character.setLevel(120);
		assertEquals(character.getLevel(), 120);
		character.setCharClass(CharacterClasses.MAGE);
		assertEquals(character.getCharClass(), CharacterClasses.MAGE);
		character.setCharSpec(CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		assertEquals(character.getCharSpec(), CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		out.println("Passed");
	}
	
	@Test
	void testModel()
	{
		out.println("Table Model test");
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>(fHandler.getDb());
		tableModel = new TableModel(data);
		for(int rowIndex = 0; rowIndex < tableModel.getRowCount(); rowIndex++)
			for(int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
				assertEquals(tableModel.getValueAt(rowIndex, columnIndex), data.get(rowIndex).get(columnIndex));
		out.println("Passed");
	}
	
	@Test
	void testAbilityHandler()
	{
		out.println("Ability handler test");
		aHandler.getCharacterAbility(CharacterClasses.MAGE, "Shapeshifter".toUpperCase());
		out.println("Passed");
		
	}
	
	@Test
	void testAbility()
	{
		out.println("Abilities check");
		ArrayList<Ability> abilities = aHandler.getCharacterAbility(CharacterClasses.MAGE, CharacterSpecializations.MageType.SHAPESHIFTER.name().toUpperCase());
		assertEquals(abilities.get(0).getAbName(), "MageAbility");
		out.println("Passed");
	}
	
}
