package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CLGroupAdministrationPanel extends JPanel{
	private Frame frame;
	protected GUIHelper guihelper = new GUIHelper();
	JPanel emptyPanel = new JPanel();
	JPanel createGroup = new CreateGroupRandomPanel();
	JPanel groupSavedPanel = new JPanel();
	JLabel saved = guihelper.setLabel("Gruppe gespeichert", 24);
	
	public CLGroupAdministrationPanel() {
		cards();
	}

	
	
	public void cards() {
		emptyPanel.setBackground(Color.white);
		groupSavedPanel.setBackground(Color.white);
		groupSavedPanel.add(saved);
		setLayout(new CardLayout());
		add(emptyPanel, frame.EMPTY);
		add(createGroup, frame.CREATEGROUPRANDOM);
		add(groupSavedPanel, frame.GROUPSAVED);
	}
	

}
