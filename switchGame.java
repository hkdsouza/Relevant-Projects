/* Names: Heather D'Souza
Date Submitted: January 21, 2015
Last Modified Date: January 21, 2015
Program Name: switch
Program Description: a game that tests the user's problem solving abilities with the use of colours,numbers,and mind-blowing puzzles
*/

// The "switchGame" class.
import java.awt.*;
import hsa.Console;
import javax.swing.*;
public class switchGame
{
    //The main console that displays the game
    static Console c;
    //The console that displays the number of moves left
    static Console d;
    //The console that the player uses to input the box numbers
    static Console userInput;
    //Global variables that can be accessed by all methods in the class
    static int level = 0;
    static int b = 0, e = 0, f = 0, g = 0, h = 0, k = 0, l = 0, m = 0, n = 0, o = 0, p = 0, q = 0, r = 0, s = 0, t = 0, u = 0;
    //The main methods holds the menu and the basic components of the game
    public static void main (String[] args)
    {
	c = new Console (27, 130);
	int choice1 = 0, choice2 = 0, selected = 0, row1 = 0, row2 = 0, column1 = 0, column2 = 0, b = 0, g = 0, r = 0, a = 0, z = 0, i = 0, j = 0, moves = 10, win = 0, reset = 0;
	String message = "";
	Font abc = new Font ("Century Gothic", 0, 28);
	Font abcd = new Font ("Century Gothic", 1, 75);
	Font abcde = new Font ("Century Gothic", 0, 20);
	//The array for the box in which users have to switch the coloured squares
	int[] [] map = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
	//The array for the coloured squares that appear in the title
	int[] titleBoxes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
	//The method call for the title sequence
	title (i, titleBoxes);
	
	//This loop holds together the menu and all its components, including the game
	do
	{
	    //The menu, which is a pop-up option pane
	    Object[] possibleValues = {"Play", "How to Play", "Quit"};
	    Object selectedValue = JOptionPane.showInputDialog (null,
		    "switch", "By Heather and Liz",
		    JOptionPane.INFORMATION_MESSAGE, null,
		    possibleValues, possibleValues [0]);
	    //A series of if-else if statements for each of the possible choices from the menu
	    if (selectedValue == "Quit")
	    {
		c.close ();
		break;
	    }
	    else if (selectedValue == "How to Play")
	    {
		c.clear ();
		//howPlay method displays the basic layout of the "how to play" screen
		howPlay ();
		//This will allow the user to go back to menu after enting any string
		c.setTextBackgroundColor (new Color (122, 189, 255));
		c.setCursor (20, 84);
		c.print ("");
		c.setColor (Color.white);
		c.setFont (abcde);
		c.drawString ("Press any key to go back to MENU ", 320, 400);
		c.setTextColor (Color.white);
		c.readString ();
		//A rectangle is drawn in the same lavender color to maintain a blue background after the user enters a string
		lavender ();
		c.fillRect (660, 380, 500, 50);
	    }
	    else if (selectedValue == "Play")
	    {
		//this loop holds together ALL the components of the game, including the level select screen
		do
		{
		    c.clear ();
		    //the "levels" method will display the basic layout of the level select screen
		    levels ();
		    do
		    {
			c.setCursor (20, 80);
			lavender ();
			c.fillRect (579, 380, 500, 50);
			//Prompting the user for the level they want to play
			c.setTextBackgroundColor (new Color (122, 189, 255));
			c.setColor (Color.white);
			c.setFont (abcde);
			c.drawString ("Choose a Level: ", 420, 400);
			c.setTextColor (Color.white);
			c.setCursor (20, 75);
			level = c.readInt ();
		    }
		    while (level < 1 || level > 3); /*Boolean makes sure that an invalid input will not be made*/
		    c.clear ();
		    c.setTextBackgroundColor (Color.white);
		    //if-else if statements to initialize the correct moves to the level selected
		    if (level == 1)
		    {
			moves = 15;
		    }
		    else if (level == 2)
		    {
			moves = 12;
		    }
		    else if (level == 3)
		    {
			moves = 9;
		    }
		    c.clear ();
		    //the console to display the moves left is displayed
		    d = new Console (5, 50);
		    //the console to allow the user to input the box numbers is displayed
		    userInput = new Console (5, 50);
		    //when the player plays again, this if statment will reset the values of the map array
		    if (reset == 1)
		    {
			map [0] [0] = 1;
			map [0] [1] = 2;
			map [0] [2] = 3;
			map [0] [3] = 4;
			map [1] [0] = 5;
			map [1] [1] = 6;
			map [1] [2] = 7;
			map [1] [3] = 8;
			map [2] [0] = 9;
			map [2] [1] = 10;
			map [2] [2] = 11;
			map [2] [3] = 12;
			map [3] [0] = 13;
			map [3] [1] = 14;
			map [3] [2] = 15;
			map [3] [3] = 16;
		    }
		    //This loop will iterate until the player wins or loses
		    do
		    {
			//These variables need to be reset after each time the user switches two boxes
			int y = 0, x = 0, count = 0, p = 0, check1 = 0;
			win = 0;
			//The "coordinates" method will translate the map array elements to the actual coordinates on the c console
			coordinates (i, j, map);
			//The "displayBoxValues" array assigns the map array elements variables that determine the placement of each coloured box on the c console
			displayBoxValues ();
			//These for loops traverse the array to CHECK if the user has solved the puzzle or not
			for (i = 0 ; i < map.length ; i++)
			{
			    for (j = 0 ; j < map [0].length ; j++)
			    {
				if (i == 0)
				{
				    if (map [i] [j] == b || map [i] [j] == e || map [i] [j] == f || map [i] [j] == g)
				    {
					check1 = check1 + 1;
				    }
				    else
				    {
				    }
				}
				if (i == 1)
				{
				    if (map [i] [j] == h || map [i] [j] == k || map [i] [j] == l || map [i] [j] == m)
				    {
					check1 = check1 + 1;
				    }
				    else
				    {
				    }
				}
				if (i == 2)
				{
				    if (map [i] [j] == n || map [i] [j] == o || map [i] [j] == p || map [i] [j] == q)
				    {
					check1 = check1 + 1;
				    }
				    else
				    {
				    }
				}
				if (i == 3)
				{
				    if (map [i] [j] == r || map [i] [j] == s || map [i] [j] == t || map [i] [j] == u)
				    {
					check1 = check1 + 1;
				    }
				    else
				    {
				    }
				}
			    }
			}
			//If check = 12, then the user has solved the puzzle
			if (check1 == 12)
			{
			    win = 1;
			    break;
			}
			//The console the display the moves left
			d.setFont (abcd);
			//If  moves are less than five, the moves are displayed in red
			if (moves <= 5)
			{
			    d.setColor (Color.red);
			}
			else
			{
			    d.setColor (Color.black);
			}
			//The console is cleared to display the next number
			d.clear ();
			//A switch statement to display the moves left
			switch (moves)
			{
			    case 0:
				d.drawString ("0", 173, 80);
				break;
			    case 1:
				d.drawString ("1", 173, 80);
				break;
			    case 2:
				d.drawString ("2", 173, 80);
				break;
			    case 3:
				d.drawString ("3", 173, 80);
				break;
			    case 4:
				d.drawString ("4", 173, 80);
				break;
			    case 5:
				d.drawString ("5", 173, 80);
				break;
			    case 6:
				d.drawString ("6", 173, 80);
				break;
			    case 7:
				d.drawString ("7", 173, 80);
				break;
			    case 8:
				d.drawString ("8", 173, 80);
				break;
			    case 9:
				d.drawString ("9", 173, 80);
				break;
			    case 10:
				d.drawString ("10", 155, 80);
				break;
			    case 11:
				d.drawString ("11", 155, 80);
				break;
			    case 12:
				d.drawString ("12", 155, 80);
				break;
			    case 13:
				d.drawString ("13", 155, 80);
				break;
			    case 14:
				d.drawString ("14", 155, 80);
				break;
			    case 15:
				d.drawString ("15", 155, 80);
				break;
			}
			//If the player uses up all their moves, the game will end
			if (moves == 0)
			{
			    break;
			}
			//This do loop will run until the user inputs two boxes that lie on the same horizontal or vertical line
			do
			{
			    //This loop will prompt the user for the "box 1" number
			    do
			    {
				userInput.setCursor (3, 20);
				userInput.setColor (Color.white);
				userInput.fillRect (-100, -20, 800, 200);
				userInput.setTextColor (Color.white);
				userInput.print ("Enter first choice: ");
				userInput.setTextColor (Color.black);
				userInput.setFont (abc);
				userInput.setColor (Color.black);
				userInput.drawString ("ENTER FIRST BOX: ", 35, 60);
				choice1 = userInput.readInt ();
			    }
			    while (choice1 < 1 || choice1 > 16); /*Boolean checks for a valid input*/
			    //This loop will prompt the user for the "box 2" number
			    do
			    {
				userInput.setCursor (3, 20);
				userInput.setColor (Color.white);
				userInput.fillRect (-100, -20, 800, 200);
				userInput.setTextColor (Color.white);
				userInput.print ("Enter second choice: ");
				userInput.setTextColor (Color.black);
				userInput.setFont (abc);
				userInput.setColor (Color.black);
				userInput.drawString ("ENTER SECOND BOX: ", 35, 60);
				choice2 = userInput.readInt ();
			    }
			    while (choice2 < 1 || choice2 > 16 || choice1 == choice2); /*Boolean checks for a valid input*/
			    //This do loop will run twice, each for the first and second inputted box
			    do
			    {
				//Telling the computer if the value is for box 1 or box 2
				if (x == 0)
				{
				    y = choice1;
				    selected = 0;
				}
				else if (x == 1)
				{
				    y = choice2;
				    selected = 1;
				}
				x = x + 1;
				//This switch statement determines the coordinates of the map array that corresponds with the box number that the user inputs
				switch (y)
				{
				    case 1:
					if (selected == 0)
					{
					    row1 = 0;
					    column1 = 0;
					}
					else
					{
					    row2 = 0;
					    column2 = 0;
					}
					break;
				    case 2:
					if (selected == 0)
					{
					    row1 = 0;
					    column1 = 1;
					}
					else
					{
					    row2 = 0;
					    column2 = 1;
					}
					break;
				    case 3:
					if (selected == 0)
					{
					    row1 = 0;
					    column1 = 2;
					}
					else
					{
					    row2 = 0;
					    column2 = 2;
					}
					break;
				    case 4:
					if (selected == 0)
					{
					    row1 = 0;
					    column1 = 3;
					}
					else
					{
					    row2 = 0;
					    column2 = 3;
					}
					break;
				    case 5:
					if (selected == 0)
					{
					    row1 = 1;
					    column1 = 0;
					}
					else
					{
					    row2 = 1;
					    column2 = 0;
					}
					break;
				    case 6:
					if (selected == 0)
					{
					    row1 = 1;
					    column1 = 1;
					}
					else
					{
					    row2 = 1;
					    column2 = 1;
					}
					break;
				    case 7:
					if (selected == 0)
					{
					    row1 = 1;
					    column1 = 2;
					}
					else
					{
					    row2 = 1;
					    column2 = 2;
					}
					break;
				    case 8:
					if (selected == 0)
					{
					    row1 = 1;
					    column1 = 3;
					}
					else
					{
					    row2 = 1;
					    column2 = 3;
					}
					break;
				    case 9:
					if (selected == 0)
					{
					    row1 = 2;
					    column1 = 0;
					}
					else
					{
					    row2 = 2;
					    column2 = 0;
					}
					break;
				    case 10:
					if (selected == 0)
					{
					    row1 = 2;
					    column1 = 1;
					}
					else
					{
					    row2 = 2;
					    column2 = 1;
					}
					break;
				    case 11:
					if (selected == 0)
					{
					    row1 = 2;
					    column1 = 2;
					}
					else
					{
					    row2 = 2;
					    column2 = 2;
					}
					break;
				    case 12:
					if (selected == 0)
					{
					    row1 = 2;
					    column1 = 3;
					}
					else
					{
					    row2 = 2;
					    column2 = 3;
					}
					break;
				    case 13:
					if (selected == 0)
					{
					    row1 = 3;
					    column1 = 0;
					}
					else
					{
					    row2 = 3;
					    column2 = 0;
					}
					break;
				    case 14:
					if (selected == 0)
					{
					    row1 = 3;
					    column1 = 1;
					}
					else
					{
					    row2 = 3;
					    column2 = 1;
					}
					break;
				    case 15:
					if (selected == 0)
					{
					    row1 = 3;
					    column1 = 2;
					}
					else
					{
					    row2 = 3;
					    column2 = 2;
					}
					break;
				    case 16:
					if (selected == 0)
					{
					    row1 = 3;
					    column1 = 3;
					}
					else
					{
					    row2 = 3;
					    column2 = 3;
					}
					break;
				}
				count = count + 1; //counter so the loop runs two times
			    }
			    while (count < 2);
			    //the "coordinates" method will assign the c console coordinates of all the array elements in the map array
			    coordinates (i, j, map);
			    //the "boxSwitch" method will swap the two coloured squares the user has inputted
			    boxSwitch (row1, column1, row2, column2, map);
			    c.print (boxSwitch (row1, column1, row2, column2, map));
			    p = boxSwitch (row1, column1, row2, column2, map);
			    p = 0;

			}
			while (p == 1); /*the loop will continue to run if the user inputs two boxes that do not lie on the same line as each other*/
			//if the player inputs two valid box numbers that can be switched, the moves counter will decrease
			if (row1 == row2 || column1 == column2)
			{
			    moves = moves - 1;
			}
			else if (row1 != row2 || column1 != column2)
			{
			}
		    }
		    while (moves >= 0);
		    //When the game ends, the d and userInput console will close
		    d.close ();
		    userInput.close ();
		    //Different messages are initialized if the user wins or loses
		    if (win == 1)
		    {
			message = "Congratulations";
		    }
		    else if (win == 0)
		    {
			message = "Try Again";
		    }
		    //This pop-up pane will allow the user to go back to level select or the menu
		    Object[] possibleValues2 = {"Level Select", "Menu"};
		    Object selectedValue2 = JOptionPane.showInputDialog (null,
			    message, "Input",
			    JOptionPane.INFORMATION_MESSAGE, null,
			    possibleValues2, possibleValues2 [0]);
		    if (selectedValue2 == "Menu")
		    {
			title (i, titleBoxes);
			break;
		    }
		    if (selectedValue2 == "Level Select")
		    {
			reset = 1;
		    }
		}
		while (true);
	    }
	}
	while (true);
    }
    public static int boxSwitch (int row1, int column1, int row2, int column2, int[] [] map)  //switching element values
    {
	int temp, p = 0;
	if (row1 == row2 || column1 == column2)
	{
	    temp = map [row1] [column1];
	    map [row1] [column1] = map [row2] [column2];
	    map [row2] [column2] = temp;
	}
	else if (row1 != row2 || column1 != column2)
	{
	    p = 1;
	}
	return (p);
    }
    public static void displayBox (int a, int z, int[] [] map, int i, int j)  //assigning colours to the element values and displaying the boxes
    {
	displayBoxValues ();
	if (map [i] [j] == b || map [i] [j] == e || map [i] [j] == f || map [i] [j] == g)
	{
	    if (level == 1)
	    {
		borange ();
	    }
	    else if (level == 2)
	    {
		aqua ();
	    }
	    else if (level == 3)
	    {
		mapleRed ();
	    }
	    c.fillRect (a, z, 100, 100);
	}
	else if (map [i] [j] == h || map [i] [j] == k || map [i] [j] == l || map [i] [j] == m)
	{
	    if (level == 1)
	    {
		lightLavender ();
	    }
	    else if (level == 2)
	    {
		babyPink ();
	    }
	    else if (level == 3)
	    {
		pumpkinPie ();
	    }
	    c.fillRect (a, z, 100, 100);
	}
	else if (map [i] [j] == n || map [i] [j] == o || map [i] [j] == p || map [i] [j] == q)
	{
	    if (level == 1)
	    {
		lavender ();
	    }
	    else if (level == 2)
	    {
		rorange ();
	    }
	    else if (level == 3)
	    {
		warmYellow ();
	    }
	    c.fillRect (a, z, 100, 100);
	}
	else if (map [i] [j] == r || map [i] [j] == s || map [i] [j] == t || map [i] [j] == u)
	{
	    if (level == 1)
	    {
		teal ();
	    }
	    else if (level == 2)
	    {
		chocolateBrown ();
	    }
	    else if (level == 3)
	    {
		eggNog ();
	    }
	    c.fillRect (a, z, 100, 100);
	}
    }
    //displayC
    public static void displayCorrect (int a, int z, int[] [] map)  //display of the correct pattern
    {
	displayBoxValues ();
	if (level == 1)
	{
	    borange ();
	}
	else if (level == 2)
	{
	    aqua ();
	}
	else if (level == 3)
	{
	    mapleRed ();
	}
	c.fillRect (a + 495, 65, 100, 100);
	if (level == 1)
	{
	    lightLavender ();
	}
	else if (level == 2)
	{
	    babyPink ();
	}
	else if (level == 3)
	{
	    pumpkinPie ();
	}
	c.fillRect (a + 495, 165, 100, 100);
	if (level == 1)
	{
	    lavender ();
	}
	else if (level == 2)
	{
	    rorange ();
	}
	else if (level == 3)
	{
	    warmYellow ();
	}
	c.fillRect (a + 495, 265, 100, 100);
	if (level == 1)
	{
	    teal ();
	}
	else if (level == 2)
	{
	    chocolateBrown ();
	}
	else if (level == 3)
	{
	    eggNog ();
	}
	c.fillRect (a + 495, 365, 100, 100);
    }
    public static void displayBoxValues ()  //assigning possible element values to variables so that they can be passed to the "displayBox" method
    {
	if (level == 1)
	{
	    b = 1;
	    e = 7;
	    f = 15;
	    g = 4;
	    h = 3;
	    k = 12;
	    l = 9;
	    m = 13;
	    n = 6;
	    o = 16;
	    p = 2;
	    q = 11;
	    r = 5;
	    s = 8;
	    t = 10;
	    u = 14;
	}
	else if (level == 2)
	{
	    b = 1;
	    e = 3;
	    f = 9;
	    g = 14;
	    h = 6;
	    k = 7;
	    l = 13;
	    m = 15;
	    n = 2;
	    o = 4;
	    p = 11;
	    q = 16;
	    r = 5;
	    s = 8;
	    t = 10;
	    u = 12;
	}
	else if (level == 3)
	{
	    b = 8;
	    e = 9;
	    f = 11;
	    g = 12;
	    h = 2;
	    k = 4;
	    l = 5;
	    m = 13;
	    n = 1;
	    o = 3;
	    p = 6;
	    q = 14;
	    r = 7;
	    s = 10;
	    t = 15;
	    u = 16;
	}
    }
    //colours are set as methods to reduce the lines of code and to call on any colour wherever it is needed in the game
    public static void borange ()
    {
	Color borange = new Color (255, 128, 0);
	c.setColor (borange);
    }
    public static void lightLavender ()
    {
	Color lightLavender = new Color (228, 228, 255);
	c.setColor (lightLavender);
    }
    public static void lavender ()
    {
	Color lavender = new Color (122, 189, 255);
	c.setColor (lavender);
    }
    public static void teal ()
    {
	Color teal = new Color (68, 147, 226);
	c.setColor (teal);
    }
    public static void aqua ()
    {
	Color aqua = new Color (214, 255, 253);
	c.setColor (aqua);
    }
    public static void rorange ()
    {
	Color rorange = new Color (255, 142, 92);
	c.setColor (rorange);
    }
    public static void babyPink ()
    {
	Color teal = new Color (255, 232, 213);
	c.setColor (teal);
    }
    public static void chocolateBrown ()
    {
	Color chocolateBrown = new Color (199, 102, 6);
	c.setColor (chocolateBrown);
    }
    public static void mapleRed ()
    {
	Color mapleRed = new Color (172, 11, 21);
	c.setColor (mapleRed);
    }
    public static void pumpkinPie ()
    {
	Color pumpkinPie = new Color (242, 93, 7);
	c.setColor (pumpkinPie);
    }
    public static void warmYellow ()
    {
	Color warmYellow = new Color (255, 188, 51);
	c.setColor (warmYellow);
    }
    public static void eggNog ()
    {
	Color eggNog = new Color (255, 245, 142);
	c.setColor (eggNog);
    }
    public static void coordinates (int i, int j, int[] [] map)  //assigning coordinate values to array elements
    {
	int a = 0, z = 0;
	for (i = 0 ; i < map.length ; i++)
	{
	    for (j = 0 ; j < map [0].length ; j++)
	    {
		switch (map [i] [j])
		{
		    case 1:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 2:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 3:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 4:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 5:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 6:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 7:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 8:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 9:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 10:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 11:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 12:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 13:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 14:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 15:
			a = 120 + 100 * j;
			z = 65 + 100 * i;
		    case 16:
			a = 70 + 100 * j;
			z = 65 + 100 * i;
		}
		displayBox (a, z, map, i, j);
		displayNumbers ();
		displayCorrect (a, z, map);
	    }
	}
    }
    public static void title (int i, int[] titleBoxes)  //to display the title,the boxes,and the text
    {
	lavender ();
	c.fillRect (0, 0, 2000, 1000);
	c.setColor (Color.white);
	c.fillRect (215, 171, 610, 200);
	lavender ();
	c.fillRect (235, 191, 570, 160);
	Font harmony = new Font ("Century Gothic", 1, 100);
	c.setFont (harmony);
	c.setColor (Color.white);
	c.drawString ("switch", 370, 290);
	Font abcde = new Font ("Century Gothic", 0, 20);
	c.setFont (abcde);
	c.drawString ("MASTERFULLY CREATED BY HEATHER AND LIZ", 312, 330);
	titleCoordinates (titleBoxes);
    }
    public static void levels ()  //displays the choice of levels so that user can input/choose a level to play
    {
	lavender ();
	c.fillRect (0, 0, 2000, 1000);
	c.setColor (Color.white);
	c.fillRect (215, 171, 610, 200);
	lavender ();
	c.fillRect (235, 191, 570, 160);
	Font harmony = new Font ("Century Gothic", 1, 100);
	c.setFont (harmony);
	c.setColor (Color.white);
	c.drawString ("levels", 370, 290);
	Font abcde = new Font ("Century Gothic", 0, 20);
	c.setFont (abcde);
	c.drawString ("Level 1                 Level 2                 Level 3", 312, 330);
    }
    public static void howPlay ()  //instructions
    {
	lavender ();
	c.fillRect (0, 0, 2000, 1000);
	c.setColor (Color.white);
	c.fillRect (215, 171, 640, 300);
	lavender ();
	c.fillRect (235, 191, 600, 260);
	Font harmony = new Font ("Century Gothic", 1, 65);
	c.setFont (harmony);
	c.setColor (Color.white);
	c.drawString ("how to play", 355, 255);
	Font abcde = new Font ("Century Gothic", 0, 20);
	c.setFont (abcde);
	c.drawString ("1. enter two box numbers to switch them", 250, 290);
	c.drawString ("2. only boxes on the same row or column may be switched", 250, 315);
	c.drawString ("3. swap blocks until it matches the pattern on the right", 250, 340);
	c.drawString ("4. solve the pattern before the moves run out!", 250, 365);
    }
    public static void titleCoordinates (int[] titleBoxes)  //assigns coordinate values to the boxes displayed on the opening screen
    {
	int a1 = 0, z1 = 0;
	for (int i = 0 ; i < titleBoxes.length ; i++)
	{
	    switch (titleBoxes [i])
	    {
		case 1:
		    a1 = 0;
		    z1 = 0;
		    rorange ();
		    break;
		case 2:
		    a1 = 150;
		    z1 = 0;
		    eggNog ();
		    break;
		case 3:
		    a1 = 300;
		    z1 = 0;
		    lightLavender ();
		    break;
		case 4:
		    a1 = 450;
		    z1 = 0;
		    rorange ();
		    break;
		case 5:
		    a1 = 600;
		    z1 = 0;
		    aqua ();
		    break;
		case 6:
		    a1 = 750;
		    z1 = 0;
		    lightLavender ();
		    break;
		case 7:
		    a1 = 900;
		    z1 = 0;
		    eggNog ();
		    break;
		case 8:
		    a1 = 900;
		    z1 = 390;
		    aqua ();
		    break;
		case 9:
		    a1 = 750;
		    z1 = 390;
		    lightLavender ();
		    break;
		case 10:
		    a1 = 600;
		    z1 = 390;
		    rorange ();
		    break;
		case 11:
		    a1 = 450;
		    z1 = 390;
		    eggNog ();
		    break;
		case 12:
		    a1 = 300;
		    z1 = 390;
		    aqua ();
		    break;
		case 13:
		    a1 = 150;
		    z1 = 390;
		    rorange ();
		    break;
		case 14:
		    a1 = 0;
		    z1 = 390;
		    babyPink ();
		    break;
	    }
	    displayTitleBoxes (a1, z1);
	}
	delay (1000);
	displayBlueBoxes ();
    }
    public static void displayTitleBoxes (int a1, int z1)  //draws the title boxes
    {
	c.fillRect (a1, z1, 150, 150);
    }
    public static void displayBlueBoxes ()  //makes the title boxes "disappear" by overlapping them with boxes that are the same colour as the background
    {
	lavender ();
	c.fillRect (600, 390, 150, 150);
	delay (500);
	c.fillRect (450, 390, 150, 150);
	delay (500);
	c.fillRect (900, 0, 150, 150);
	delay (500);
	c.fillRect (300, 390, 150, 150);
	delay (500);
	c.fillRect (0, 0, 150, 150);
	delay (500);
	c.fillRect (450, 0, 150, 150);
	delay (500);
	c.fillRect (600, 0, 150, 150);
	delay (500);
	c.fillRect (900, 390, 150, 150);
	delay (500);
	c.fillRect (750, 0, 150, 150);
	delay (500);
	c.fillRect (0, 390, 150, 150);
	delay (500);
	c.fillRect (300, 0, 150, 150);
	delay (500);
	c.fillRect (750, 390, 150, 150);
	delay (500);
	c.fillRect (150, 0, 150, 150);
	delay (500);
	c.fillRect (150, 390, 150, 150);
	delay (500);
    }
    public static void displayNumbers ()  //numbers on the boxes in the game that allow players to choose which boxes they want to swap
    {
	Font abcdef = new Font ("Century Gothic", 0, 60);
	c.setFont (abcdef);
	c.setColor (Color.white);
	c.drawString ("1", 105, 137);
	c.drawString ("2", 203, 137);
	c.drawString ("3", 302, 137);
	c.drawString ("4", 402, 137);
	c.drawString ("5", 105, 237);
	c.drawString ("6", 203, 237);
	c.drawString ("7", 302, 237);
	c.drawString ("8", 402, 237);
	c.drawString ("9", 105, 337);
	c.drawString ("10", 185, 337);
	c.drawString ("11", 284, 337);
	c.drawString ("12", 384, 337);
	c.drawString ("13", 87, 437);
	c.drawString ("14", 185, 437);
	c.drawString ("15", 284, 437);
	c.drawString ("16", 384, 437);
    }
    public static void delay (int x)  //used in the opening screen to delay the "disappearing" of each coloured  title box
    {
	try
	{
	    Thread.sleep (x);
	}
	catch (InterruptedException ie)
	{
	}
    }
} //end of the class
