package GUI;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CLUserAdministrationPanel extends JPanel{
	private Frame frame;
	protected GUIHelper guihelper = new GUIHelper();
	JPanel emptyPanel = new JPanel();
	JPanel createUser = new CreateUserPanel(this);
	JPanel userSavedPanel = new JPanel();
	JLabel saved = guihelper.setLabel("Teilnehmer gespeichert!", 24);
	
	public CLUserAdministrationPanel() {
		cards();
	}
	
	public void cards() {
		emptyPanel.setBackground(Color.white);
		userSavedPanel.setBackground(Color.white);
		userSavedPanel.add(saved);
		setLayout(new CardLayout());
		add(emptyPanel, frame.EMPTY);
		add(createUser, frame.CREATEUSER);
		add(userSavedPanel, frame.USERSAVED);
	}

}
