import static java.lang.System.out;
import handlers.*;
import windows.CharacterCreationWindow;
import windows.MainWindow;

public class Main
{
    public static void main(String[] args) 
    {
        //Instances
		FileHandler fh = new FileHandler();
		CharacterHandler ch = new CharacterHandler();
		ch.loadList(fh.getDb());
		String line="Wizardous witness|1|30.0|200.0|0|0|0|MAGE|ARCANE WARRIOR";
		ch.addLine(line);
		out.println(ch.getCharactersList());
		line="Wizardous witness|1|40.0|420.0|0|0|0|MAGE|ARCANE WARRIOR";
		ch.addLine(line);
		out.println(ch.getCharactersList());
		fh.setDb(ch.parseList());
		//--------------- MainWindow test -----------------------------------		
		
		CharacterCreationWindow charWindow = new CharacterCreationWindow();
		charWindow.show();
		
		MainWindow mw = new MainWindow();
		mw.show();
		out.println(mw.isShown());
		//
		while(charWindow.isShown())
		{
			fh.writeFile();
			continue;
		}
			
		
		//
    }
}