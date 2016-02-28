package GUI;

import java.awt.CardLayout;
import java.awt.Color;
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

import diesisteinprojekt.DBHandler;
import diesisteinprojekt.User;

public class CreateUserPanel extends JPanel{

	protected DBHandler dbhandler = new DBHandler();
	protected GUIHelper guihelper = new GUIHelper();
	private JButton save;

	
	private JLabel nameLabel;
	private JTextField name;
	private JLabel givenNameLabel;
	private JTextField givenName;
	private JLabel birthDateLabel;
	private JTextField birthDate;
	CLUserAdministrationPanel clCards;

	private static final DateFormat GER_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	
	public CreateUserPanel(CLUserAdministrationPanel clCards) {
		this.clCards = clCards;
		setPanel();
		installListener();
	}
	
	public void setPanel() {
		
		setPreferredSize(new Dimension(580, 180));
		setLayout(new GridLayout(4, 3));
		setBackground(Color.white);
		save = guihelper.setButton("Speichern");
		nameLabel = guihelper.setLabel("Name:", 14);
		name = guihelper.setTextField();
		givenNameLabel = guihelper.setLabel("Vorname:", 14);
		givenName = guihelper.setTextField();
		birthDateLabel = guihelper.setLabel("Geburtsdatum:", 14);
		birthDate = guihelper.setTextField();
		add(givenNameLabel);
		add(givenName);
		add(nameLabel);
		add(name);
		add(birthDateLabel);
		add(birthDate);
		add(save);
		
	}
	
	public boolean validateTextField(JTextField text) {
		if (text.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Es gab einen Fehler bei der Eingabe!");
			return false;
			
		}
		return true;
	}
	public boolean validateInput() {
		if (validateTextField(givenName) && validateTextField(name)) {
			return true;
		
		}
		return false;
	}
	
	public void saveDataAndResetPanel() {
		try {
			if (validateInput()) {
				User user = new User();
				user.setGivenName(givenName.getText());
				user.setName(name.getText());
				user.setAge(GER_DATE_FORMAT.parse(birthDate.getText()));
				dbhandler.saveUser(user);
				givenName.setText("");
				name.setText("");
				birthDate.setText("");
				CardLayout cl = (CardLayout)(clCards.getLayout());
				cl.show(clCards, Frame.USERSAVED);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(CreateUserPanel.this, "Es gab einen Fehler bei der Eingabe!");
		}
	}
	public void installListener(){
		
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveDataAndResetPanel();
				
			}
		});
	
	}
}
