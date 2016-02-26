package GUI;


import java.awt.Color;
//import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.Color;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GUIHelper {
	public JFrame frame;
	public Color customColor = new Color(15,151,60);
	public Color colorZwei = new Color(8,97,70);
	public GUIHelper() {
		this.frame = new JFrame();
	}
	/**
	 *draw the frame in the center of the screen
	 *	 
	 * @return frame
	 */
	public JFrame setFrame(int x, int y) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(new GridLayout(3, 1));
		frame.setPreferredSize(new Dimension(x, y));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);  
		return frame;
	}

	/**
	 * draw a panel
	 * 
	 * @return panel
	 */
	public JPanel setPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		return panel;
	}
	/**
	 * draw panel with grid
	 * 
	 * @param x
	 * @param y
	 * @param gridX
	 * @param gridY
	 * @return panel
	 */
	public JPanel setPanelWithGrid(int x, int y, int gridX, int gridY) {
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(gridX, gridY));
		gridPanel.setPreferredSize(new Dimension(x, y));
		gridPanel.setVisible(true);
		return gridPanel;
		
	}
	/**
	 * draw a button
	 * 
	 * @param buttonText
	 * @return button
	 */
	public JButton setButton(String buttonText) {
		JButton button = new JButton(buttonText);
		button.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		button.setForeground(colorZwei);
		return button;
	}
	
	/**
	 * draw a textfield
	 * 
	 * @return textfield
	 */
	public JTextField setTextField() {
		JTextField textfield = new JTextField();
		return textfield;
	}
	
	/**
	 * draw label
	 * 
	 * @param labelText
	 * @param size
	 * @return label
	 */
	public JLabel setLabel(String labelText, int size) {
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Source Sans Pro", Font.BOLD, size));
		label.setForeground(customColor);
		return label;
	}
	
	public void endFrame() {
		frame.pack();
		frame.setVisible(true);
	}

}
