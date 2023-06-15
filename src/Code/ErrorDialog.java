package Code;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ErrorDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();

	//Launch the application
	public static void main(String[] args) {
		try {
			ErrorDialog dialog = new ErrorDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//setting default on close operation
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//return to input window
private void Close() {
	this.dispose();
	
}
	//Create the dialog
	public ErrorDialog() {
		setBounds(100, 100, 510, 300);//setting position
		getContentPane().setLayout(new BorderLayout());//defining new border layout
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));//setting border width in top,bottom,left and right
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);//removing default layout
		{
			JLabel label = new JLabel("Invalid Input");//setting text
			label.setFont(new Font("Arial", Font.BOLD, 72));//setting font 
			label.setBounds(10, 21, 484, 100);//setting postion of this component
			contentPanel.add(label);//add component into the layout
		}
		{
			//Message displayed that input was valid
			JLabel label = new JLabel("<html>The value you entered is invalid.<br>Please enter a value from 1-20 seconds.</html>");
			label.setFont(new Font("Arial", Font.PLAIN, 18));//setting up the font
			label.setBounds(20, 128, 464, 65);//setting the level position
			contentPanel.add(label);//adding this jlabel in contentPanel
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));//setting button position 
			getContentPane().add(buttonPane, BorderLayout.SOUTH);//adding button into the layout
			{
				JButton button = new JButton("Try Again");//deifning button action
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//closes the form
Close();
					}
				});
				buttonPane.add(button);
			}
		}
	}

}
