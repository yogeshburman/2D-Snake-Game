package snakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private int[] snakeXLength = new int[750];
	private int[] snakeYLength = new int[750];
	private int lengthOfSnake = 3;

	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private int moves = 0;

	private ImageIcon snakeTitle = new ImageIcon("./Resources/assets/snaketitle.jpg");
	private ImageIcon leftMouth = new ImageIcon("./Resources/assets/leftmouth.png");
	private ImageIcon rightMouth = new ImageIcon("./Resources/assets/rightmouth.png");
	private ImageIcon upMouth = new ImageIcon("./Resources/assets/upmouth.png");
	private ImageIcon downMouth = new ImageIcon("./Resources/assets/downmouth.png");
	private ImageIcon snakeImage = new ImageIcon("./Resources/assets/snakeimage.png");
	private ImageIcon enemy = new ImageIcon("./Resources/assets/enemy.png");

	Random random = new Random();
	int enemyX = 0, enemyY = 0;

	private Timer timer;
	private int delay = 10;

	GamePanel() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		enemy();
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);

//		graphics.drawRect(15, 10, 850, 55);
//		graphics.drawRect(15, 74, 850, 580);

		snakeTitle.paintIcon(this, graphics, 16, 11);
		graphics.setColor(Color.black);
		graphics.fillRect(15, 74, 850, 580);

		if (moves == 0) {

			snakeXLength[0] = 100;
			snakeXLength[1] = 75;
			snakeXLength[2] = 50;

			snakeYLength[0] = 100;
			snakeYLength[1] = 100;
			snakeYLength[2] = 100;

		}

		if (left) {
			leftMouth.paintIcon(this, graphics, snakeXLength[0], snakeYLength[0]);
		}
		if (right) {
			rightMouth.paintIcon(this, graphics, snakeXLength[0], snakeYLength[0]);
		}
		if (up) {
			upMouth.paintIcon(this, graphics, snakeXLength[0], snakeYLength[0]);
		}
		if (down) {
			downMouth.paintIcon(this, graphics, snakeXLength[0], snakeYLength[0]);
		}

		for (int i = 0; i < lengthOfSnake; i++) {
			snakeImage.paintIcon(this, graphics, snakeXLength[i], snakeYLength[i]);
		}

		enemy.paintIcon(this, graphics, enemyX, enemyY);

		graphics.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = lengthOfSnake - 1; i > 0; i--) {
			snakeXLength[i] = snakeXLength[i - 1];
			snakeYLength[i] = snakeYLength[i - 1];
		}

		if (left == true) {
			snakeXLength[0] = snakeXLength[0] - 5;
			moves++;
		}

		if (right == true) {
			snakeXLength[0] = snakeXLength[0] + 5;
//			moves++;
		}

		if (up) {
			snakeYLength[0] = snakeYLength[0] - 5;
			moves++;
		}

		if (down) {
			snakeYLength[0] = snakeYLength[0] + 5;
			moves++;
		}

		if (snakeXLength[0] > 780) {
			down = true;
			right = false;
			up = false;
			left = false;
//			snakeXLength[0] = 25;

		}

		if (snakeXLength[0] < 25) {
			down = false;
			left = false;
			up = false;
			right = true;

//			snakeXLength[0] = 780;
		}

		if (snakeYLength[0] > 600) {
			up = false;
			down = false;
			right = true;
			left = false;

//			snakeYLength[0] = 25;

		}

		if (snakeYLength[0] < 25) {

//			snakeYLength[0] = 780;
			up = false;
			down = false;
			right = true;
			left = false;

		}

		if (snakeXLength[0] == enemyX || snakeYLength[0] == enemyY) {
			enemy();
		}

		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		System.out.println("Key Code: " + e.getKeyCode());
		switch (e.getKeyCode()) {

		case KeyEvent.VK_RIGHT:
			if (left != true) {
				up = false;
				down = false;
				right = true;
				left = false;
			}
			break;

		case KeyEvent.VK_LEFT:
			if (right != true) {
				up = false;
				down = false;
				right = false;
				left = true;
			}

			break;

		case KeyEvent.VK_UP:

			if (down != true) {
				up = true;
				down = false;
				right = false;
				left = false;
			}

			break;

		case KeyEvent.VK_DOWN:
			if (up != true) {
				up = false;
				down = true;
				right = false;
				left = false;
			}

			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void enemy() {

		enemyX = random.nextInt(500);
//		if (enemyX % 5 != 0) {
//			enemy();
//		}
		enemyY = random.nextInt(500);
//		if (enemyY % 5 != 0) {
//			enemy();
//		}

	}

}
