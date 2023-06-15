package Code;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class frmInputDetails extends JFrame{

	//private methods can not be used by any other class outside of current class
	private JTextField txtInput; //user can input the text here
	private int tiltTime;  //if value in between 1-20 the button action will be performed otherwise it will through an exception
	private static Finch myFinch; //declaring finch object
	/**
	 * recordedTilts is an arraylist type variable where list of integers can be store
	 * <Integer> should ensure all the stored value must be integer. other types ex- float, string type data can not be stored in this arraylist 
	 * Instead of using arraylist simple integer array can be used but arraylist provides more flexibility to user to store,delete,copy,update and
	 * restore data over simple array
	 */
	private ArrayList<Integer> recordedTilts; 

	//Launch the application.
	
	public static void main(String[] args) {

		
		//start application
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();//will print exceptions in console if anything wrong 
				}
			}
		});
	}

	//Create the application.
	public frmInputDetails() {
		initialize();
		//Created Finch 
		/**
		 * object should be initiate with new keyword so that it will create a space in ram and user can use. if it not initiated and try to use
		 * its property then the object value will be null causes through a null pointer exception
		 */
				myFinch = new Finch(); 
				//Set Colour to white
				myFinch.setLED(255,255,255);// setting the rgb color . rgb(255,255,255) will display white color
				
				//Buzz
				myFinch.buzz(440,500);//input frequency and time. 
				
	}

	
	 //Initialise the contents of the frame.
	private void initialize() {
	
	
		setTitle("Tilt The Finch "); //setting up the title
		setBounds(100, 100, 562, 325); //Declaring the frame position and height, width. 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting default on close operation (the cross button action)
		getContentPane().setLayout(null);//removing default layout
		
		
		JLabel label = new JLabel("Hello."); //declaring jlabel text
		label.setFont(new Font("Arial", Font.BOLD, 72));//defining fonts
		label.setBounds(10, 11, 292, 90);//setting position of this jlabel component
		getContentPane().add(label);//adding the declared jlabel in the layout
		
		JLabel label_1 = new JLabel("Welcome to my program"); //declaring jlabel text
		label_1.setFont(new Font("Arial", Font.PLAIN, 36));//defining fonts
		label_1.setBounds(20, 112, 448, 43);//setting position of this jlabel component
		getContentPane().add(label_1);//adding the declared another jlabel in the layout
		
		JLabel lblNewLabel = new JLabel("Enter your Input"); 
		lblNewLabel.setBounds(30, 166, 95, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblHowTilts = new JLabel(" How much seconds should the tilts be recorded for?");
		lblHowTilts.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHowTilts.setBounds(273, 234, 259, 25);
		getContentPane().add(lblHowTilts);
		
		txtInput = new JTextField(); //initiating textinput field that will accept input from user
		txtInput.setBounds(146, 166, 207, 20);//setting up the postion of this component
		getContentPane().add(txtInput);//set into the layout with defined position
		txtInput.setColumns(10);//define the width of this component. if user define its value greater than 10 the width size will increase more
		
		JButton btnEnter = new JButton("Enter"); //defining the jbutton
		btnEnter.addActionListener(new ActionListener() { //defining action for this button which will execute when user click on it
			public void actionPerformed(ActionEvent e) {
				try { //during the string to number conversion if user not entered numeric number then it will through an exception
					tiltTime = Integer.parseInt(txtInput.getText().toString().trim());//converting string to integer;trim() method use if there any space
																		//after adding writing the input it will autometically remove the last space
																		//space also will be considered as a non numeric number which will generate an error
					if(tiltTime < 1) { //if the time less than 1 ex-0,-1,-2 ... then it will enter this block
						throw new Exception(); //throuhg an exception
					}else if(tiltTime>20) {//if the time grater than 20 ex: 21,22,23 ... then it will enter this block
						throw new Exception();//throuhg an exception
					}
						
				} catch (Exception e2) { //if any exception occur in try block then it will enter into the catch block
					//Show error form
					ErrorDialog dialog = new ErrorDialog(); //initiating ErrorDialog object which declared as ErrorDialog.java 
					dialog.setVisible(true); //will display the ErrorDialog.java frame
					//Can't proceed with invalid input
					return; //exit the button click event and no other code which written bellow won't execute .
				}
				//if we reach here the inputs are correct
				recordingOfTilt();
				//Buzz and white LED to show recording
				myFinch.buzz(440, 1000); //frequecy and time param
				myFinch.setLED(255, 255, 255, 1000); //255,255,255 is defining the color of the led (255,255,255 means white) and 1000 is the milliseconds time 
													//what is time duration of this led
				}
		});
		btnEnter.setBounds(153, 200, 89, 23); //setting the "Enter" button position
		
		getContentPane().add(btnEnter);//setting the button into the layout
		
		JButton btnQuit = new JButton("Quit"); //setting the quit button
		btnQuit.addActionListener(new ActionListener() { //defining quick button action event
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//exit the application
			}
		});
		btnQuit.setBounds(153, 234, 89, 23);//setting this button position
		getContentPane().add(btnQuit);//adding the button into the layout
	}
	
	public void recordingOfTilt() {
		//Records the tilts
		
		/*Let Beak Up = 0
		Beak Down = 1
		Beak Left = 2
		Beak Right = 3
		Level = 4 */
		
		//Array list is created and only accepts integers up to 10 
		//and recording starts with LED, array list is fast 
		recordedTilts = new ArrayList<Integer>();
		
		myFinch.setLED(255, 0, 0);
		
		//The Finch loops to the seconds input converted to milliseconds
		/**
		 * here t=0 means the loop start iterating from value 0
		 * t<some value this is the condition of breaking the loop
		 * t++ after executing this full block which enclosed in curl parenthesis {} the value of t will increment by 1
		 * example if the value would for(t=0;t< 20 ;t++) then this certain block would execute 20 times
		 */
		for(int t = 0; t < (tiltTime * 1000)/500; t++) {
			//Waits 500ms between recording
			myFinch.sleep(500);
			
			//Adds tilts to an array (fast) 
			if(myFinch.isBeakUp()) { 
				recordedTilts.add(0);//adding value 0 into the arraylist
				System.out.println("Beak up");//print this output in console;there is 1 difference between print and println
											//print("Beak up") this will not create a new line autometically
											//println("Beak up") this will create a new line autometically
				
			} else if(myFinch.isBeakDown()){
				recordedTilts.add(1);//adding value 1 into the arraylist
				System.out.println("Beak down");//print this output in console;
				
			} else if(myFinch.isLeftWingDown()){
				recordedTilts.add(2);//adding value 2 into the arraylist
				System.out.println("Left Wing Down");//print this output in console;
				
			} else if(myFinch.isRightWingDown()){
				recordedTilts.add(3);//adding value 3 into the arraylist
				System.out.println("Right Wing Down");//print this output in console;
				
			} else if(myFinch.isFinchLevel()){
				recordedTilts.add(4);//adding value 4 into the arraylist
				System.out.println("Finch is Level");//print this output in console;
			}
			
		}
		
		//Led will come off and then buzz for completion
		myFinch.setLED(255, 0, 0, 100);//led will turn off for 100ms
		myFinch.buzz(440, 1000);//buzz will beep for 1000 milliseconds
		
		//Begin moving
		translationOfTilt();
	}
	
	public void translationOfTilt() {
		/*Let Beak Up = 0
		Beak Down = 1
		Beak Left = 2
		Beak Right = 3
		Level = 4 */
		/**
		 * Random is an utility class in java which used to genrate random number
		 * The instance of this object created as rand
		 * rand.nextInt(255) explanation: 255 is the range means the output of thus method will be an integer and
		 * the random number will generate in between 0 to 255
		 * rand.nextInt=used for generate random integer number
		 * rand.nextInt=used for generate random float number
		 */
		Random rand = new Random(); //random object 
		int velocity;
		//Wait two seconds
		myFinch.sleep(2000);
		
		//Loops for each direction provided
		for(int tilt : recordedTilts) {
			//500 ms pause // pauses every 500 ms and shows direction on console
			myFinch.sleep(500);
			
			//green led set through RGB//method to set LED
			myFinch.setLED(0,255,0);
			//Random speed each time // max speed is 255
			velocity = rand.nextInt(255);//generated random number is storing into this variable
			
			if(tilt == 0) {
				//Moves forward
				myFinch.setWheelVelocities(velocity, velocity, 500);
			} else if(tilt == 1) {
				//Moves backward 
				myFinch.setWheelVelocities(velocity * -1, velocity * -1, 500);
			} else if(tilt == 2) {
				//Turns left
				myFinch.setWheelVelocities(velocity * -1, velocity, 500);
			} else if(tilt == 3) {
				//Turns right 
				myFinch.setWheelVelocities(velocity, velocity * -1, 500);
			} else if(tilt == 4) {
				//Stop 
				myFinch.stopWheels();
			}
		}
		
		//Movement is complete
		//Two buzzes
		myFinch.sleep(1500);//pause
		myFinch.buzz(440, 500);//frequency, time
		myFinch.sleep(1500);//pause
		myFinch.buzz(440, 500);//frequency, time
		myFinch.sleep(1500);//pause
		myFinch.quit();
		System.exit(0);
		//Program over
	}
}
