import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Flappy extends JFrame implements ActionListener, KeyListener {

	Bird bird = new Bird();
	ArrayList<Pipe> pipes = new ArrayList<Pipe>();
	int c = 0;
	int last = 0;
	
	public Flappy() {
		this.setVisible(true);
		this.setSize(600, 600);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
		Timer t = new Timer(10, this);
		t.start();
	}
	
	public static void main(String[] args) {
		Flappy flappy = new Flappy();
		
	}
	
	public void paint(Graphics g) {
		if (c % 100 == 0)
		{
			int offset = (int)(Math.random()*300)-150;
			int y = last + offset;
			if (y > 400)
				y = 400;
			if (y < 300)
				y = 300;
			pipes.add(new Pipe(y));
			last = y;
		}
		c++;
		g.clearRect(0, 0, 600, 600);
		bird.draw(g);
		if (bird.y > 600)
		{
			bird.ay = 0;
			bird.y = 590;
			bird.dy = 0;
		}
		ArrayList<Pipe> toDelete = new ArrayList<Pipe>();
		for (Pipe pipe : pipes)
		{
			if (pipe.x < 0)
				toDelete.add(pipe);
			pipe.draw(g);
			if (distanceFromBirdTo(pipe) < 10)
			{
				System.exit(0);
			}
		}
		for (Pipe pipe : toDelete)
		{
			pipes.remove(pipe);
		}
	}
	
	public int distanceFromBirdTo(Pipe pipe)
	{
		double distanceTop;
		double distanceBottom;
		int yTop = pipe.gapY;
		int yBottom = pipe.gapY + 200;
		distanceTop = Math.sqrt(
				Math.pow(pipe.x - 300, 2) + 
				Math.pow(yTop - bird.y, 2)
				);

		distanceBottom = Math.sqrt(
				Math.pow(pipe.x - 300, 2) + 
				Math.pow(yBottom - bird.y, 2)
				);
		
		if ((pipe.x - 300) < 20 && (bird.y > yBottom || bird.y < yTop))
			return 0;
		
		return (int)Math.min(distanceTop, distanceBottom);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			bird.dy = -5;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

class Bird {
	
	int y = 0;
	float dy = 0;
	float ay = (float)9.8/100;
	
	
	public Bird()
	{
		this.y = 50;
	}
	
	public void draw(Graphics g)
	{
		dy += ay;
		y += dy;
		g.fillOval(295, y-10, 20, 20);
	}
	
}

class Pipe {
	int x = 600;
	int gapY = 0;
	
	public Pipe(int gapY){
		this.gapY = gapY;
	}
	
	public void draw(Graphics g)
	{
		x -= 4;
		g.fillRect(x, 0, 40, gapY);
		g.fillRect(x, gapY + 200, 40, 600 - gapY - 200);
	}
}