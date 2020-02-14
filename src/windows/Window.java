package windows;

import java.awt.Component;
import java.awt.Window.Type;

import javax.swing.JFrame;

public abstract class Window
{
	/**
	 * Window owner
	 */
	protected JFrame owner;
	
	/**
	 * Main frame
	 */
	protected JFrame frame;
	
	/**
	 * Initialize components
	 */
	protected void initializeComponents()
	{
		frame = new JFrame();	
	}
	
	/**
	 * Sets window type 
	 * @see java.awt.Window.Type
	 * @param type Type setter
	 * @return {@code true} if the assignment has been completed, else {@code false}
	 */
	protected boolean setType(Type type)
	{
		frame.setType(type);
		return frame.getType() == type;
	}
	
	/**
	 * Sets window title
	 * @param title Window title
	 * @return {@code true} if the assignment has been completed, else {@code false}
	 */
	protected boolean setTitle(String title)
	{
		frame.setTitle(title);
		return frame.getTitle() == title;
	}
	
	/**
	 * Sets window close operation
	 * @param operation Close operation value
	 * @return {@code true} if the assignment has been completed, else {@code false}
	 */
	protected boolean setCloseOperation(int operation)
	{
		frame.setDefaultCloseOperation(operation);
		return frame.getDefaultCloseOperation() == operation;
	}
	
	/**
	 * Sets the Window parameters
	 * @param resize Makes the window resizable 
	 * @param width Sets window width
	 * @param height Sets window height
	 * @param relativeTo Sets the window owner (typically null to set centerscreen location)
	 */
	protected void setFrameProperties(boolean resize, int width, int height, Component relativeTo)
	{
		frame.setResizable(resize);		
		frame.setBounds(0, 0, width, height);
		frame.setLocationRelativeTo(relativeTo);
	}
	
	/**
	 * Shows MainWindow
	 */
	public void show()
	{
		frame.setVisible(true);
	}
	
	/**
	 * Returns {@code true} if frame is visible else it returns {@code false}
	 * @return {@code true} if frame is visible else it returns {@code false}
	 */
	public boolean isShown()
	{
		return frame.isVisible();
	}
	
	/**
	 * Close and dispose frame
	 */
	public void close()
	{
		frame.setVisible(false);
		frame.dispose();
	}
}
