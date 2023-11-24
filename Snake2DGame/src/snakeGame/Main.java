package snakeGame;

import java.awt.Color;

import javax.swing.JFrame;

/*
 * @author Yogesh Burman
 */

public class Main {

	public static void main(String[] args) {

		JFrame jframe = new JFrame("Snake Game by Yogesh");
		jframe.setBounds(10, 10, 890, 700);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel gamePanel = new GamePanel();
		gamePanel.setBackground(Color.LIGHT_GRAY);

		jframe.add(gamePanel);

		jframe.setVisible(true);

	}

}
