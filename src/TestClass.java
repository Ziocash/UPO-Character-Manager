import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import handlers.*;
import internal.classes.Character;
import internal.classes.CharacterClasses;
import internal.classes.CharacterSpecializations;

class TestClass 
{
	CharacterHandler characterHandler = new CharacterHandler();
	Character character = new internal.classes.Character(1);
	FileHandler fHandler = new FileHandler();
	@Test
	void testAddLine() 
	{		
		assertEquals(characterHandler.addLine("Test|0|30.0|30.0|30.0|30.0|30.0|MAGE|ARCANE WARRIOR"), true);		
		character.setAll("Test", CharacterClasses.MAGE, CharacterSpecializations.MageType.ARCANE_WARRIOR.toString());
		assertEquals(character.compareTo(characterHandler.getCharactersList().get(0)), 0);		
	}
	
	@Test
	void testSetDB()
	{
		fHandler.setDb(characterHandler.parseList());
		assertEquals(fHandler.getDb(), characterHandler.parseList());
	}
	
	@Test
	void testWriteFile()
	{
		assertEquals(fHandler.writeFile(), true);
	}
}
