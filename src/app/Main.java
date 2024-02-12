package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome to TIC - TAC  -  TOE Game !! ");
			
			int boardSize = 0;
			
			while(boardSize%2==0 || boardSize!=1) {
			
			System.out.println("Enter the odd board size for the game:");
			
			 boardSize = sc.nextInt();
			 if(boardSize==1) continue;
			 if (boardSize%2==1)break;
			}
			
			Game game = new Game(boardSize,boardSize);
			
			System.out.println("Initial board view");
			
			for (int i=0;i<boardSize;i++) {
				for (int j=0;j<boardSize;j++) {
					
					System.out.print(game.getGameBoard()[i][j].getVal() + "   |   ");
				}
				System.out.println();
				System.out.println("-----------------------------");
			}
			
			int toggleInput = 0;
		while(true) {	
			switch (toggleInput) {
			case 0: {
				System.out.println("Player 1's turn");
				System.out.println("Board View:");
				for (int i=0;i<boardSize;i++) {
					for (int j=0;j<boardSize;j++) {
						
						System.out.print(game.getGameBoard()[i][j].getVal() + "   |   ");
					}
					System.out.println();
					System.out.println("-----------------------------");
				}
				while (true) {
				System.out.println("Enter row:");
				int row = sc.nextInt();
				System.out.println("Enter col:");
				int col = sc.nextInt();
				
				if(game.getGameBoard()[row][col].getVal().equals("-")) {
					game.getGameBoard()[row][col].setVal("X");
					break;
				}
				else {
					System.out.println("The Row and Column already has filled played out ! Check for other possibilities !");
				}
				}
				if(checkWinner(game,boardSize,"X")) {
					System.out.println("Congrats, Player 1 Wins!!");
					System.exit(0);
				}
				toggleInput=1;
				break;
			}
			case 1: {
				System.out.println("Player 2's turn");
				System.out.println("Board View:");
				for (int i=0;i<boardSize;i++) {
					for (int j=0;j<boardSize;j++) {
						
						System.out.print(game.getGameBoard()[i][j].getVal() + "   |   ");
					}
					System.out.println();
					System.out.println("-----------------------------");
				}
				
				while (true) {
					System.out.println("Enter row:");
					int row = sc.nextInt();
					System.out.println("Enter col:");
					int col = sc.nextInt();
					
					if(game.getGameBoard()[row][col].getVal().equals("-")) {
						game.getGameBoard()[row][col].setVal("O");
						break;
					}
					else {
						System.out.println("The Row and Column already has filled played out ! Check for other possibilities !");
					}
					}
				
				if(checkWinner(game,boardSize,"O")) {
					System.out.println("Congrats, Player 2 Wins!!");
					System.exit(0);
				}
				toggleInput=0;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + toggleInput);
			}
		}
		}
		
}

	private static boolean checkWinner(Game game,int boardSize,String check) {
		// TODO Auto-generated method stub
	
		Set<String> set1 = new HashSet<>();
		for (int i=0;i<boardSize;i++) {
			for (int j=0;j<boardSize;j++) {
				set1.add(game.getGameBoard()[i][j].getVal());
			}
			if(set1.size()==1 && set1.contains(check)) {
			 return true;
			}
			else {
				set1.clear();
			}
		}
		
		for (int i=0;i<boardSize;i++) {
			for (int j=0;j<boardSize;j++) {
				set1.add(game.getGameBoard()[j][i].getVal());
			}
			if(set1.size()==1 && set1.contains(check)) {
			 return true;
			}
			else {
				set1.clear();
			}
		}
		
		int start = 0;
		int end = boardSize-1;
		
		while (start<=end) {
			set1.add(game.getGameBoard()[start][start].getVal());
			start++;
		}
		if(set1.size()==1 && set1.contains(check)) {
			return true;
		}
		else {
			set1.clear();
		}
		while (end>=start) {
			set1.add(game.getGameBoard()[end][end].getVal());
			end--;
		}
		if(set1.size()==1 && set1.contains(check)) {
			return true;
		}
		else {
			set1.clear();
		}
		
		return false;
	}

}
