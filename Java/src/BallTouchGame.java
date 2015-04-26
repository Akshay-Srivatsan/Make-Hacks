import java.awt.*;
import java.lang.Math;
import javax.swing.*;

import java.awt.event.*;
import java.util.Random;

/******************************************************************************
 * Name:		Nikhar Arora
 * Block:		B
 * Date:		3/28/14
 *  						
 * 
 *  Program #20: Mouse Challenge
 *  Description:
 *  This program has a ball that bounces around the screen. When the user misses the
 *  ball, the ball get bigger and slower. When the user hits the ball, the ball gets
 *  smaller and faster. When the user reaches a radius of 12, they win.
*****************************************************************************/
public class BallTouchGame extends JFrame
                       implements MouseListener,
                       ActionListener
{
	//Make the ball
	private Ball b;
	
	//Finals
	private static final int MAX_WIDTH = 700;
	private static final int MAX_HEIGHT = 500;
	private static final int TOP_OF_WINDOW = 22;
	private static final int RADIUS_MAX = 250;
	private static final int RADIUS_MIN = 12;
	private static final int DELAY_IN_MILLISEC = 30;
	private static final int START_VELOCITY = 10;
	private static final int START_X = 200;
	private static final int START_Y = 200;
	private static final int START_RADIUS = 75;
	
	/**
	 * Create the window and register this as a MouseListener and a MouseMotionListener
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		BallTouchGame md = new BallTouchGame();
		md.setSize(700, 500);
		md.setVisible(true);
		
		// Register listeners
		md.addMouseListener(md);
	}

	/**
	 * MouseDemo constructor.  Just create the ball.
	 */
	public BallTouchGame()
	{
		int radius = START_RADIUS;
		int x = START_X;
		int y = START_Y;
		int dx = START_VELOCITY;
		int dy = START_VELOCITY;
		
		b = new Ball(x, y, dx , dy, radius, Color.red);
		
		setSize(MAX_WIDTH, MAX_HEIGHT);
		setVisible(true);	

		Timer clock= new Timer(DELAY_IN_MILLISEC, this);												
		
		clock.start();	
	}
	
	/**
	 * Call methods in the Ball class to move and bounce
	 */
	public void actionPerformed(ActionEvent e)		// NEW #5 !!!!!!!!!!
	{
		// Move the balls.
		b.move();
		b.bounce(0, MAX_WIDTH, TOP_OF_WINDOW, MAX_HEIGHT);
			
		// Update the window.
		repaint();
	}
	
	/**
	 * Call methods in the Ball Class to draw the ball and the status
	 * 
	 * @param g		The usual Graphics object
	 */
	public void paint(Graphics g)
	{
		
		g.setColor(Color.white);
		g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);
				
		b.draw(g);
		b.drawHitsAndMisses(g);
		b.drawIfWin(g, RADIUS_MIN);
			
	}
	
	/********************************************
	   MouseListener event handlers
	********************************************/	

	/**
	 * Called when the mouse is clicked (= pressed and released without moving
	 *    while the mouse is in our window)
	 * Required for any MouseListener
	 * Rotate through the colors on mouse clicks.
	 * 
	 * @param e		Contains info about the mouse click
	 */
	public void mouseClicked(MouseEvent e)
	{
	}
	
	/**
	 * Called when the mouse is pressed (in our window)
	 * Required for any MouseListener
	 * 
	 * @param e		Contains info about the mouse click
	 */
	public void mousePressed(MouseEvent e)
	{

		double xClick = e.getX();
		double yClick = e.getY();
		boolean clicked = b.checkIfClicked(xClick, yClick);
		if(clicked == true)
		{
			b.smallerAndFaster(RADIUS_MIN);
		}
		else
		{
			b.biggerAndSlower(RADIUS_MAX);
		}
	}
	
	/**
	 * Called when the mouse is released (in our window)
	 * Required for any MouseListener
	 * 
	 * @param e		Contains info about the mouse click
	 */
	public void mouseReleased(MouseEvent e)
	{
	}
	
	/**
	 * Called when the mouse enters our window.
	 * Required for any MouseListener
	 * 
	 * @param e		Contains info about the mouse click
	 */
	public void mouseEntered(MouseEvent e)
	{
	}
	
	/**
	 * Called when the mouse exits our window.
	 * Required for any MouseListener
	 * 
	 * @param e		Contains info about the mouse click
	 */
	public void mouseExited(MouseEvent e)
	{
	}
}
/***********************************************************************
   Ball Class
 ***********************************************************************************/
class Ball
{
	// DATA:
	private double x, y;		// Center of the ball
	private double dx, dy;		// Velocity - how much to change x and y by
							//		when the the ball moves
	private double radius;		// Radius of the ball
	private Color color;	// Color of the ball
	private int numberOfHits = 0;
	private int numberOfMisses = 0;
	
	// METHODS:
	
	/**
	 * Ball constructor initializes the Ball object
	 * 
	 * @param xIn		x coordinate of center
	 * @param yIn		y coordinate of center
	 * @param dxIn		x velocity
	 * @param dyIn		y velocity
	 * @param radiusIn	radius
	 * @param colorIn	color
	 */
	public Ball (int xIn, int yIn, int dxIn, int dyIn, int radiusIn, Color colorIn)
	{
		// Nothing to do but save the data in the object's data fields.
		x = xIn;
		y = yIn;
		dx = dxIn;
		dy = dyIn;
		radius = radiusIn;
		color = colorIn;
	}
	
	/**
	 * Check if the user clicked within the ball
	 * @param xClick	The x location of the user's click
	 * @param yClick	The y location of the user's click
	 * @return
	 */
	public boolean checkIfClicked(double xClick, double yClick)
	{
		if(Math.sqrt(((xClick - x) * (xClick - x)) + ((yClick - y) * (yClick - y))) <= radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void biggerAndSlower(int RADIUS_MAX)
	{
		radius = radius * 2;
		if(radius > RADIUS_MAX)
		{
			radius = RADIUS_MAX;
		}
		dx = dx / 2;
		
		dy = dy / 2;
		
		numberOfMisses++;
	}
	public void smallerAndFaster(int RADIUS_MIN)
	{
		radius = radius/2;
		if(radius < RADIUS_MIN)
		{
			radius = RADIUS_MIN;
		}
		dx = dx * 2;
		
		dy = dy * 2;
		
		numberOfHits++;
	}

	/**
	 * Move the ball.  Add the velocity to its center.
	 */
	public void move()
	{
		x = x + dx;
		y = y + dy;
	}
	
	/**
	 * Check if the ball should bounce off any of the walls.  It will only
	 * bounce if it was heading toward the wall and went a bit past it.  If
	 * so just change the sign of the corresponding velocity.  Not a very
	 * accurate way to handle this, but it is simple and it mostly works.
	 * 
	 * @param xLow		x coord of left wall
	 * @param xHigh		x coord of right wall
	 * @param yLow		y coord of top wall
	 * @param yHigh		y coord of bottom wall
	 */
	public void bounce(int xLow, int xHigh, int yLow, int yHigh)
	{
		// Check for an x bounce.  Note that we bounce if the x is too
		//  low or too high AND IS HEADING IN THE WRONG DIRECTION.
		if ((x - radius <= xLow && dx < 0) || (x + radius >= xHigh && dx > 0))
		{
			dx = -dx;
		}
			
		// Now check for a y bounce.
		if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0))
		{
			dy = -dy;
		}
	}
	
	/**
	 * Draw the ball.
	 * 
	 * @param g			Graphics object in which to draw
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval((int)(x - radius),(int)(y - radius),(int)(2 * radius),(int)(2 * radius));
	}
	
	public void drawHitsAndMisses(Graphics g)
	{
		g.setFont(new Font("Serif", Font.ITALIC, 20));
		g.setColor(Color.black);
		g.drawString("Hits: " + numberOfHits,400, 450);
		g.drawString("Misses: " + numberOfMisses, 500, 450);
	}
	
	public void drawIfWin(Graphics g, int RADIUS_MIN)
	{
		if(radius == RADIUS_MIN)
		{
			g.setFont(new Font("Serif", Font.ITALIC, 50));
			g.setColor(Color.black);
			g.drawString("You Win",250, 300);
			changeColor();
		}
	}
	
	public void changeColor()
	{
		//Generates a new color for every ball
		Random gen = new Random();
		final int COLOR_MAX = 256;
		final int COLOR_MIN = 0;
		int red = gen.nextInt(COLOR_MAX - COLOR_MIN) + COLOR_MIN;
		int green = gen.nextInt(COLOR_MAX - COLOR_MIN) + COLOR_MIN;
		int blue = gen.nextInt(COLOR_MAX - COLOR_MIN) + COLOR_MIN;
		color = new Color(red, green, blue);
	}
	
}
			
		
	