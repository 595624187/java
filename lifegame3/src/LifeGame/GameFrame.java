package LifeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener, GameFun {
	static GameFrame frame;
	JPanel backPanel, centerPanel, bottomPanel;
	JButton OK, Start, Stop, Exit;
	JButton[][] lock;
	JLabel lRow, lCol;
	JComboBox<String> rowList, colList;
	boolean[][] isSelected;
	int Row, Col;
	Life life;
	boolean isRunning;
	Thread thread;
	boolean isDead;

	public static void main(String arg[]) {
		frame = new GameFrame("生命游戏之适者生存");
	}

	public int getRow() {
		return Row;
	}

	public void setRow(int maxRow) {
		this.Row = maxRow;
	}

	public int getCol() {
		return Col;
	}

	public void setCol(int maxCol) {
		this.Col = maxCol;
	}

	public void initGUI() {
		if (Row == 0 || Col == 0) {
			Row = 16;
			Col = 24;
		}
		life = new Life(Row, Col);
		backPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new GridLayout(Row, Col));
		bottomPanel = new JPanel();
		rowList = new JComboBox<String>();
		for (int i = 3; i <= 20; i++)
			rowList.addItem(String.valueOf(i));
		colList = new JComboBox<String>();
		for (int i = 3; i <= 60; i++)
			colList.addItem(String.valueOf(i));
		rowList.setSelectedIndex(Row - 3);
		colList.setSelectedIndex(Col - 3);
		OK = new JButton("创造世界");
		lock = new JButton[Row][Col];
		Start = new JButton("开始游戏");
		Stop = new JButton("游戏暂停");
		Exit = new JButton("退出游戏");
		isSelected = new boolean[Row][Col];
		lRow = new JLabel("设置行数");
		lCol = new JLabel("设置列数");
		this.setContentPane(backPanel);
		backPanel.add(centerPanel, "Center");
		backPanel.add(bottomPanel, "South");
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				lock[i][j] = new JButton("");
				lock[i][j].setBackground(Color.WHITE);
				centerPanel.add(lock[i][j]);
			}
		}

		bottomPanel.add(lRow);
		bottomPanel.add(rowList);
		bottomPanel.add(lCol);
		bottomPanel.add(colList);
		bottomPanel.add(OK);
		bottomPanel.add(Start);
		bottomPanel.add(Stop);
		bottomPanel.add(Exit);
		this.setSize(900, 620);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		OK.addActionListener(this);
		Start.addActionListener(this);
		Stop.addActionListener(this);
		Exit.addActionListener(this);
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				lock[i][j].addActionListener(this);
			}
		}
	}

	public GameFrame(String name) {
		super(name);
		initGUI();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == OK) {
			frame.setRow(rowList.getSelectedIndex() + 3);
			frame.setCol(colList.getSelectedIndex() + 3);
			initGUI();
			life = new Life(getRow(), getCol());
		} else if (e.getSource() == Start) {
			isRunning = true;
			thread = new Thread(new Runnable() {
				public void run() {
					while (isRunning) {
						makeNextGeneration();
						@SuppressWarnings("unused")
						boolean isSame = true;
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						isDead = true;
						for (int row = 1; row <= Row; row++) {
							for (int col = 1; col <= Col; col++) {
								if (life.getGrid()[row][col] != 0) {
									isDead = false;
									break;
								}
							}
							if (!isDead) {
								break;
							}
						}
						if (isDead) {
							JOptionPane.showMessageDialog(null, "Game Over!");
							isRunning = false;
							thread = null;
						}
					}
				}
			});
			thread.start();
		} else if (e.getSource() == Stop) {
			isRunning = false;
			thread = null;
		} else if (e.getSource() == Exit) {
			System.exit(0);
		} else {
			int[][] grid = life.getGrid();
			for (int i = 0; i < Row; i++) {
				for (int j = 0; j < Col; j++) {
					if (e.getSource() == lock[i][j]) {
						isSelected[i][j] = !isSelected[i][j];
						if (isSelected[i][j]) {
							lock[i][j].setBackground(Color.pink);
							grid[i + 1][j + 1] = 1;
						} else {
							lock[i][j].setBackground(Color.white);
							grid[i + 1][j + 1] = 0;
						}
						break;
					}
				}
			}
			life.setGrid(grid);
		}
	}

	public void makeNextGeneration() {
		life.changeCellstatus();
		int[][] grid = life.getGrid();
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				if (grid[i + 1][j + 1] == 1) {
					lock[i][j].setBackground(Color.pink);
				} else {
					lock[i][j].setBackground(Color.white);
				}
			}
		}
	}

}
