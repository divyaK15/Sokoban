//Name: Divya Kaur
//Date: Dec. 18/2017
//Purpose: SOKO-CONCERT


//Pictures used
// Player: https://pbs.twimg.com/media/BwkGsg0CIAAUiMD.jpg
// Blue Square: https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Solid_blue.svg/225px-Solid_blue.svg.png
// Wall: http://xboxhut.com/wp-content/uploads/2016/06/brick-wall-vector-black-and-white-backyard-fire-pit-exterior.jpg
// Speaker: https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnS9sZV21_VajB6WzBeI91jZdlN-Lak--gYAd6mxxo1S6eh_1j
// Stage Floor: http://1.bp.blogspot.com/_Xako0H5Fk6U/TPzW1Xa5sMI/AAAAAAAAAe4/D2UnARFoVEs/s1600/wood-black-1440x900-21.jpg
// Title Pic: http://i.ebayimg.com/images/g/5OcAAOSwTuJYo4Jm/s-l1600.jpg
// Win Pic: https://i.ytimg.com/vi/vtTDrs3tU14/hqdefault.jpg
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.applet.*;
import javax.swing.event.*; //new library

public class FinalGame extends Applet implements ActionListener, ChangeListener
{
    //globally
    AudioClip sound; // sound
    JButton nextlevel; // next level
    JTextField feed; //Feedback comment
    int level = 1; //level
    int px = 4; //button row
    int py = 2; //button column
    // answer arrays
    int ans[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int ans1[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int ans2[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int ans3[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 0, 4, 4, 0}, {0, 0, 4, 4, 4, 4, 0, 4, 4, 0}, {0, 4, 4, 4, 4, 4, 4, 4, 4, 0}, {0, 4, 4, 4, 4, 4, 4, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 4, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 4, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 4, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 4, 4, 0, 0, }, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }};
    int sum = 0; // moves made
    int q = 0; // slider
    int levelnum = 1; // level label
    JLabel leveln; // shows level on screen
    JLabel scorenum; // turns made
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5; //the two screens
    CardLayout cdLayout = new CardLayout ();
    //grid
    int row = 10;
    int col = 10;
    JLabel a[] = new JLabel [row * col];
    // level arrays
    int r[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 3, 0, 0, 0}, {0, 0, 4, 1, 4, 1, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 3, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int level1[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 3, 0, 0, 0}, {0, 0, 4, 1, 4, 1, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 3, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int level2[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 1, 4, 4, 4, 1, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 4, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 3, 0, 0}, {0, 0, 4, 3, 4, 4, 4, 4, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    int level3[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 0, 4, 4, 0}, {0, 0, 4, 4, 1, 4, 0, 4, 4, 0}, {0, 4, 1, 4, 4, 1, 4, 4, 4, 0}, {0, 4, 4, 4, 4, 1, 4, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 4, 4, 0, 0, }, {0, 4, 3, 4, 4, 3, 4, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 3, 4, 0, 0, }, {0, 4, 4, 4, 4, 4, 3, 4, 0, 0, }, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, }};
    int b[] [] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 3, 0, 0, 0}, {0, 0, 4, 1, 4, 1, 4, 0, 0, 0}, {0, 0, 4, 4, 4, 4, 4, 0, 0, 0}, {0, 0, 4, 4, 3, 4, 4, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public void init ()
    {
	// card panels
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	// screen methods
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (850, 660);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    // sound plays when player reaches game screen
    public void sound ()
    {

	sound = getAudioClip (getDocumentBase (), "Aftertaste.wav");
	//this attaches the sound file "Aftertase"
	sound.loop ();
	//put the sound on repeat

    }


    public void screen1 ()
    { //screen 1 is set up.
	card1 = new Panel ();
	JLabel titlepic = new JLabel (createImageIcon ("concert.jpg"));
	card1.setBackground (Color.black);
	// title settings
	JLabel title = new JLabel ("Welcome to...");
	title.setForeground (Color.white);
	title.setFont (new Font ("Chiller", Font.BOLD, 80));
	// gametitle settings
	JLabel gametitle = new JLabel ("SOKO-CONCERT");
	gametitle.setFont (new Font ("Chiller", Font.BOLD, 90));
	gametitle.setForeground (Color.white);
	// next button settings
	JButton next = new JButton ("Next");
	next.setBackground (Color.black);
	next.setForeground (Color.white);
	next.setActionCommand ("s2");
	next.addActionListener (this);
	// add things to the screen
	card1.add (title);
	card1.add (gametitle);
	card1.add (titlepic);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel ();
	card2.setBackground (Color.black);
	JLabel title = new JLabel ("Instructions");
	title.setForeground (Color.white);
	title.setFont (new Font ("Chiller", Font.BOLD, 90));
	//pictures
	JLabel bluep = new JLabel (createImageIcon ("3.jpg"));
	bluep.setPreferredSize (new Dimension (50, 50));
	JLabel stagep = new JLabel (createImageIcon ("4.jpg"));
	stagep.setPreferredSize (new Dimension (50, 50));
	JLabel wallp = new JLabel (createImageIcon ("0.jpg"));
	wallp.setPreferredSize (new Dimension (50, 50));
	JLabel movep = new JLabel (createImageIcon ("2.jpg"));
	movep.setPreferredSize (new Dimension (50, 50));
	JLabel speakerp = new JLabel (createImageIcon ("1.jpg"));
	speakerp.setPreferredSize (new Dimension (50, 50));
	JLabel upp = new JLabel (createImageIcon ("up.jpg"));
	upp.setPreferredSize (new Dimension (50, 50));
	JLabel downp = new JLabel (createImageIcon ("down.jpg"));
	downp.setPreferredSize (new Dimension (50, 50));
	JLabel leftp = new JLabel (createImageIcon ("left.jpg"));
	leftp.setPreferredSize (new Dimension (50, 50));
	JLabel rightp = new JLabel (createImageIcon ("right.jpg"));
	rightp.setPreferredSize (new Dimension (50, 50));
	//picture panel
	Panel blue = new Panel ();
	Panel stage = new Panel ();
	Panel wall = new Panel ();
	Panel move = new Panel ();
	Panel speaker = new Panel ();
	Panel arrows = new Panel ();
	// text to describe pictures
	JLabel bluet = new JLabel ("Blue Square");
	bluet.setForeground (Color.white);
	JLabel staget = new JLabel ("Stage Block");
	staget.setForeground (Color.white);
	JLabel wallt = new JLabel ("Wall Block");
	wallt.setForeground (Color.white);
	JLabel movet = new JLabel ("Player");
	movet.setForeground (Color.white);
	JLabel speakert = new JLabel ("Speaker");
	speakert.setForeground (Color.white);
	JLabel arrowst = new JLabel ("Use these arrows to move the player.");
	arrowst.setForeground (Color.white);
	//instructions text
	JLabel ins1 = new JLabel ("                                                 Welcome to SOKO CONCERT!\n");
	ins1.setPreferredSize (new Dimension (850, 50));
	JLabel space = new JLabel ("                          ");
	JLabel ins2 = new JLabel ("The goal of the game is to move the speakers to the blue squares on the stage.");
	JLabel ins3 = new JLabel ("If you don't clear the stage, the concert can't go on...\n");
	JLabel ins4 = new JLabel ("Do you really want to dissapoint all those people?\n");
	JLabel ins5 = new JLabel ("Using the arrows at the bottom of the screen, move your player.\n");
	JLabel ins6 = new JLabel ("You can push the speakers up, down, left, or right.\n");
	JLabel ins7 = new JLabel ("You can only push it where there is stage.");
	JLabel ins75 = new JLabel ("Make sure you don't get cornered by the wall.\n");
	JLabel ins8 = new JLabel ("  Once you have cleared the stage, click (check). If the (next level) button enables, you have completed the level.");
	JLabel ins9 = new JLabel ("                                  Then click (next level)to move onto the next level.\n");
	//instructions text colour is set
	ins1.setForeground (new Color (128, 128, 255));
	ins2.setForeground (new Color (128, 128, 255));
	ins3.setForeground (new Color (128, 128, 255));
	ins4.setForeground (new Color (128, 128, 255));
	ins5.setForeground (new Color (128, 128, 255));
	ins6.setForeground (new Color (128, 128, 255));
	ins7.setForeground (new Color (128, 128, 255));
	ins75.setForeground (new Color (128, 128, 255));
	ins8.setForeground (new Color (128, 128, 255));
	ins9.setForeground (new Color (128, 128, 255));
	// instruction text font is set
	ins1.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins2.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins3.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins4.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins5.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins6.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins7.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins75.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins8.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins9.setFont (new Font ("Courier New", Font.BOLD, 12));
	ins8.setPreferredSize (new Dimension (850, 50));
	ins9.setPreferredSize (new Dimension (850, 50));
	// back button setup
	JButton back = new JButton ("Back");
	back.setBackground (Color.black);
	back.setForeground (Color.white);
	back.setActionCommand ("back");
	back.addActionListener (this);
	card2.add (title);
	//next button setup
	JButton next = new JButton ("Next");
	next.setBackground (Color.black);
	next.setForeground (Color.white);
	next.setActionCommand ("s3");
	next.addActionListener (this);
	card2.add (title);
	//add widgets to instruction panel
	card2.add (space);
	card2.add (ins1);
	card2.add (ins2);
	card2.add (ins3);
	card2.add (ins4);
	card2.add (ins5);
	card2.add (ins6);
	card2.add (ins7);
	card2.add (ins75);
	card2.add (ins8);
	card2.add (ins9);
	// picture panel for blue square
	blue.add (bluep);
	blue.add (bluet);
	// picture panel for stage
	stage.add (stagep);
	stage.add (staget);
	// picture panel for wall
	wall.add (wallp);
	wall.add (wallt);
	// picture panel for player
	move.add (movep);
	move.add (movet);
	// picture panel for speakers
	speaker.add (speakerp);
	speaker.add (speakert);
	// picture panel for arrows
	arrows.add (upp);
	arrows.add (downp);
	arrows.add (rightp);
	arrows.add (leftp);
	// add widgets to screen2
	card2.add (blue);
	card2.add (stage);
	card2.add (wall);
	card2.add (move);
	card2.add (speaker);
	card2.add (arrows);
	card2.add (next);
	card2.add (back);
	p_card.add ("2", card2);

    }


    public void screen3 ()
    { //screen 3 is set up.
	card3 = new Panel ();
	// panel for the buttons is made
	Panel buttons = new Panel ();
	card3.setBackground (Color.black);
	// title settings
	JLabel title = new JLabel ("SOKO-CONCERT");
	title.setFont (new Font ("Chiller", Font.BOLD, 60));
	title.setForeground (Color.white);
	// reset button settings
	JButton reset1 = new JButton ("Reset");
	reset1.setBackground (Color.blue);
	reset1.setForeground (Color.white);
	reset1.setActionCommand ("reset1");
	reset1.addActionListener (this);
	// score is made to add to screen3
	scorenum = new JLabel ("Moves:  0   ");
	scorenum.setForeground (Color.white);
	scorenum.setPreferredSize (new Dimension (90, 20));
	// level label is made to add to screen3
	leveln = new JLabel ("Level:  " + levelnum + "  ");
	leveln.setForeground (Color.white);
	leveln.setFont (new Font ("Arial", Font.BOLD, 20));
	// Direction buttons
	JButton up = new JButton (createImageIcon ("up.jpg"));
	up.setBackground (Color.black);
	up.setActionCommand ("up");
	up.addActionListener (this);
	JButton down = new JButton (createImageIcon ("down.jpg"));
	down.setBackground (Color.black);
	down.setActionCommand ("down");
	down.addActionListener (this);
	JButton left = new JButton (createImageIcon ("left.jpg"));
	left.setBackground (Color.black);
	left.setActionCommand ("left");
	left.addActionListener (this);
	JButton right = new JButton (createImageIcon ("right.jpg"));
	right.setActionCommand ("right");
	right.addActionListener (this);
	right.setBackground (Color.black);
	// next level button set up
	nextlevel = new JButton ("Next Level");
	nextlevel.setBackground (Color.blue);
	nextlevel.setForeground (Color.white);
	nextlevel.setActionCommand ("s4");
	nextlevel.addActionListener (this);
	nextlevel.setEnabled (false);
	//check answer button set up
	JButton checka = new JButton ("Check");
	checka.setBackground (Color.blue);
	checka.setForeground (Color.white);
	checka.setActionCommand ("s0");
	checka.addActionListener (this);

	//Set up grid
	Panel p = new Panel (new GridLayout (row, col));
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    { //take out when you've got pictures
		a [move] = new JLabel ("");
		//add in when you have pictures
		a [move] = new JLabel (createImageIcon (b [i] [j] + ".jpg"));
		a [move].setPreferredSize (new Dimension (50, 50));
		//a [move].addActionListener (this);
		// a [move].setActionCommand ("" + move);
		p.add (a [move]);
		move++;
	    }
	}
	// widgets are added to screen3
	card3.add (title);
	card3.add (leveln);
	card3.add (p);
	card3.add (checka);
	card3.add (nextlevel);
	card3.add (reset1);
	card3.add (scorenum);
	// keyboard pictures added to the panels
	buttons.add (up);
	buttons.add (down);
	buttons.add (left);
	buttons.add (right);
	card3.add (buttons);
	p_card.add ("3", card3);
	redraw ();
    }


    public void screen4 ()
    { //screen 4 is set up.
	card4 = new Panel ();
	card4.setBackground (Color.black);
	// picture shows is player wins game
	JLabel pic = new JLabel (createImageIcon ("win.jpg"));
	// prompts for slider and text field
	JLabel sliderfb = new JLabel ("Rate the game on a scale on 1 to 10");
	sliderfb.setFont (new Font ("ARIAL", Font.BOLD, 40));
	sliderfb.setForeground (Color.white);
	JLabel feedback = new JLabel ("What would make this game better?");
	JLabel feedback2 = new JLabel ("Please write your comments below.");
	feedback.setFont (new Font ("ARIAL", Font.BOLD, 40));
	feedback.setForeground (Color.white);
	feedback2.setFont (new Font ("ARIAL", Font.BOLD, 40));
	feedback2.setForeground (Color.white);
	// title
	JLabel title = new JLabel ("You Win!");
	title.setFont (new Font ("CHILLER", Font.BOLD, 100));
	title.setForeground (Color.white);
	// next button is set up
	JButton next = new JButton ("Next");
	next.setActionCommand ("s5");
	next.addActionListener (this);
	next.setForeground (Color.white);
	next.setBackground (Color.black);
	// slider is constructed
	JSlider red = new JSlider (JSlider.HORIZONTAL, 0, 10, 0);
	red.addChangeListener (this);
	red.setMajorTickSpacing (5);
	red.setMinorTickSpacing (1);
	red.setPaintTicks (true);
	red.setPaintLabels (true);
	red.setPreferredSize (new Dimension (600, 100));
	red.setBackground (Color.black);
	// feedback text field is constructed
	feed = new JTextField (50);
	// widgets are added to screens
	card4.add (title);
	card4.add (sliderfb);
	card4.add (red);
	card4.add (feedback);
	card4.add (feedback2);
	card4.add (feed);
	card4.add (pic);
	card4.add (next);
	p_card.add ("4", card4);
    }


    public void screen5 ()
    { //screen 5 is set up.
	card5 = new Panel ();
	card5.setBackground (Color.black);
	// last screen title
	JLabel title = new JLabel ("THANKS FOR PLAYING!.");
	title.setFont (new Font ("CHILLER", Font.PLAIN, 60));
	title.setForeground (Color.white);
	// last comments
	JLabel comment = new JLabel ("Thanks to you, the concert was able to go on.");
	comment.setForeground (Color.white);
	comment.setFont (new Font ("Times New Roman", Font.PLAIN, 30));
	JLabel comment2 = new JLabel ("I don't know what we would do without you!");
	comment2.setForeground (Color.white);
	comment2.setFont (new Font ("Times New Roman", Font.PLAIN, 30));
	// "back to introduction" button is setup
	JButton next = new JButton ("Back to Introduction?");
	next.setActionCommand ("s1");
	next.addActionListener (this);
	next.setBackground (Color.black);
	next.setForeground (Color.white);
	next.setPreferredSize (new Dimension (500, 50));
	// "quit" button is setup
	JButton end = new JButton ("Quit?");
	end.setBackground (Color.black);
	end.setForeground (Color.white);
	end.setPreferredSize (new Dimension (500, 50));
	end.setActionCommand ("s6");
	end.addActionListener (this);
	// picture shown on the last screen
	// It is a picture of a clear stage
	JLabel endpic = new JLabel (createImageIcon ("endpic.jpg"));
	// widgets are added to screen5
	card5.add (title);
	card5.add (comment);
	card5.add (comment2);
	card5.add (endpic);
	card5.add (next);
	card5.add (end);
	p_card.add ("5", card5);
    }


    //Method to copy new level onto the same grid and screen
    public void copyOver (int[] [] m, int[] [] n)
    { //copy every element of n into m
	//that changes the level
	for (int i = 0 ; i < row ; i++)
	    for (int j = 0 ; j < col ; j++)
		m [i] [j] = n [i] [j];
	redraw ();
    }


    // Method changes levels and copies level over when player completes level before
    public void levelUp ()
    {
	level++;
	// level one
	if (level == 1)
	{
	    copyOver (b, level1);
	    copyOver (ans, ans1);
	    copyOver (r, level1);
	    showStatus ("Keep going");
	    nextlevel.setEnabled (false); // next button can only be clicked if they complete the level correctly
	}

	// level two
	else if (level == 2)
	{
	    copyOver (b, level2);
	    copyOver (ans, ans2);
	    copyOver (r, level2);
	    showStatus ("Keep going");
	    nextlevel.setEnabled (false); // next button can only be clicked if they complete the level correctly
	}
	// level three
	else if (level == 3)
	{
	    copyOver (b, level3);
	    copyOver (ans, ans3);
	    copyOver (r, level3);
	    showStatus ("Keep going");
	    nextlevel.setEnabled (false); // next button can only be clicked if they complete the level correctly
	}
	else
	{ //show your final win screen.
	    cdLayout.show (p_card, "4");
	    showStatus ("YOU WIN");
	}
	// sets the player back to the same spot
	px = 2;
	py = 4;
	//call redraw to update the screen
	redraw ();
    }


    // creates the image on the screen
    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = FinalGame.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}


	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    // redraws the original array into the grid
    public void redraw ()
    {
	int move = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    // sets  the image onto right on the grip
	    for (int j = 0 ; j < col ; j++)
	    {
		a [move].setIcon (createImageIcon (b [i] [j] + ".jpg"));
		move++;
	    }
	}

	// draws player in the grid
	a [px * col + py].setIcon (createImageIcon ("2.jpg"));
    }


    // reset thr grid back to the rigth grid based on the level
    public void reset ()
    { //copy every element of r into b
	//that sets it back to the original
	for (int i = 0 ; i < row ; i++)
	    for (int j = 0 ; j < col ; j++)
		b [i] [j] = r [i] [j];
	// sets the player in the rigth spot
	px = 2;
	py = 4;
	// draws the correct array onto the grid
	redraw ();
    }


    //Methos checks if they completed the level correctly
    public boolean check ()
    {
	// checks if the player's grid mathces the answer grid
	for (int i = 0 ; i < row ; i++)
	    for (int j = 0 ; j < col ; j++)
		if (ans [i] [j] != b [i] [j])
		    // If it does not match the grid answer
		    return false;
	//If it does match the grid answer
	return true;
    }


    // Keeps track of the moves made by the player and updates it on the screen
    public void score ()
    {
	sum++;
	scorenum.setText ("Moves:  " + sum);
    }


    //Keeps track of what level the player is on and updates it on the screen
    public void level ()
    {
	levelnum++;
	leveln.setText ("Level: " + levelnum);
    }


    // Up button is coded
    public void up ()
    {
	// movement conditions
	if (b [px - 1] [py] == 4)
	    px--;
	else if (b [px - 1] [py] == 1 && b [px - 2] [py] == 4)
	{
	    b [px - 1] [py] = 4;
	    b [px - 2] [py] = 1;
	    px--;
	}
	else if (b [px - 1] [py] == 1 && b [px - 2] [py] == 3)
	{
	    b [px - 1] [py] = 4;
	    b [px - 2] [py] = 4;
	    px--;
	}
	score ();
	redraw ();
    }


    // down button is coded
    public void down ()
    {
	// movement conditions
	if (b [px + 1] [py] == 4)
	    px++;
	else if (b [px + 1] [py] == 1 && b [px + 2] [py] == 4)
	{
	    b [px + 1] [py] = 4;
	    b [px + 2] [py] = 1;
	    px++;
	}
	else if (b [px + 1] [py] == 1 && b [px + 2] [py] == 3)
	{
	    b [px + 1] [py] = 4;
	    b [px + 2] [py] = 4;
	    px++;
	}
	score ();
	redraw ();
    }


    // left button is coded
    public void left ()
    {
	// movement conditions
	if (b [px] [py - 1] == 4)
	    py--;
	else if (b [px] [py - 1] == 1 && b [px] [py - 2] == 4)
	{
	    b [px] [py - 1] = 4;
	    b [px] [py - 2] = 1;
	    py--;
	}
	else if (b [px] [py - 1] == 1 && b [px] [py - 2] == 3)
	{
	    b [px] [py - 1] = 4;
	    b [px] [py - 2] = 4;
	    py--;
	}
	score ();
	redraw ();
    }


    //right button is coded
    public void right ()
    {
	//movement conditions
	if (b [px] [py + 1] == 4)
	    py++;
	else if (b [px] [py + 1] == 1 && b [px] [py + 2] == 4)
	{
	    b [px] [py + 1] = 4;
	    b [px] [py + 2] = 1;
	    py++;
	}
	else if (b [px] [py + 1] == 1 && b [px] [py + 2] == 3)
	{
	    b [px] [py + 1] = 4;
	    b [px] [py + 2] = 4;
	    py++;
	}
	score ();
	redraw ();
    }


    /** Listen to the slider. */
    public void stateChanged (ChangeEvent e)
    {
	JSlider source = (JSlider) e.getSource ();
	if (!source.getValueIsAdjusting ())
	{
	    q = (int) source.getValue ();
	    showStatus (q + "");
	}
    }


    // Method to control what happens when "reset" button is pressed
    public void card ()
    {
	reset ();
	levelnum = 0;
	leveln.setText ("Level: 1");
	scorenum.setText ("Moves: 0");
    }


    // Method to control what happens when "Back to introduction" button is pressed
    public void s1press ()
    {
	cdLayout.show (p_card, "1");
	level = 0;
	sum = 0;
	scorenum.setText ("Moves: " + sum);
	levelnum = 1;
	leveln.setText ("Level: " + levelnum);
	levelUp ();
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("s1"))
	    // everything is set back to the original array
	    s1press ();
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("back"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s3"))
	{
	    cdLayout.show (p_card, "3");
	    // sound plays when player reaches the game screen
	    sound ();
	}
	// is the player wins the game and completes all the levels
	else if (e.getActionCommand ().equals ("win"))
	{
	    cdLayout.show (p_card, "4");
	}
	else if (e.getActionCommand ().equals ("s5"))
	    cdLayout.show (p_card, "5");
	// if the "quit" button is pressed
	else if (e.getActionCommand ().equals ("s6"))
	    System.exit (0);
	// if the "up" button is pressed
	else if (e.getActionCommand ().equals ("up"))
	    up ();
	// if the "down" button is pressed
	else if (e.getActionCommand ().equals ("down"))
	    down ();
	// if the "left" button is pressed
	else if (e.getActionCommand ().equals ("left"))
	    left ();
	// if the "right button is pressed
	else if (e.getActionCommand ().equals ("right"))
	    right ();
	// if the reset button is pressed
	else if (e.getActionCommand ().equals ("reset1"))
	    // resets the screen to the right level
	    card ();
	// check button is pressed
	else if (e.getActionCommand ().equals ("s0"))
	{

	    if (check () == true)
	    {
		// if the player's grid is correct, they can move to the next level
		nextlevel.setEnabled (true);
	    }
	}
	// next level button clicked
	else if (e.getActionCommand ().equals ("s4"))
	{
	    // They move to the next level
	    levelUp ();
	    // moves made is set 0
	    sum = 0;
	    // the level label is set back to 1
	    level ();
	}
	// if their grid is not correct
	else
	{
	    showStatus ("Keep going");
	}
    }
}


