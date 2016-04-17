package org.tao.leetcode;

import java.awt.Point;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int numberOfIslands = 0;
		for (int i=0; i<grid.length; ++i)
			for (int j=0; j<grid[0].length; ++j) {
				if ('1'==grid[i][j]) {
					markAllMyNeighbers(grid, i,j);
					++numberOfIslands;
				}
			}
		return numberOfIslands;
    }
	
	private void markAllMyNeighbers(char[][] grid, int i, int j) {
		grid[i][j]='X';
		Point[] neighbers = new Point[] {
				new Point(i,j-1), new Point(i,j+1),
				new Point(i-1,j),new Point(i+1,j)};
		for (Point pt : neighbers) {
			if (pt.x<0 || pt.y<0 || pt.x >= grid.length || pt.y >= grid[0].length)
				continue;
			
			if (grid[pt.x][pt.y]=='1')
				markAllMyNeighbers(grid, pt.x, pt.y);
		}
	}
}
