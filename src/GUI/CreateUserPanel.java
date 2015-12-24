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

public class CreateUserPanel extends MAINMainPanel {

	private JLabel createUserTitle;
	
	private JButton save;
	private JButton back;
	
	private JLabel nameLabel;
	private JTextField name;
	private JLabel givenNameLabel;
	private JTextField givenName;

	
	public CreateUserPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	
	public void setPanels() {
		
		createUserTitle = guihelper.setLabel("Teilnehmer erstellen", 36);
		TitlePanel.add(createUserTitle);
		
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		
		ButtonPanel.add(save);
		ButtonPanel.add(back);
		
		ActionPanel.setLayout(new GridLayout(2, 2));
		
		nameLabel = guihelper.setLabel("Name:", 14);
		name = guihelper.setTextField();
		givenNameLabel = guihelper.setLabel("Vorname:", 14);
		givenName = guihelper.setTextField();
		
		ActionPanel.add(nameLabel);
		ActionPanel.add(name);
		ActionPanel.add(givenNameLabel);
		ActionPanel.add(givenName);	
		
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
