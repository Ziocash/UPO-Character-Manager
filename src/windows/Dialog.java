package windows;

import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;

import javax.swing.JDialog;
import javax.swing.JFrame;

public abstract class Dialog
{
	/**
	 * 
	 */
	protected JDialog dialog;
	
	/**
	 * 
	 */
	protected JFrame owner;
	
	protected void setCloseOperation(int onClose) 
	{
		dialog.setDefaultCloseOperation(onClose);
	}

	protected void setDialogProperties(boolean resizable, int width, int height, JFrame owner) 
	{
		dialog.setBounds(0, 0, width, height);
		dialog.setResizable(resizable);
		dialog.setLocationRelativeTo(owner);
		this.owner = owner;
	}
	
	protected void setModality(ModalityType modType)
	{
		dialog.setModalityType(modType);
	}
	
	protected void setTitle(String title)
	{
		dialog.setTitle(title);
	}
	
	protected void setType(Type type) 
	{
		dialog.setType(type);
	}
	
	protected void initializeComponents()
	{
		dialog = new JDialog();
	}
	
	/**
	 * 
	 */
	public void show()
	{
		dialog.setModalityType(ModalityType.MODELESS);
		dialog.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void showDialog()
	{
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.setVisible(true);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isShown()
	{
		return dialog.isVisible();
	}
	
	/**
	 * 
	 */
	public void close()
	{
		dialog.setVisible(false);
		dialog.dispose();
	}
}
