package LifeGame;

public interface LifeFun {
	int[][] getGrid();
	void setGrid(int[][] grid);
	 void changeCellstatus();
	 int getNeighbor(int row, int col);
}
                                  