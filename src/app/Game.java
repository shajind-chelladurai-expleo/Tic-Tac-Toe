package app;

public class Game {
	//Get n*n size for tic-tac-toe board size
	private int boardRow;
	private int boardCol;
	private Cell[][] gameBoard;
	
	public Game() {
	super();
	}
	
	Game(int row,int col){
		this.boardCol=col;
		this.boardRow= row;
		this.gameBoard = new Cell[row][col];
		for (int i=0;i<row;i++) {
			for (int j=0;j<col;j++) {
				gameBoard[i][j] = new Cell(row,col,"-") ;
			}
		}
	}

	public int getBoardRow() {
		return boardRow;
	}

	public void setBoardRow(int boardRow) {
		this.boardRow = boardRow;
	}

	public int getBoardCol() {
		return boardCol;
	}

	public void setBoardCol(int boardCol) {
		this.boardCol = boardCol;
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Cell[][] gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	

}
