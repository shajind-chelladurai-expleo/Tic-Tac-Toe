package app;

public class Cell {
	private int row;
	private int col;
	private String val;

	public Cell() {
		super();
	}
	
	public Cell(int row, int col, String val) {
		super();
		this.row = row;
		this.col = col;
		this.val = val;
	}

	

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
	
	

}
