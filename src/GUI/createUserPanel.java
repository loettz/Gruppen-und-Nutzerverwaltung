package GUI;

import java.awt.CardLayout;
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
	private JLabel createUserTitle;
	
	private JButton save;
	private JButton back;
	
	private JLabel nameLabel;
	private JTextField name;
	private JLabel givenNameLabel;
	private JTextField givenName;
	
	private Frame frame;
	private cardLayoutPanel cards;
	
	private GUIHelper guihelper = new GUIHelper();
	
	public createUserPanel(Frame frame, cardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
		createUser();
		installListener();
	}

public void createUser() {
	setLayout(new GridLayout(3, 1));
	setPreferredSize(new Dimension(600, 600));
	setVisible(true);
	
	createUserTitlePanel = guihelper.setPanel();
	createUserTitle = guihelper.setLabel("Teilnehmer erstellen", 36);
	createUserTitlePanel.add(createUserTitle);
	
	createUserButtonPanel = guihelper.setPanel();
	save = guihelper.setButton("Speichern");
	back = guihelper.setButton("Zurück ins Menü");
	createUserButtonPanel.add(save);
	createUserButtonPanel.add(back);
		
	
	createUserActionPanel = guihelper.setPanelWithGrid(200, 400, 2, 2);
	nameLabel = guihelper.setLabel("Name:", 14);
	name = guihelper.setTextField();
	givenNameLabel = guihelper.setLabel("Vorname:", 14);
	givenName = guihelper.setTextField();
	createUserActionPanel.add(nameLabel);
	createUserActionPanel.add(name);
	createUserActionPanel.add(givenNameLabel);
	createUserActionPanel.add(givenName);
	
	add(createUserTitlePanel);
	add(createUserButtonPanel);
	add(createUserActionPanel);
}

public void installListener(){
	back.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			
			CardLayout cl = (CardLayout)(cards.getLayout());
			cl.show(cards, Frame.MAINPANEL);
		}
	});
	
}
}
