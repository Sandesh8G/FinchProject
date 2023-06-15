# FinchProject
--------------

The initial intention of the program for the Finch is to adapt to the input of the user and depending on the input, the robot will tilt in any direction for a set number of seconds. 

The program must include a function at the beginning which questions the user on how much seconds the tilting would occur for, and this is recorded by the program. The program will only be able to accept inputs from the user that range from 1 – 20. Unacceptable values which are less than 1 or more than 20 won’t be accepted. The program will display error notifications and request another value from the user - (Required Functionality). The user must tilt the Finch robot in 5 different directions (Left Wing Down, Right Wing Down, Beak Down, Beak Up and Level), the program must document all the tilts that occur within the time inputted by the user. 

Another required functionality that must be in the program is that every 500 milliseconds, the Finch must document the direction it’s moving, the documentation of the Finch must also be indicated through a red LED. It must beep once the documentation has been complete resulting on the LED to be switched off from Red. The finch then must pause for 2 seconds, which allows the user to lay the finch down.

After all the tilts that have been documented; the finch must decode and perform them, the tilt direction results in the following 
(Left Wing Down - Turn Left), (Right Wing Down -  Turn Right), (Beak Up - Move Forward), (Beak Down, Move Down), (Level – Stop). 

Another functionality is that the finch robot is required to pause and wait for 500 milliseconds when every movement on the Finch occurs, (Every movement from the finch itself is 500 milliseconds). The wheels of the Finch can move at any pace, and this would be figured out randomly; however, I must restrict the Finch to go over a certain speed. Whiles this is happening, the Finch must have a green LED whiles performing the movement; the Finch will create a beeping sound twice; which would cause the program to end.

The console user interface will tell the user to change the user input if it’s more than 20 or less than 1. Every 500 milliseconds, the console will also state to the user what direction the Finch is at.

An additional feature is A beep and a White LED is a feature that would tell the user they are permitted to add inputs. This feature allows them to save time, instead of just waiting to see if the program is ready. Without the LED it would be vague and the program wouldn’t be able to tell you whether it is ready to accept inputs. 

A user interfaces at the start with an enter button whiles welcoming the user, and they can click the enter button to proceed with the program. After that is done, the user is faced with another window which tells the user to enter their input. If the input is less than 0 or more than 21, then it will prompt an error window to appear, stating its an invalid input with an additional button “Try again”.

The code involves a GUI interface which corresponds to the robot actions and any input given on the UI either, a action occurs or a error dialog appears.
