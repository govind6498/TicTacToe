package com.bridgelabz.tictactoe;
import java.util.*;
public class TicTacToe {
	static char[] board = new char[10];
	static char player,computer;
	private static int playLocation;
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
	static void showBoard() {
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
			System.out.println("Enter Location 1-9 to Make Move");
			playLocation = sc.nextInt();
			if(playLocation<10 && playLocation>0) {
				board[playLocation] = player;
			}
			else {
				System.out.println("Invalid Choice");
				System.out.println("Cell is not free.please choose a different index");
			}
			showBoard();
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
		public static boolean isEmpty() {
			if(board[playLocation]==' ') {
				return false;
			}
			else {
				return true;
			}
		}
	public static void main(String[] args) {
		System.out.println("Welocme to Tic Tac Toe Game ");
		createBoard();
		getPlayerChoice();
		showBoard();
		userMove();
		desiredMove();
	}
}
