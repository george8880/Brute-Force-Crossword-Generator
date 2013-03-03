import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class aftab
{
	JFrame frame = new JFrame("Test");	
	final String newline = "\n";
	String text = "";
	
	int[][] ten1a = {{15,1,15,-1,1,15,15,15,1,1},
						 {1,1,1,-1,1,1,15,15,1,1},
						 {1,5,1,-1,1,1,1,1,1,1},
						 {1,1,1,1,1,1,-1,1,1,1},
						 {1,1,15,1,-1,1,1,-1,-1,-1},
						 {-1,-1,-1,1,1,-1,1,1,1,1},
						 {1,15,15,-1,1,1,1,1,1,1},
						 {1,1,1,1,15,1,-1,1,1,1},
						 {1,1,1,1,1,1,-1,1,1,1},
						 {1,1,15,15,1,1,-1,1,1,1}};
						 
	int[][] ten1b = {{1,2,3,0,4,5,6,7,8,9}, 
						{10,0,0,0,11,0,0,0,0,0},
						{12,0,0,0,13,0,0,0,0,0},
						{14,0,0,15,0,0,0,16,0,0},
						{17,0,0,0,0,18,19,0,0,0},
						{0,0,0,20,21,0,22,23,24,25},
						{26,27,28,0,29,30,0,0,0,0},
						{31,0,0,32,0,0,0,33,0,0},
						{34,0,0,0,0,0,0,35,0,0}};

	public aftab()
	{	
		JTextArea clueBoxA = new JTextArea();
		JTextArea clueBoxD = new JTextArea();
		//JScrollPane scrollPane = new JScrollPane(clueBox);
		JPanel panel = new JPanel(new GridLayout(2,2));
		panel.add(clueBoxA);
		panel.add(clueBoxD);
		clueBoxA.setEditable(false);
		clueBoxD.setEditable(false);
		clueBoxA.append("ACROSS" + newline);
	   clueBoxD.append("DOWN" + newline);
		displayClue(ten1b, clueBoxA, clueBoxD);
		panel.setVisible(true);
		frame.add(panel, "East");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);
	}
	
	public String getAcross(int[][] answer, int row)
	{
		for (int j = 0; j < answer.length; j++)
			while (answer[row][j] > 0)
				text += (char)(answer[row][j] + 64);
		return text;
	}
					
	public String getDown(int[][] answer, int col)
	{
		for (int i = 0; i < answer.length; i++)
			while (answer[i][col] > 0)
				text += (char)(answer[i][col] + 64);
		return text;		
	}

	public void displayClue(int[][] layout, JTextArea cbA, JTextArea cbD)
	{
		for (int i = 0; i < layout.length; i++)
		{
			for (int j = 0; j < layout.length; j++)
			{
				if (layout[i][j] > 0 && ((i == 0 || layout[i-1][j] == -1) && (j == 0 || layout[i][j-1] == -1)))
				{
					getAcross(ten1a, i);
					cbA.append("" + layout[i][j] + ": " + text + newline);
					text = "";
					getDown(ten1a, j);
					cbD.append("" + layout[i][j] + ": " + text + newline);
					text = "";
				}
				
				else if (layout[i][j] > 0 && (i == 0 || layout[i-1][j] == -1))
				{
					getDown(ten1a, j);
					cbD.append("" + layout[i][j] + ": " + text + newline);
					text = "";
				}
				
				else if (layout[i][j] > 0 && (j == 0 || layout[i][j-1] == -1))
				{
					getAcross(ten1a, i);
					cbA.append("" + layout[i][j] + ": " + text + newline);
					text = "";
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		new aftab();
	}
}

		