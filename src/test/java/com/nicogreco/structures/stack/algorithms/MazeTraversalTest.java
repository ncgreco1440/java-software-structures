package com.nicogreco.structures.stack.algorithms;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Scanner;

import com.nicogreco.structures.stack.LinkedStack;

public class MazeTraversalTest {
  public static final int TRIED = 2;
  public static final int PATH = 3;
  public static final String FILEPATH = "src/test/resources/";
 
  public class Maze {
    int[][] grid;
    int rows, cols;

    public Maze(String file) throws FileNotFoundException {
      Scanner scan;
      scan = new Scanner(new File(FILEPATH + file));

      this.rows = scan.nextInt();
      this.cols = scan.nextInt();

      this.grid = new int[rows][cols];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          this.grid[i][j] = scan.nextInt();
        }
      }
    }

    public int columns() {
      return this.cols;
    }

    public int rows() {
      return this.rows;
    }

    public void tryPosition(int row, int col) {
      this.grid[row][col] = TRIED;
    }

    public void markPath(int row, int col) {
      this.grid[row][col] = PATH;
    }

    public boolean validatePosition(int row, int col) {
      if (row >= 0 &&  row < this.grid.length && 
        col >= 0 && col < this.grid[row].length) {
        if (this.grid[row][col] == 1) {
          return true;
        }
      }

      return false;
    }
  }

  public class MazePosition {
    private int x;
    private int y;

    public MazePosition(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int x() {
      return this.x;
    }

    public int y() {
      return this.y;
    }
  }

  public class MazeSolver {
    private Maze maze;
    private LinkedStack<MazePosition> stack;

    public MazeSolver(Maze m) {
      this.maze = m;
    }

    /**
     * Attempts to solve the given Maze object. Returns true if a solution
     * is found, false otherwise.
     * @return boolean
     */
    public boolean solve() {
      this.stack = new LinkedStack<>();
      boolean done = false;
      MazePosition pos = new MazePosition(0, 0); // start at 0, 0
      stack.push(pos); // push the first position onto the stack

      while(!(done) && !stack.isEmpty()) {
        pos = stack.pop();
        this.maze.tryPosition(pos.x(), pos.y());
        if (pos.x() == this.maze.rows() - 1 && pos.y() == this.maze.columns() - 1) {
          // We are located at the bottom right corner of the maze
          done = true;
        } else {
          // try top - right - bottom - left cells and push 
          // all possible paths onto the stack if they are not already on.
          this.pushNewPosition(pos.x(), pos.y() + 1, stack); // top
          this.pushNewPosition(pos.x() + 1, pos.y(), stack); // right
          this.pushNewPosition(pos.x(), pos.y() - 1, stack); // bottom
          this.pushNewPosition(pos.x() - 1, pos.y(), stack); // left
        }
      }

      return done;
    }

    public void pushNewPosition(int x, int y, LinkedStack<MazePosition> stack) {
      MazePosition pos = new MazePosition(x, y);
      if (this.maze.validatePosition(pos.x(), pos.y())) {
        stack.push(pos);
      }
    }
  }

  @Test
  public void testMazeShouldCreateAMazeWithRightDimensions() {
    try {
      Maze maze = new Maze("maze.txt");

      assertEquals(maze.columns(), 13);
      assertEquals(maze.rows(), 9);
    } catch (FileNotFoundException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testMazeTraversalShouldSolveAMaze() {
    try {
      MazeSolver mazeSolver = new MazeSolver(new Maze("maze.txt"));

      assertEquals(mazeSolver.solve(), true);
    } catch (FileNotFoundException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testMazeTraversalShouldNotSolveAnUnsolveableMaze() {
    try {
      MazeSolver mazeSolver = new MazeSolver(new Maze("maze2.txt"));

      assertEquals(mazeSolver.solve(), false);
    } catch (FileNotFoundException e) {
      fail(e.getMessage());
    }
  }
}