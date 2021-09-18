package com.bridgelabz.tictactoe;
import java.util.*;
public class TicTacToe {
	static char[] board = new char[10];
	static char player,computer;
	public static Scanner sc = new Scanner(System.in);

	static void createBoard() {
		for(int index=0;index<10;index++) {
			board[index]=' ';
		}
	}
	static void getPlayerChoice() {
		System.out.println("Select x or o:");
		player = sc.next().charAt(0);
		char Player = Character.toUpperCase(player);
		if(Player == 'X') {
			computer='o';
			
			System.out.println("You have selected: "+player);
			System.out.println("Computer's choice is: "+computer);
			
		}
		else if(Player == 'O') {
			computer='x';
			System.out.println("You have selected: "+player);
			System.out.println("Computer's choice is: "+computer);
		}
	}
	public static void main(String[] args) {
		System.out.println("Welocme to Tic Tac Toe Game ");
		createBoard();
		getPlayerChoice();
	}
}
