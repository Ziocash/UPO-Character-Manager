import static java.lang.System.out;
import org.junit.jupiter.api.Test;

import handlers.CharacterHandler;
import handlers.FileHandler;
import internal.classes.BerserkerClass;
import windows.MainWindow;

class TestClass 
{
	@Test
	void test() 
	{
		//Instances
		FileHandler fh = new FileHandler();
		BerserkerClass bers = new BerserkerClass(1);
		CharacterHandler<BerserkerClass> ch = new CharacterHandler<BerserkerClass>();
		
		//FileHandler test
		out.println(fh.getFilePath());
		out.println(fh.readFile());
		out.println("Last ID: " + fh.getLastID());

		//BerserkerClass insertion test
		bers.setName("Sgravo simulator");
		out.println(bers.getId()+"|"+bers.getName()+"|"+bers.getConstitution());
		
		//CharacterHandler insertion testing
		ch.addCharacter(bers);
		out.println(ch.getCharactersList());
		out.println("Characters in list: " + ch.countCharacters());
		
		//--------------- MainWindow test -----------------------------------
		MainWindow mw = new MainWindow();
		mw.show();
		out.println(mw.isShown());

		//
		for(BerserkerClass b : ch.getCharactersList())
			mw.appendText(b.toString() + "\n");
		
		//
		while(mw.isShown()){}
		
	}

}
