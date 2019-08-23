import static java.lang.System.out;
import static internal.classes.CharacterSpecializations.*;

//import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import handlers.CharacterHandler;
import handlers.FileHandler;
import internal.classes.BerserkerClass;
import internal.classes.CharacterClasses;
import windows.MainWindow;

class TestClass 
{
	@Test
	void test() 
	{
		//Instances
		FileHandler fh = new FileHandler();
		
		//FileHandler test
		String line="7|Wizardous witness|1|30.0|200.0|MAGE|ARCANE WARRIOR";
		out.println(fh.getFilePath());
		out.println(fh.getDb());
		/*fh.addLine(line);
		fh.delete(2);
		line="3|Wizardous witness|1|40.0|320.0|MAGE|ARCANE WARRIOR";
		fh.writeLine(line, 3);
		out.println(fh.getDb());*/
		//--------------- MainWindow test -----------------------------------
		MainWindow mw = new MainWindow();
		mw.show();
		out.println(mw.isShown());
		
		//
		while(mw.isShown())
			continue;
		
	}

}
