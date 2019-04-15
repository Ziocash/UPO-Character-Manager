import static java.lang.System.out;
import org.junit.jupiter.api.Test;

import handlers.FileHandler;

class TestClass 
{
	@Test
	void test() 
	{
		FileHandler fh = new FileHandler();
		out.println(fh.getFilePath());
		out.println(fh.readFile());
	}

}
