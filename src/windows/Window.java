package windows;

import java.awt.Component;
import java.awt.Window.Type;

import javax.swing.JFrame;

public abstract class Window
{
	/**
	 * 
	 */
	protected JFrame owner;
	
	/**
	 * 
	 */
	protected JFrame frame;
	
	/**
	 * 
	 */
	protected void initializeComponents()
	{
		frame = new JFrame();	
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	protected boolean setType(Type type)
	{
		frame.setType(type);
		return frame.getType() == type;
	}
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	protected boolean setTitle(String title)
	{
		frame.setTitle(title);
		return frame.getTitle() == title;
	}
	
	/**
	 * 
	 * @param operation
	 * @return
	 */
	protected boolean setCloseOperation(int operation)
	{
		frame.setDefaultCloseOperation(operation);
		return frame.getDefaultCloseOperation() == operation;
	}
	
	/**
	 * 
	 * @param resize
	 * @param width
	 * @param height
	 * @param relativeTo
	 */
	protected void setFrameProperties(boolean resize, int width, int height, Component relativeTo)
	{
		frame.setResizable(resize);		
		frame.setBounds(0, 0, width, height);
		frame.setLocationRelativeTo(relativeTo);
	}
	
	/**
	 * 
	 */
	public void show()
	{
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isShown()
	{
		return frame.isVisible();
	}
	
	/**
	 * 
	 */
	public void close()
	{
		frame.setVisible(false);
		frame.dispose();
	}
}
