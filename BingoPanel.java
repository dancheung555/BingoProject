import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.*;



public class BingoPanel extends JPanel implements KeyListener, MouseListener {
	
	private BingoCard card;
	private Graphics g = null;
	
	public BingoPanel(BingoCard card) {
		super();
		this.card = card;
		
		addMouseListener(this);
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		double distance = Math.sqrt((x-950)*(x-950)+(y-125)*(y-125));
		if(distance <= 50) {
			System.out.println(distance);
			g.setColor(new Color(0, 125, 125));
			
		}
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		try {
            graphics.drawImage(ImageIO.read(Objects.requireNonNull(getClass().getResource("BingoTemplate.png"))), 0, 0, null);
            drawText(graphics);
        } catch (IOException e) {
            e.printStackTrace();
        }
		graphics.setColor(Color.red);
		graphics.fillOval(900, 75, 100, 100);			//900-1000, 75-175
//		graphics.drawString("TEST", 900, 75);
		graphics.setColor(Color.white);
		graphics.setFont(new Font("", Font.PLAIN, 30));
		graphics.drawString("Ball", 925, 140);
		graphics.setColor(new Color(0, 0, 255));
		graphics.fillRect(900, 275, 120, 60);
		repaint();
	}
	
	
	
	private void drawText(Graphics numbers) {
		Font font = new Font("Times New Roman", Font.PLAIN, 40);
		numbers.setFont(font);
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if(!(row == 2 && col == 2)) numbers.drawString(Integer.toString(card.getTile(row, col).getValue()), row * 126 + 89, col * 129 + 227);
			}
		}
	}
}
