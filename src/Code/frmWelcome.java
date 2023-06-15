package Code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmWelcome {

	private JFrame frmWelcome; //declaring jframe

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmWelcome window = new frmWelcome();//creating new instance of the form
					window.frmWelcome.setVisible(true);//visible the form
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//return to input window
private void Close() {
frmWelcome.dispose();
	
}

	//Create the application.
	public frmWelcome() {
		initialize();
	}

	//Initialise the contents of the frame.
	private void initialize() {
		frmWelcome = new JFrame();//intiating  jrame
		frmWelcome.setTitle("Welcome");//setting title
		frmWelcome.setBounds(100, 100, 565, 329);//setting position
		frmWelcome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//setting default close operation
		frmWelcome.getContentPane().setLayout(null);//removing default layout
		
		JLabel lblNewLabel = new JLabel("Welcome to my program"); //setting text of the jlabe
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 36));//setting font
		lblNewLabel.setBounds(46, 122, 448, 43);//setting position
		frmWelcome.getContentPane().add(lblNewLabel);//setting the content into layout
		
		JLabel lblHello = new JLabel("Hello.");//setting text
		lblHello.setFont(new Font("Arial", Font.BOLD, 72));//declaring font
		lblHello.setBounds(36, 21, 292, 90);//setting position
		frmWelcome.getContentPane().add(lblHello);//adding components into layout
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {//defining button click event
			public void actionPerformed(ActionEvent arg0) {
			//open the input form
				frmInputDetails frm = new frmInputDetails();
				frm.setVisible(true);
				Close();
			}
			
		});
		btnEnter.setBounds(223, 200, 89, 23);
		frmWelcome.getContentPane().add(btnEnter);
	}
	
}
