package GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.fabric.xmlrpc.base.Array;

import diesisteinprojekt.Group;
import diesisteinprojekt.User;

public class CreateGroupPanel extends MAINMainPanel{
	
	private JLabel createGroupTitle;
	private JButton save;
	private JButton back;
	private JLabel groupNameLabel;
	private JTextField groupName;
	private JLabel groupSizeLabel;
	private JButton groupSizeButton;
	private JButton create;
	private String groupSize;


	
	public CreateGroupPanel(Frame frame, CardLayoutPanel cards) {
		super();
		this.frame = frame;
		this.cards = cards;
	}
	public void setPanels() {
		
		createGroupTitle = guihelper.setLabel("Gruppe erstellen", 36);
		TitlePanel.add(createGroupTitle);
		
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		ButtonPanel.add(save);
		ButtonPanel.add(back);
		
		ActionPanel.setLayout(new GridLayout(2, 2));
		groupNameLabel = guihelper.setLabel("Gruppenname: ", 14);
		groupName = guihelper.setTextField();
		groupSizeLabel = guihelper.setLabel("", 14);
		groupSizeButton = guihelper.setButton("Anzahl bestimmen");
		create = guihelper.setButton("Gruppe erstellen");
		ActionPanel.add(groupNameLabel);
		ActionPanel.add(groupName);
		ActionPanel.add(groupSizeButton);
		ActionPanel.add(groupSizeLabel);

		
		
	}
	
	public void saveDataAndResetPanel() {
			Group group = new Group();
			group.setName(groupName.getText());
			group.setSize(Integer.parseInt(groupSize));
			dbhandler.saveGroup(group);
			groupName.setText("");
			groupSizeLabel.setText("");
			JOptionPane.showMessageDialog(CreateGroupPanel.this, "Gruppe erstellt!");
	}

	public void installListener(){
		back.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, Frame.MAINPANEL);
			}
		});
		
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
	