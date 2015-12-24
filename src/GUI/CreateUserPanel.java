package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diesisteinprojekt.User;

public class CreateUserPanel extends MAINMainPanel {

	private JLabel createUserTitle;
	
	private JButton save;
	private JButton back;
	
	private JLabel nameLabel;
	private JTextField name;
	private JLabel givenNameLabel;
	private JTextField givenName;
	private JLabel birthDateLabel;
	private JTextField birthDate;

	private static final DateFormat GER_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
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
		
		ActionPanel.setLayout(new GridLayout(3, 3));
		
		nameLabel = guihelper.setLabel("Name:", 14);
		name = guihelper.setTextField();
		givenNameLabel = guihelper.setLabel("Vorname:", 14);
		givenName = guihelper.setTextField();
		birthDateLabel = guihelper.setLabel("Geburtsdatum", 14);
		birthDate = guihelper.setTextField();
		
		
		ActionPanel.add(nameLabel);
		ActionPanel.add(name);
		ActionPanel.add(givenNameLabel);
		ActionPanel.add(givenName);	
		ActionPanel.add(birthDateLabel);
		ActionPanel.add(birthDate);
		
	}
	public void installListener(){
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, Frame.MAINPANEL);
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					User user = new User();
					user.setGivenName(givenName.getText());
					user.setName(name.getText());
					user.setAge(GER_DATE_FORMAT.parse(birthDate.getText()));
					dbhandler.saveUser(user);
					givenName.setText("");
					name.setText("");
					birthDate.setText("");
					JOptionPane.showMessageDialog(CreateUserPanel.this, "Teilnehmer erstellt!");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
	}
}
