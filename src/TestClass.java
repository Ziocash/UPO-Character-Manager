import static java.lang.System.out;
import org.junit.jupiter.api.Test;

import handlers.FileHandler;
import internal.classes.BerserkerClass;

class TestClass 
{
	@Test
	void test() 
	{
		FileHandler fh = new FileHandler();
		out.println(fh.getFilePath());
		out.println(fh.readFile());
		BerserkerClass bers = new BerserkerClass(1);
		bers.setName("Sgravo simulator");
		out.println(bers.getId()+"|"+bers.getName()+"|"+bers.getConstitution());
		//out.println("ELLAMADONNA SE SEI SGRAVO");
	}

}
