import java.awt.EventQueue;

import windows.MainWindow;

public class Main
{
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(
        		new Runnable()
        		{
        			public void run()
        			{
        				try 
        				{
        					MainWindow mw = new MainWindow();
        					mw.show();        					
        				}
        				catch(Exception ex)
        				{
        					ex.printStackTrace();
        				}
        			}
        		});
    }
}