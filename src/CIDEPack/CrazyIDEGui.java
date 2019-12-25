package CIDEPack;

import java.util.*;
import javax.swing.*;

public class CrazyIDEGui extends JFrame
{
	private String m_name;
	private int m_width;
	private int m_height;
	
	public CrazyIDEGui(String name)
	{
		super(name);
		
		m_name = name;
		
		m_width = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		m_height = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		
		setSize(m_width, m_height);
		setVisible(true);
	}
}