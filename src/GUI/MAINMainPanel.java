package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import diesisteinprojekt.DBHandler;

public abstract class MAINMainPanel extends JPanel{

	protected JPanel TitlePanel = new JPanel();
	protected JPanel ButtonPanel = new JPanel();
	protected JPanel ActionPanel = new JPanel();
	protected JLabel TitleLabel = new JLabel();
	
	protected Frame frame;
	protected CardLayoutPanel cards;
	
	protected GUIHelper guihelper = new GUIHelper();
	
	protected DBHandler dbhandler = new DBHandler();
	
	public MAINMainPanel() {
		createMAINMainPanel();
		setPanels();
		installListener();

	}
	
	public void createMAINMainPanel() {
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		add(TitlePanel);
		add(ButtonPanel);
		add(ActionPanel);
		setVisible(true);
}
	public abstract void setPanels();
	
	public abstract void installListener();
}
