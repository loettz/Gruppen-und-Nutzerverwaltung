package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class createGroupPanel extends JPanel{
	
	private JPanel createGroupTitlePanel;
	private JPanel createGroupButtonPanel;
	private JPanel createGroupActionPanel;
	private JLabel createGroupTitle;
	private JButton save;
	private JButton back;
	private JLabel groupSizeLabel;
	private JTextField groupSize;
	private JButton create;
	private GUIHelper guihelper = new GUIHelper();
	
	public createGroupPanel() {
		createGroup();
	}
	
	public void createGroup() {
		
		setLayout(new GridLayout(3, 1));
		setPreferredSize(new Dimension(600, 600));
		setVisible(true);
		
		createGroupTitlePanel = guihelper.setPanel();
		createGroupTitle = guihelper.setLabel("Gruppe erstellen", 36);
		createGroupTitlePanel.add(createGroupTitle);
		
		createGroupButtonPanel = guihelper.setPanel();
		save = guihelper.setButton("Speichern");
		back = guihelper.setButton("Zurück ins Menü");
		createGroupButtonPanel.add(save);
		createGroupButtonPanel.add(back);
		
		createGroupActionPanel = guihelper.setPanelWithGrid(200, 400, 2, 1);
		groupSizeLabel = guihelper.setLabel("Anzahl Teilnehmer:", 14);
		groupSize = guihelper.setTextField();
		create = guihelper.setButton("Gruppe erstellen");
		createGroupActionPanel.add(groupSizeLabel);
		createGroupActionPanel.add(groupSize);
		createGroupActionPanel.add(create);
		
		add(createGroupTitlePanel);
		add(createGroupButtonPanel);
		add(createGroupActionPanel);
		

		
		
	}

}
