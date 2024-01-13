import java.util.Scanner;


public class Game {
    public static void main(String[] args) {
        char playerSymbol;
        char[][] board = createGrid();
        turns = 0;
        maxTurns = 9;
        playerSymbol = 'X';
    
        while (turns < maxTurns) {
            ticTacToeGame(board);
        }
    }
    static char[][] grid;
    static int turns;
    static int maxTurns;
    static int newRow;
    static int newColumn;
    static char playerSymbol; // Added playerSymbol variable
    static Scanner inputRow;
    static Scanner inputColumn;
    static int turnRow;
    static int turnColumn;
    static int[] coordinates;

    public static char[][] createGrid() {
        grid = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        return grid;
    }

    public static void updateGrid() {
        newRow = coordinates[0] - 1;
        newColumn = coordinates[1] - 1;

        if (newRow >= 0 && newRow < 3 && newColumn >= 0 && newColumn < 3) {
            if (grid[newRow][newColumn] == ' ') {
                grid[newRow][newColumn] = playerSymbol;
            } else {
                System.out.println("Invalid coordinates, space already filled, reenter a coordinate");
            }
        } else {
            System.out.println("Invalid coordinates, please reenter a valid coordinate");
        }
    }

    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                return true;
            }
        }

        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][  2]) {
            return true;
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            return true;
        }

        return false;
    }


    public static boolean checkExceptions(char[][] board) {
        turns = 0;
        maxTurns = 9;

        if (grid[newRow][newColumn] != ' ') {
            System.out.println("Invalid coordinates, space already filled, reenter a coordinate");
            ticTacToeGame(board);
            return true;
        } else if (turns == 9 && !checkWin()) {
            System.out.println("Tie!");
            return false;
        } else {
            return true;
        }
    }

    public static void switchPlayer() {
        if (playerSymbol == 'X') {
            playerSymbol = 'O';
        } else {
            playerSymbol = 'X';
        }
    }

    public static void endGame(char[][] board) {
        if (checkWin() || !checkExceptions(board)) {
            System.out.println("Exit the game");
            System.exit(0);
        }
    }

    public static void displayBoard() {
            for (int i = 0; i <3; i++) {
                for (int j=0; j<3; j++) {
                    System.out.print(grid[i][j]);
                    if (j < 2) {
                        System.out.print("|");
                    }
    
                }
                System.out.println("\n-----");
            }
    }

    public static int[] turn() {
        inputRow = new Scanner(System.in);
        System.out.println("Enter the row that you want to move in: ");
        turnRow = inputRow.nextInt();

        inputColumn = new Scanner(System.in);
        System.out.println("Enter the column that you want to move in: ");
        turnColumn = inputColumn.nextInt();

        coordinates = new int[]{turnRow, turnColumn};
        return coordinates;
    }

    public static void ticTacToeGame(char[][] board) {
        displayBoard();
        turn();
        switchPlayer();
        updateGrid();
        // Board.checkExceptions(board);
        checkWin();
        System.out.println();
        displayBoard();
    }

}

