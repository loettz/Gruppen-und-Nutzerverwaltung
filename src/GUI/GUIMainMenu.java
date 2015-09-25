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
		final JFrame frame = guihelper.setFrame(600, 600);
		
		//final JPanel mainPanel = guihelper.setPanelWithGrid(600, 600, 3, 1);
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
		
		frame.add(menuTitlePanel);
		frame.add(menuButtonPanel);
		frame.add(menuActionPanel);
			
		guihelper.endFrame();
		//frame.getContentPane().add(mainPanel);
		
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICreateUser createuser = new GUICreateUser();
				final JPanel createUserTitle = createuser.createUserTitle();
				final JPanel createUserButton = createuser.createUserButton();
				final JPanel createUserAction = createuser.createUserAction();
				JButton back = guihelper.setButton("Zurück ins Menü");
				createUserButton.add(back);
				frame.removeAll();
				frame.add(createUserTitle);
				frame.add(createUserButton);
				frame.add(createUserAction);
				frame.revalidate();
				frame.repaint();
				
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.removeAll();
						//mainPanel.remove(createUserButton);
						//mainPanel.remove(createUserAction);
						
						frame.add(menuTitlePanel);
						frame.add(menuButtonPanel);
						frame.add(menuActionPanel);
						
						frame.revalidate();
						frame.repaint();
						
					}
				});
			}
		});
		
		
	}
	
}
