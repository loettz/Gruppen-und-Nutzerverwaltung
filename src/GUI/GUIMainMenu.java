package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIMainMenu {

	public static void main(String[] args) {
		GUIMainMenu main = new GUIMainMenu();
		main.setupGui();

	}

	private void setupGui() {
		final GUIHelper guihelper = new GUIHelper();
		JFrame frame = guihelper.setFrame();
		
		final JPanel mainPanel = guihelper.setPanelWithGrid(600, 600, 3, 1);
		final JPanel menuTitlePanel = guihelper.setPanel();
		menuTitlePanel.setBackground(Color.white);
		JLabel menuTitle = guihelper.setLabel("Hauptmenü", 36);
		menuTitlePanel.add(menuTitle);
		
		final JPanel menuButtonPanel = guihelper.setPanel();
		menuButtonPanel.setBackground(Color.white);
		JButton createUserButton = guihelper.setButton("Teilnehmer erstellen");
		JButton createGroupButton = guihelper.setButton("Gruppe erstellen");
		JButton showGroupsButton = guihelper.setButton("Gruppen anzeigen");
		menuButtonPanel.add(createUserButton);
		menuButtonPanel.add(createGroupButton);
		menuButtonPanel.add(showGroupsButton);
		
		final JPanel menuActionPanel = guihelper.setPanel();
		menuActionPanel.setBackground(Color.white);
		//JLabel menuActionLabel = guihelper.setLabel("hier passiert was...späda", 12);
		//menuActionPanel.add(menuActionLabel);
		
		mainPanel.add(menuTitlePanel);
		mainPanel.add(menuButtonPanel);
		mainPanel.add(menuActionPanel);
			
		
		frame.getContentPane().add(mainPanel);
		
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICreateUser createuser = new GUICreateUser();
				final JPanel createUserTitle = createuser.createUserTitle();
				final JPanel createUserButton = createuser.createUserButton();
				final JPanel createUserAction = createuser.createUserAction();
				JButton back = guihelper.setButton("Zurück ins Menü");
				createUserButton.add(back);
				mainPanel.removeAll();
				mainPanel.add(createUserTitle);
				mainPanel.add(createUserButton);
				mainPanel.add(createUserAction);
				mainPanel.revalidate();
				mainPanel.repaint();
				
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mainPanel.removeAll();
						//mainPanel.remove(createUserButton);
						//mainPanel.remove(createUserAction);
						
						mainPanel.add(menuTitlePanel);
						mainPanel.add(menuButtonPanel);
						mainPanel.add(menuActionPanel);
						
						mainPanel.revalidate();
						mainPanel.repaint();
						
					}
				});
			}
		});
		
		guihelper.endFrame();
	}
	
}
