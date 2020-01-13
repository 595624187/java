package LifeGame;
 
public class Life implements LifeFun {
     int Row;
     int Col;
     int[][] grid;
    public Life(int maxRow, int maxCol) {
        this.Row = maxRow;
        this.Col = maxCol;
        grid = new int[maxRow + 2][maxCol + 2];
        for (int row = 0; row <= maxRow + 1; row++)
            for (int col = 0; col <= maxCol + 1; col++)
                grid[row][col] = 0;
    }
    
    public int[][] getGrid() { return grid;}
    
    public void setGrid(int[][] grid) {this.grid = grid;}
    

    
    public void changeCellstatus() { //根据细胞周边数目，改变细胞的状态
        int[][] newGrid = new int[Row + 2][Col + 2];
        for (int row = 1; row <= Row; row++)
            for (int col = 1; col <= Col; col++)
                switch (getNeighbor(row, col)) {
                    case 2:
                        newGrid[row][col] = grid[row][col]; 
                        break;
                    case 3:
                        newGrid[row][col] = 1; 
                        break;
                    default:
                        newGrid[row][col] = 0; 
                }
 
        for (int row = 1; row <= Row; row++)
            for (int col = 1; col <= Col; col++)
                grid[row][col] = newGrid[row][col];
    }
 
     public int getNeighbor(int row, int col) {//得到该位置细胞周边细胞数目
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++)
            for (int j = col - 1; j <= col + 1; j++) {
                count += grid[i][j]; 
            }
        		count -= grid[row][col]; 
        return count;
    }
}
