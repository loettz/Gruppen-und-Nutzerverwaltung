package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ALTGUICreateUser {
	
	
	public JPanel createUserTitle() {
		GUIHelper guihelper = new GUIHelper();
		JPanel createUserTitlePanel = guihelper.setPanel();
		createUserTitlePanel.setBackground(Color.white);
		JLabel createUserTitle = guihelper.setLabel("Teilnehmer erstellen", 36);
		createUserTitlePanel.add(createUserTitle);
		return createUserTitlePanel;
	}
	
	public JPanel createUserButton() {
		GUIHelper guihelper = new GUIHelper();
		JPanel createUserButtonPanel = guihelper.setPanel();
		createUserButtonPanel.setBackground(Color.white);
		JButton save = guihelper.setButton("Speichern");
		createUserButtonPanel.add(save);
		return createUserButtonPanel;
	}
	
	public JPanel createUserAction() {
		GUIHelper guihelper = new GUIHelper();
		JPanel createUserActionPanel = guihelper.setPanelWithGrid(200, 400, 2, 2);
		createUserActionPanel.setBackground(Color.white);
		JLabel nameLabel = guihelper.setLabel("Name:", 14);
		JTextField name = guihelper.setTextField();
		JLabel givenNameLabel = guihelper.setLabel("Vorname:", 14);
		JTextField givenName = guihelper.setTextField();
		createUserActionPanel.add(nameLabel);
		createUserActionPanel.add(name);
		createUserActionPanel.add(givenNameLabel);
		createUserActionPanel.add(givenName);
		
		
		return createUserActionPanel;
	}
}
