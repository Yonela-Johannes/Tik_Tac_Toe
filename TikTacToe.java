import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.util.Random;
import java.util.Scanner;

public class TikTacToe extends JPanel {	
	public static final int WIDTH = 506;
	public static final int HEIGHT = 527;

	public boolean yourTurn = false;
	public boolean circle = true;
	public boolean accepted = false;
	public boolean won = false;
	public boolean pcWon = false;
	public boolean tie = false;
	
	public static Font font = new Font("Verdana", Font.BOLD, 30);
	public static Font smallerFont = new Font("Verdana", Font.BOLD, 20);
	public static Font largeFont = new Font("Verdana", Font.BOLD, 50);

	public static String title = "Tic-Tac-Toe";
	public String waitngForPc = "Waiting for computer";
	public String wonString = "Congratulations, you won!";
	public String pcWonString = "Sorry you lost, computer won!";
	public String tieString = "Game ended in a tie";

	TikTacToe(){	

	}
		
	public static void main(String[] args){
		JFrame frame = new JFrame(title);
		JPanel boardPanel = new JPanel();
		JLabel textLabel = new JLabel();
		JPanel textPanel = new JPanel();

		frame.setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		frame.setTitle(title);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textPanel, BorderLayout.NORTH);
		// frame.setLayout(new BorderLayout());

		textLabel.setBackground(Color.darkGray);
		textLabel.setForeground(Color.WHITE);
		textLabel.setFont(largeFont);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setText(title);
		textLabel.setOpaque(true);
		

		textPanel.add(textLabel);

		
		char[][] board = {{' ', ' ', ' '},
		{' ',' ',' '},
		{' ',' ', ' '}};
		
		Scanner scanner = new Scanner(System.in);
		printBoard(board);

		while (true) {
	
			playerMove(board, scanner);
			if(isGameFinished(board)){
				break;
			}

			printBoard(board);
			
			computerMove(board);
			if(isGameFinished(board)){
				break;
			}

			printBoard(board);
		}
		scanner.close();
	}

	private static void computerMove (char[][] board){
		Random rand = new Random();
		int playCell;

		while(true){
			playCell = rand.nextInt(9) + 1;
			if(isValidMove(board, playCell)) {
				break;
			};
		}
		System.out.println("Computer chose: " + playCell);
		placeMove(board, Integer.toString(playCell), 'O');

	}

	private static boolean isValidMove (char[][] board, int position)
	{
		switch(position){
			case 1:
				return (board[0][0] == ' ');
			case 2:
				return (board[0][1] == ' ');
			case 3:
				return (board[0][2] == ' ');
			case 4:
				return (board[1][0] == ' ');
			case 5:
				return (board[1][1] == ' ');
			case 6:
				return (board[1][2] == ' ');
			case 7:
				return (board[2][0] == ' ');
			case 8:
				return (board[2][1] == ' ');
			case 9:
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

	private static void playerMove(char[][] board, Scanner scanner){
		String userInput;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			userInput = scanner.nextLine();
			if(isValidMove(board, Integer.parseInt(userInput))){
				break;
			} else {
				System.out.println("Invalid move at: " + userInput + "!");
			}
		}
		placeMove(board, userInput, 'X');
		System.out.println("You chose: " + userInput);
	}
	private static void placeMove (char[][] board, String position, char symbol){
		switch(position){
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println(":(");
		}
	}
	private static boolean isGameFinished(char[][] board){

		if(playerWon(board, 'X')){
			return true;
		}
		
		if(playerWon(board, 'O')){
			return true;
		}

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == ' '){
					return false;
				}
			}
		}

		printBoard(board);
		System.err.println("The game ended in a tie");
		return true;
	}

	private static boolean playerWon(char[][] board, char symbol){
		if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) || 
			(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
			(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
			(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
			(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
			(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
			(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
			(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) ){
			message(board, symbol);
			return true;
		}
		return false;		
	}

	private static void message(char[][] board, char symbol){
		printBoard(board);
		if(symbol == 'X'){
			System.out.println("Contratulations, you won!");
		}else if(symbol == 'O'){
			System.out.println("Sorry, you lost,the computer won! \nPlay again.");
		}
	}
	private static void printBoard(char[][] board)
	{
		System.out.println("|" + board[0][0] + "|" + board[0][1]+ "|" + board[0][2] + "|");
		System.out.println("--+-+--");
		System.out.println("|" + board[1][0] + "|" + board[1][1]+ "|" + board[1][2] + "|");
		System.out.println("--+-+--");
		System.out.println("|" + board[2][0] + "|" + board[2][1]+ "|" + board[2][2] + "|");	
	}

}
