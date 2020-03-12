package lab16;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class KittyRun extends JFrame implements ActionListener{

	private final int SIZE_WIDTH = 500;
	private final int SIZE_HEIGHT = 400;
	
	int row; //Kitty's current position on the board- row
	int col; //Kitty's current position on the board- column
	
	private JPanel[][] panel = new JPanel[8][8]; //JPanel 
	private JLabel[][] label = new JLabel[8][8]; //JLabel that will be added in the JPanel <panel>
	private JPanel game_board = new JPanel(new GridLayout(8, 8, 2, 2));
	
	private JButton up = new JButton("UP");
	private JButton down = new JButton("DOWN");
	private JButton left = new JButton("LEFT");
	private JButton right = new JButton("RIGHT");
	
	private Color color1 = Color.BLUE;
	private Color color2 = Color.WHITE;
		
	public KittyRun()
	{
		super("Run Kitty Run");
		setSize(SIZE_WIDTH, SIZE_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout()); //set ContentPane layout
		
		int x = 0;
		int y = 0;

		for(x = 0; x<8; ++x)
		{
			for(y = 0; y<8; ++y)
			{
				panel[x][y] = new JPanel();
				label[x][y] = new JLabel();
				//initiate JPanel <panel> and JLabel <label>
				
				panel[x][y].add(label[x][y]);
				//add JLabel <label> in JPanel <panel>
				
				game_board.add(panel[x][y]);
				//add JPanel <panel> in JPanel <game_board> which has GridLayout
				
				if(x%2==0)
				{
					if(y%2==0)
					{
						panel[x][y].setBackground(color1);
					}else
					{
						panel[x][y].setBackground(color2);
					}
				}else
				{
					if(y%2==1)
					{
						panel[x][y].setBackground(color1);
					}else
					{
						panel[x][y].setBackground(color2);
					}
				} //set background color
			}
		}

		add(up, BorderLayout.NORTH);
		add(down, BorderLayout.SOUTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(game_board, BorderLayout.CENTER);
		//add buttons and JPanel <game_board> in contentPane
		
		row = 5;
		col = 4;		
		label[row][col].setText("=^.^=");
		//set first position of Kitty
		
		up.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(source == up)
		{
			if(row!=0)
			{
				label[row][col].setText(""); //erase Kitty from the previous position
				label[--row][col].setText("=^.^="); //set text to new position
			}else
			{
				label[row][col].setText("=^.^="); //leave Kitty on current position 
			}
		}else if(source == down)
		{
			if(row!=7)
			{
				label[row][col].setText(""); //erase Kitty from the previous position
				label[++row][col].setText("=^.^="); //set text to new position
			}else
			{
				label[row][col].setText("=^.^="); //leave Kitty on current position
			}
		}else if(source == right)
		{
			if(col!=7)
			{
				label[row][col].setText(""); //erase Kitty from the previous position
				label[row][++col].setText("=^.^="); //set text to new position
			}else
			{
				label[row][col].setText("=^.^="); //leave Kitty on current position
			}
		}else if(source == left)
		{
			if(col!=0)
			{
				label[row][col].setText(""); //erase Kitty from the previous position
				label[row][--col].setText("=^.^="); //set text to new position
			}else
			{
				label[row][col].setText("=^.^="); //leave Kitty on current position
			}
		}
	}
}
