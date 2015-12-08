package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
		
	public static int MAINPANELL = 0;
	public static int CREATEUSERR = 1;
	
	final static String MAINPANEL = "Card with main";
	final static String CREATEUSER = "Card with createuser";
	
	JPanel cards = new JPanel();
	JPanel mainP = new mainPanel(this);
	JPanel createUserP = new createUserPanel();
	
	
	public Frame() {
		super();
		createFrame();
		setCardLayoutPanel();
		switchPanel(0);
	}
	
	public void createFrame() {
		setPreferredSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		pack();
		setVisible(true);	
	}
	
	public void setCardLayoutPanel() {
		cards.setLayout(new CardLayout());
		cards.add(mainP, MAINPANEL);
		cards.add(createUserP, CREATEUSER);
		this.add(cards);
		
	}
	
	public void switchPanel(int panelNumber){

		CardLayout cl = (CardLayout)(cards.getLayout());
		switch(panelNumber){
		case 0: cl.show(cards, MAINPANEL); break;
			
		case 1: cl.show(cards, CREATEUSER); break;
		}
		

		this.pack();
	}

}
