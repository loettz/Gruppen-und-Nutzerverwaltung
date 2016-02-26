package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diesisteinprojekt.DBHandler;
import diesisteinprojekt.Group;

public class CreateGroupRandomPanel extends JPanel{
	
	protected DBHandler dbhandler = new DBHandler();
	protected GUIHelper guihelper = new GUIHelper();
	private JButton save;
	private JLabel groupNameLabel;
	private JTextField groupName;
	private JLabel groupSizeLabel;
	private JButton groupSizeButton;
	private String groupSize;
	
	public CreateGroupRandomPanel() {
		setPanel();
		installListener();
	}
	
	public void setPanel() {
		setPreferredSize(new Dimension(580, 180));
		setLayout(new GridLayout(2, 2));
		setBackground(Color.white);
		save = guihelper.setButton("Speichern");
		groupNameLabel = guihelper.setLabel("Gruppenname: ", 14);
		groupName = guihelper.setTextField();
		groupSizeLabel = guihelper.setLabel("", 14);
		groupSizeButton = guihelper.setButton("Anzahl bestimmen");
		add(groupNameLabel);
		add(groupName);
		add(groupSizeButton);
		add(groupSizeLabel);
		
	}
	public boolean validateTextField(JTextField text) {
		if (text.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Es gab einen Fehler bei der Eingabe!");
			return false;
			
		}
		return true;
	}
	public void saveDataAndResetPanel() {
		try {
			if (validateTextField(groupName)) {
					Group group = new Group();
					group.setName(groupName.getText());
					group.setSize(Integer.parseInt(groupSize));
					dbhandler.saveGroup(group);
					groupName.setText("");
					groupSizeLabel.setText("");
					JOptionPane.showMessageDialog(CreateGroupRandomPanel.this, "Gruppe erstellt!");
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(CreateGroupRandomPanel.this, "Es gab einen Fehler bei der Eingabe!");
		}
	}

	public void installListener(){

		
		groupSizeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				groupSize = (String) JOptionPane.showInputDialog(null, "Die Anzahl der Teilnehmer kann hier bestimmt werden.", "Gruppengröße auswählen",
				        JOptionPane.QUESTION_MESSAGE, null, new String[] {"5", "6", "7", "8"}, "");
				groupSizeLabel.setText(groupSize);
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				saveDataAndResetPanel();
			}
		});
	}

}
