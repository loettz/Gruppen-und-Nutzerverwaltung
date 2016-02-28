package GUI;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class MainCardLayoutPanel extends JPanel{
	private Frame frame;
		
	JPanel mainP = new MainPanel(frame, this);
	JPanel createUserP = new UserAdministrationPanel(frame, this);
	JPanel createGroupP = new GroupAdministrationPanel(frame, this);
	JPanel showGroupsP = new EditGroupsPanel(frame, this);
	
	public MainCardLayoutPanel() {
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
