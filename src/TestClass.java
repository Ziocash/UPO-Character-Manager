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
		FileHandler fh = new FileHandler();
		out.println(fh.getFilePath());
		out.println(fh.readFile());
		out.println("Last ID: " + fh.getLastID());
		BerserkerClass bers = new BerserkerClass(1);
		bers.setName("Sgravo simulator");
		out.println(bers.getId()+"|"+bers.getName()+"|"+bers.getConstitution());
		CharacterHandler<BerserkerClass> ch = new CharacterHandler<BerserkerClass>();
		ch.addCharacter(bers);
		out.println(ch.getCharactersList());
		out.println("Characters in list: " + ch.countCharacters());
		MainWindow mw = new MainWindow();
		mw.show();
		out.println(mw.isShown());
		
	}

}
