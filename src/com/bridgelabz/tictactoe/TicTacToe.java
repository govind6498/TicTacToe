package com.bridgelabz.tictactoe;
import java.util.*;
public class TicTacToe {
	static char[] board = new char[10];
	static char player,computer;
	private static int playLocation;
	private static int tossResult;
	public static boolean playerStarts;
	private static boolean playerWinToss;
	private static boolean isWinner = false;
	public static final Random randomGenerator = new Random();
	public static Scanner sc = new Scanner(System.in);

	static void createBoard() {
		for(int index=1;index<10;index++) {
			board[index]=' ';
		}
	}
	static void getPlayerChoice() {
		System.out.println("Select x or o:");
		player = sc.next().charAt(0);
		char Player = Character.toUpperCase(player);
		if(Player == 'X') {
			computer='o';
		}
		else if(Player == 'O') {
			computer='x';
		}
		System.out.println("You have selected: "+player);
		System.out.println("Computer's choice is: "+computer);
	}
	public static void showBoard() {
		System.out.println();
		System.out.println(" "+board[1]+" | "+board[2]+" | "+board[3]+" | ");
		System.out.println("-----------------");
		System.out.println(" "+board[4]+" | "+board[5]+" | "+board[6]+" | ");
		System.out.println("-----------------");
		System.out.println(" "+board[7]+" | "+board[8]+" | "+board[9]+" | ");
	}
	public static boolean userMove(int userInput) {
		if(board[userInput]!= 'X' && board[userInput]!='O') {
			System.out.println("Cell is free");
			return true;
		}
		else {
			return false;
		}
	}
	public static void userMove() {
		System.out.println("Enter the index where you want to make your move:(1-9 ");
		int userInput = sc.nextInt();
		if(board[userInput]!='X' && board[userInput]!='O'){
			System.out.println("Cell is free");
		}
		if(playLocation<10 && playLocation>0) {
			board[playLocation] = player;
		}
		else {
			System.out.println("Invalid Choice");
			System.out.println("Cell is not free.please choose a different index");
		}
		System.out.println("Player is Playing");
		System.out.println("Enter Location 1-9 to Make Move");
		while(true) {
			playLocation = sc.nextInt();
			sc.nextLine();
			if(isEmpty(playLocation) && playLocation <10 && playLocation>=0) {
				board[playLocation] = player;
				showBoard();
				break;
			}
			else {
				System.out.println("Invalid Choice");
			}
		}
	}
	public static void desiredMove() {
		System.out.println("Enter the index where you want to make your move ");
		int userInput = sc.nextInt();
		if(userMove(userInput)) {
			board[userInput] =player;
		}
		else {
			System.out.println("Cell already occupied!. Choose a different cell");
		}
	}
	public static void computerMove() {
		System.out.println("Computer is Playing");
		do {
			playLocation = randomGenerator.nextInt(9) + 1;
		}
		while(!isEmpty(playLocation));
		board[playLocation] = computer;
		showBoard();
		String winnerResult = checkForWinner();
		if(winnerResult=="") {
			System.out.println("Computer's Turn");
		}
		else {
			System.out.println(winnerResult);
		}
	}
	public static boolean isEmpty(int location) {
		return board[location] ==' ';
	}
	public static void checkToss() {
		int playerFirst = 1;
		double tossResult = Math.floor(Math.random()*10)%2;
		if(tossResult == playerFirst) {
			playerStarts = true;
		}
		System.out.println("Choose 1 for Heads or 2 for Tails");
		int coinSelect = sc.nextInt();
		if(coinSelect == tossResult) {
			System.out.println("Player Won the Toss! Player Starts");
			playerWinToss = true;
		}
		else {
			playerStarts = false;
			playerWinToss = false;
			System.out.println("\nComputer Won The Toss! Computer Starts");
		}
	}
	public static String checkForWinner() {
		System.out.println();
		if ((board[1] == board[2]) && (board[2] == board[3])) {
			if (player == board[1]) {
				return "Player Wins";
			} else if (computer == board[1]) {
				return "Computer Wins";
			}
		} else if ((board[4] == board[5]) && (board[5] == board[6])) {
			if (player == board[4]) {
				return "Player Wins";
			} else if (computer == board[4]) {
				return "Computer Wins";
			}
		} else if ((board[7] == board[8]) && (board[8] == board[9])) {
			if (player == board[7]) {
				return "Player Wins";
			} else if (computer == board[7]) {
				return "Computer Wins";
			}
		} else if ((board[1] == board[4]) && (board[4] == board[7])) {
			if (player == board[4]) {
				return "Player Wins";
			} else if (computer == board[4]) {
				return "Computer Wins";
			}
		} else if ((board[2] == board[5]) && (board[5] == board[8])) {
			if (player == board[2]) {
				return "Player Wins";
			} else if (computer == board[2]) {
				return "Computer Wins";
			}
		} else if ((board[3] == board[6]) && (board[6] == board[9])) {
			if (player == board[3]) {
				return "Player Wins";
			} else if (computer == board[3]) {
				return "Computer Wins";
			}
		} else if ((board[1] == board[5]) && (board[5] == board[9])) {
			if (player == board[1]) {
				return "Player Wins";
			} else if (computer == board[1]) {
				return "Computer Wins";
			}
		} else if ((board[3] == board[5]) && (board[5] == board[7])) {
			if (player == board[3]) {
				return "Player Wins";
			} else if (computer == board[3]) {
				return "Computer Wins";
			}
		} else {
			return "Draw";
		}
		return "Win";
	}
	public static boolean checkBoardFull() {
		if((board[1]!= ' ') && (board[2]!=' ') && (board[3]!=' ') && (board[4]!= ' ') && (board[5]!=' ') && (board[6]!=' ') && (board[7]!= ' ') && (board[8]!=' ') && (board[9]!=' ')) {
			return true;	
		}
		return false;
	}
	public static boolean checkWinner() {
		if (isWinner)
			return true;
		if ((board[1] == player && board[2] == player && board[3] == player)
				|| (board[4] == player && board[5] == player && board[6] == player)
				|| (board[7] == player && board[8] == player && board[9] == player)
				|| (board[1] == player && board[4] == player && board[7] == player)
				|| (board[2] == player && board[5] == player && board[8] == player)
				|| (board[3] == player && board[6] == player && board[9] == player)
				|| (board[1] == player && board[5] == player && board[9] == player)
				|| (board[3] == player && board[5] == player && board[7] == player)) {
			System.out.println("Player is the WINNER!!");
			isWinner = true;
			return true;
		}

		if ((board[1] == computer && board[2] == computer && board[3] == computer)
				|| (board[4] == computer && board[5] == computer && board[6] == computer)
				|| (board[7] == computer && board[8] == computer && board[9] == computer)
				|| (board[1] == computer && board[4] == computer && board[7] == computer)
				|| (board[2] == computer && board[5] == computer && board[8] == computer)
				|| (board[3] == computer && board[6] == computer && board[9] == computer)
				|| (board[1] == computer && board[5] == computer && board[9] == computer)
				|| (board[3] == computer && board[5] == computer && board[7] == computer)) {
			System.out.println("Computer is the WINNER");
			isWinner = true;
			return true;
		}

		return false;
	}
	public static void startGame() {
		do {
			if (playerWinToss) {
				userMove();
				if (!checkBoardFull())
					computerMove();
			} else {
				computerMove();
				if (!checkBoardFull())
					userMove();
			}
		} while (!checkWinner() && !checkBoardFull());
		if (checkBoardFull() && !checkWinner())
			System.out.println("Game TIED.");

	}

	public static void main(String[] args) {
		System.out.println("Welocme to Tic Tac Toe Game ");
		createBoard();
		getPlayerChoice();
		checkToss();
		showBoard();
		desiredMove();

		startGame();


	}
}
