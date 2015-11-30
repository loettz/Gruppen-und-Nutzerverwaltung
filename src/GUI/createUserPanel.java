package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class createUserPanel extends JPanel{

	private JPanel createUserTitlePanel;
	private JPanel createUserButtonPanel;
	private JPanel createUserActionPanel;
	private GUIHelper guihelper = new GUIHelper();
	
	public createUserPanel() {
		createUser();
	}

public void createUser() {
	setLayout(new GridLayout(3, 1));
	setPreferredSize(new Dimension(600, 600));
	setVisible(true);
	
	createUserTitlePanel = guihelper.setPanel();
	JLabel createUserTitle = guihelper.setLabel("Teilnehmer erstellen", 36);
	createUserTitlePanel.add(createUserTitle);
	
	createUserButtonPanel = guihelper.setPanel();
	JButton save = guihelper.setButton("Speichern");
	JButton back = guihelper.setButton("Zurück ins Menü");
	createUserButtonPanel.add(save);
	createUserButtonPanel.add(back);
		
	
	createUserActionPanel = guihelper.setPanelWithGrid(200, 400, 2, 2);
	JLabel nameLabel = guihelper.setLabel("Name:", 14);
	JTextField name = guihelper.setTextField();
	JLabel givenNameLabel = guihelper.setLabel("Vorname:", 14);
	JTextField givenName = guihelper.setTextField();
	createUserActionPanel.add(nameLabel);
	createUserActionPanel.add(name);
	createUserActionPanel.add(givenNameLabel);
	createUserActionPanel.add(givenName);
	
	add(createUserTitlePanel);
	add(createUserButtonPanel);
	add(createUserActionPanel);
}
}
