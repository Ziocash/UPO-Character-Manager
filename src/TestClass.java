import static java.lang.System.out;

//import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import handlers.*;
import windows.MainWindow;

class TestClass 
{
	@Test
	void test() 
	{
		//Instances
		//FileHandler fh = new FileHandler();
		CharacterHandler ch = new CharacterHandler();
		//FileHandler test
		String line="Wizardous witness|1|30.0|200.0|MAGE|ARCANE WARRIOR";
		out.println(fh.getFilePath());
		out.println(fh.getDb());
		fh.addLine(line);
		line="Wizardous witness|1|40.0|320.0|MAGE|ARCANE WARRIOR";
		fh.writeLine(line, 3);
		out.println(fh.writeFile());
		out.println(fh.getDb());
		//--------------- MainWindow test -----------------------------------
		MainWindow mw = new MainWindow();
		mw.show();
		out.println(mw.isShown());
		//
		while(mw.isShown())
			continue;
		
	}
}
