package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		TitlePanel.setBackground(Color.white);
		add(ButtonPanel);
		ButtonPanel.setBackground(Color.white);
		add(ActionPanel);
		ActionPanel.setBackground(Color.white);
		setVisible(true);
}
	public abstract void setPanels();
	
	public abstract void installListener();
	
	public boolean validateTextField(JTextField text) {
		if (text.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Es gab einen Fehler bei der Eingabe!");
			return false;
			
		}
		return true;
	}
}
