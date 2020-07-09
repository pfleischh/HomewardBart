
package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<String> bricks = Main.read("LevelOne.txt");
		
		
		Maze window = new Maze(bricks);
		window.setTitle("Homeward Bart");
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// use filestream reader to take text file and create map

	private static ArrayList<String> read(String filename){
		ArrayList<String> lines = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line;
			
			
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			// close the input stream
			in.close();
			
		}catch(Exception e) {
			System.err.println("Error; " + e.getMessage());
		}
		return lines;
	}

}
