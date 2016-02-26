package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
		
	
	public final static String MAINPANEL = "Card with main";
	public final static String CREATEUSER = "Card with createuser";
	public final static String CREATEGROUP = "Card with creategroup";
	public final static String SHOWGROUPS = "Card with showgroups";
	public final static String EMPTY = "Empty card";
	public final static String CREATEGROUPRANDOM = "create random group";
	public final static String GROUPSAVED = "group is saved";
	
	
	
	public JPanel cards = new CardLayoutPanel();
	//JPanel mainP = new mainPanel(this);
	//JPanel createUserP = new createUserPanel();
	
	
	public Frame() {
		super();
		createFrame();
		//setCardLayoutPanel();
		//switchPanel(0);
	}
	
	public void createFrame() {
		setPreferredSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		add(cards);
		pack();
		setVisible(true);	
	}
	

}
