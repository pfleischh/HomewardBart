package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JFrame;


public class Maze extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static final int BRICK_SIZE=20;
	
	
	ArrayList<String> bricks;
	
	// read text file into an arraylist to make the maze
	public Maze(ArrayList<String> bricks) {
		if(bricks.size()!=0) {
			// calculate size of maze map
			int width =bricks.get(0).toCharArray().length*BRICK_SIZE;
			int height=bricks.size()*BRICK_SIZE;
			this.setSize(width+(3*BRICK_SIZE), height+(3*BRICK_SIZE));
		}
		this.bricks=bricks;

	}
	// draw bricks of maze
	@Override
	public void paint(Graphics g) {
		
		super.paintComponents(g);
		
		Graphics2D painter = (Graphics2D) g.create();
		painter.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		painter.setColor(Color.WHITE);
		painter.fillRect(0,0, getWidth(), getHeight());
		
		Color line = Color.gray.brighter();
		Color fill= Color.blue;
		
		int x=0;
		int y=BRICK_SIZE+20;
		
		for(String wall: this.bricks) {
			x=BRICK_SIZE+10;
			for (char c : wall.toCharArray()) {
				// if character # on map text file set color blue
				if(c=='#') {
					painter.setColor(fill);
					painter.fillRect(x,  y, BRICK_SIZE, BRICK_SIZE);
				}
				// set blank space on map file to gray
				else {
					painter.setColor(line);
					painter.drawRect(x, y, BRICK_SIZE, BRICK_SIZE);
				}
				x += BRICK_SIZE;
			}
			y += BRICK_SIZE;
		}
	}
}
