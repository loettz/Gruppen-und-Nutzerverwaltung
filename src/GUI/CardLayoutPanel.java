package GUI;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class CardLayoutPanel extends JPanel{
	private Frame frame;
		
	JPanel mainP = new MainPanel(frame, this);
	JPanel createUserP = new CreateUserPanel(frame, this);
	JPanel createGroupP = new CreateGroupPanel(frame, this);
	JPanel showGroupsP = new ShowGroupsPanel(frame, this);
	
	public CardLayoutPanel() {
		cards();
	}
	
	
	public void cards() {
		setLayout(new CardLayout());
		add(mainP, frame.MAINPANEL);
		add(createUserP, frame.CREATEUSER);
		add(createGroupP, frame.CREATEGROUP);
		add(showGroupsP, frame.SHOWGROUPS);
	}

}
