package LifeGame;

public interface GameFun {
	int getRow();
	void setRow(int maxRow);
	int getCol();
	void setCol(int maxCol);
	void initGUI();
	void makeNextGeneration();
}
