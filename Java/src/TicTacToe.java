import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.JFrame;

public class TicTacToe extends JFrame 
implements MouseListener,
ActionListener
{

	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;
	public static final int VERTICAL_X_1 = 225;
	public static final int VERTICAL_X_2 = 375;
	public static final int VERTICAL_Y_1 = 75;
	public static final int VERTICAL_Y_2 = 525;

	public static final int HORIZONTAL_X_1 = 75;
	public static final int HORIZONTAL_X_2 = 525;
	public static final int HORIZONTAL_Y_1 = 225;
	public static final int HORIZONTAL_Y_2 = 375;

	public static int counter = 0;
	public static char turnVariable = 'X';
	public static int [][] myArray = new int[3][3];

	public static void main(String[] args) 
	{
		TicTacToe w = new TicTacToe();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(600, 600);
		w.setVisible(true);	
		w.addMouseListener(w);
	}

	public void actionPerformed(ActionEvent e)
	{


	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e) 
	{


	}


	public void mouseExited(MouseEvent e) 
	{


	}


	public void mousePressed(MouseEvent e)
	{
		double xClick = e.getX();
		double yClick = e.getY();
		if(counter == 0 && 
				xClick >= VERTICAL_X_1 && 
				xClick <= VERTICAL_X_1 + 150 && 
				yClick >=  VERTICAL_Y_1 && 
				yClick <= VERTICAL_Y_1 + 50)
		{	
			repaint();
		}
		else
		{
			boolean done = false;
			while(!done)
			{
				if(xClick <= VERTICAL_X_1 && 
						xClick >= HORIZONTAL_X_1 && 
						yClick >=  VERTICAL_Y_1 && 
						yClick <= HORIZONTAL_Y_1)
				{
					if(turnVariable == 'X' && myArray[0][0] == 0)
					{
						myArray[0][0] = 1;
						done = true;
					}
					else if(myArray[0][0] == 0)
					{
						myArray[0][0] = 2;
						done = true;
					}
				}
				else if(xClick <= VERTICAL_X_2 && 
						xClick >= VERTICAL_X_1 && 
						yClick >=  VERTICAL_Y_1 && 
						yClick <= HORIZONTAL_Y_1)
				{
					if(turnVariable == 'X' && myArray[0][1] == 0)
					{
						myArray[0][1] = 1;
						done = true;
					}
					else if(myArray[0][1] == 0)
					{
						myArray[0][1] = 2;
						done = true;
					}
				}
				else if(xClick <= HORIZONTAL_X_2 && 
						xClick >= VERTICAL_X_2 && 
						yClick >=  VERTICAL_Y_1 && 
						yClick <= HORIZONTAL_Y_1)
				{
					if(turnVariable == 'X' && myArray[0][2] == 0)
					{
						myArray[0][2] = 1;
						done = true;
					}
					else if(myArray[0][2] == 0)
					{
						myArray[0][2] = 2;
						done = true;
					}
				}

				else if(xClick <= VERTICAL_X_1 && 
						xClick >= HORIZONTAL_X_1 && 
						yClick >= HORIZONTAL_Y_1 && 
						yClick <= HORIZONTAL_Y_2)
				{
					if(turnVariable == 'X' && myArray[1][0] == 0)
					{
						myArray[1][0] = 1;
						done = true;
					}
					else if(myArray[1][0] == 0)
					{
						myArray[1][0] = 2;
						done = true;
					}
				}
				else if(xClick <= VERTICAL_X_2 && 
						xClick >= VERTICAL_X_1 && 
						yClick >=  HORIZONTAL_Y_1 && 
						yClick <= HORIZONTAL_Y_2)
				{
					if(turnVariable == 'X' && myArray[1][1] == 0)
					{
						myArray[1][1] = 1;
						done = true;
					}
					else if(myArray[1][1] == 0)
					{
						myArray[1][1] = 2;
						done = true;
					}
				}
				else if(xClick <= HORIZONTAL_X_2 && 
						xClick >= VERTICAL_X_2 && 
						yClick >=  HORIZONTAL_Y_1 && 
						yClick <= HORIZONTAL_Y_2)
				{
					if(turnVariable == 'X' && myArray[1][2] == 0)
					{
						myArray[1][2] = 1;
						done = true;
					}
					else if(myArray[1][2] == 0)
					{
						myArray[1][2] = 2;
						done = true;
					}
				}
				else if(xClick <= VERTICAL_X_1 && 
						xClick >= HORIZONTAL_X_1 && 
						yClick >=  HORIZONTAL_Y_2 && 
						yClick <= VERTICAL_Y_2)
				{
					if(turnVariable == 'X' && myArray[2][0] == 0)
					{
						myArray[2][0] = 1;
						done = true;
					}
					else if(myArray[2][0] == 0)
					{
						myArray[2][0] = 2;
						done = true;
					}
				}
				else if(xClick <= VERTICAL_X_2 && 
						xClick >= VERTICAL_X_1 && 
						yClick >=  HORIZONTAL_Y_2 && 
						yClick <= VERTICAL_Y_2)
				{
					if(turnVariable == 'X' && myArray[2][1] == 0)
					{
						myArray[2][1] = 1;
						done = true;
					}
					else if(myArray[2][1] == 0)
					{
						myArray[2][1] = 2;
						done = true;
					}
				}
				else if(xClick <= HORIZONTAL_X_2 && 
						xClick >= VERTICAL_X_2 && 
						yClick >=  HORIZONTAL_Y_2 && 
						yClick <= VERTICAL_Y_2)
				{
					if(turnVariable == 'X' && myArray[2][1] == 2)
					{
						myArray[2][2] = 1;
						done = true;
					}
					else if(myArray[2][2] == 0)
					{
						myArray[2][2] = 2;
						done = true;
					}
				}
			}
		}
		counter++;
		repaint();
	}


	public void mouseReleased(MouseEvent e) 
	{


	}

	public void paint ( Graphics g )
	{
		if(counter % 2 == 0)
		{
			turnVariable = 'X';
		}
		else
		{
			turnVariable = 'O';
		}

		if(counter == 0)
		{
			g.setColor(Color.GREEN);
			g.fillRoundRect(VERTICAL_X_1, VERTICAL_Y_1, 150, 50 , 25 , 25);	

			g.setColor(Color.BLACK);
			g.setFont(new Font("Serif", Font.BOLD, 40));
			g.drawString("PLAY", VERTICAL_X_1 + 25, VERTICAL_Y_1 + 40);

			g.setFont(new Font("Serif", Font.BOLD, 20));
			g.drawString("Rules:", VERTICAL_X_1 - 125, VERTICAL_Y_1 + 300);
			g.drawString("- O goes first", VERTICAL_X_1 - 125,  VERTICAL_Y_1 + 325);
			g.drawString("- Click the square you would like to place your marker", VERTICAL_X_1 - 125,  VERTICAL_Y_1 + 350);
			g.drawString("- Click play to start playing", VERTICAL_X_1 - 125,  VERTICAL_Y_1 + 375);
		}
		else
		{
			g.clearRect(0,0,SCREEN_WIDTH, SCREEN_HEIGHT);
			g.drawLine(VERTICAL_X_1, VERTICAL_Y_1, VERTICAL_X_1, VERTICAL_Y_2);
			g.drawLine(VERTICAL_X_2, VERTICAL_Y_1, VERTICAL_X_2, VERTICAL_Y_2);
			g.drawLine(HORIZONTAL_X_1, HORIZONTAL_Y_1, HORIZONTAL_X_2, HORIZONTAL_Y_1);
			g.drawLine(HORIZONTAL_X_1, HORIZONTAL_Y_2, HORIZONTAL_X_2, HORIZONTAL_Y_2);

			g.drawString("Turn: " + turnVariable, 25, VERTICAL_Y_1 + 50);

			for(int row = 0; row < myArray.length; row++)
			{
				for(int col = 0; col < myArray[0].length; col++)
				{
					if(myArray[row][col] == 1)
					{
						g.drawLine(75 + col * 150, 75 + row * 150, 225 + col * 150, 225 + row * 150);
						g.drawLine(75 + col * 150, 225 + row * 150, 225 + col * 150, 75 + row * 150);
					}
					else if(myArray[row][col] == 2)
					{
						g.drawOval(75 + col * 150, 75 + row * 150, 150, 150);
					}
				}
			}
		}
	}


}
