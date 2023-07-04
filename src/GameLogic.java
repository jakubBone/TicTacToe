import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GameLogic {
    char[][] grid = new char[3][3];
    boolean isGameOver = false;
    char currentPlayer = 'O';
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void playGame() throws IOException {        // the game method
        printRules();
        genererateGrid();
        while (!isGameOver) {
            printGrid();
            userMove();
            switchPlayer();
            gameStatus(currentPlayer);
            if (isGameOver)
                break;
            computerMove();
            switchPlayer();
            gameStatus(currentPlayer);
        }
            whoIsWinner();
    }

    void userMove() throws IOException {           // the user movement
        System.out.print("Please type a column (A, B, or C): ");
        String columnIndex = reader.readLine();
        System.out.print("Please type a row (0, 1, or 2): ");
        int row = Integer.parseInt(reader.readLine());
        int column = getColumnNumber(columnIndex);
            if (isValidMove(row, column) && grid[row][column] == '-')
                grid[row][column] = currentPlayer;
            else {
                System.out.println("Incorrect move buddy... Please, try again");
                userMove();
            }
        }

    void computerMove() {                           // the computer movement
        boolean correctMove = false;
        System.out.println();
        System.out.println("Ok, now my move!");
        while (!correctMove) {
            int row = (int) (Math.random() * 3);
            int column = (int) (Math.random() * 3);
                if (isValidMove(row,column) && grid[row][column] == '-') {
                    grid[row][column] = currentPlayer;
                    System.out.println("My choise is: " +getColumnLetter(column) + row);
                    System.out.println();
                    correctMove = true;
                }
            }
        }
    public char getColumnLetter(int column){        // refactoring computer column
        switch (column) {                           // from number to letter
            case 0:
                return 'A';
            case 1:
                return 'B';
            case 2:
                return 'C';
            default:
                return ' ';
        }
    }
    public int getColumnNumber(String column) {     // refactoring input letters to numbers
        column = column.toUpperCase();
        switch (column) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            default:
                return -1;
        }
    }

    public void whoIsWinner(){                  // check who is the winner
        printGrid();
        if(checkResult('O'))
            System.out.println("Congratulations! You Won :)");
        else if(checkResult('X'))
            System.out.println("Oh no... You lost :(");
        else {
            printGrid();
            System.out.println("Nobody won. Would you like to play again? ;)");
        }
    }



    public void gameStatus(char player) {           // check if the game is over
        if (isGridFull() || checkResult('O') || checkResult('X')) {
            isGameOver = true;
        }
    }

    boolean checkResult(char player) {  //
        for (int i = 0; i < 3; i++) {                   // check the rows
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
        }                                               // check the columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] == player && grid[1][j] == player && grid[2][j] == player) {
                return true;
            }
        }
        //                                              // check the diagonal 1
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
                                                        // check the diagonal 2
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }
        return  false;
    }




    public boolean isGridFull(){                            // check if the grid is full of signs
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int column){               // check if the movement is correct
        if(row >=0 && row <3 && column >= 0 && column <3)
            return true;
        return false;
    }

    void switchPlayer(){                                    // switch the player after movement
        currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }

    void printGrid() {                                      // the current grid printing
        System.out.println("  A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    void genererateGrid() {                                 // the grid initial method
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }

    void printRules() throws IOException{                                     // printing the game rules
        System.out.print("Hi buddy! Welcome in Tic-Tac-Toe game. Please type your name: ");
        String name = reader.readLine();
        System.out.println("Hello " + name + "! My name is Computer. " + "Let's start the game!");
        System.out.println();
        System.out.println("The rules: \nIn this game we will try to place three of our symbols in the line a row on" +
                " a 3x3 board. The row can be horizontal, vertical,\nor diagonal. The first one to do it wins the " +
                "game. You as a master will get the O, while I, as the humble computer, will take the X sign. \n" +
                "If the entire board gets filled up without a winning line, it's a tie. Alright, let's dive into " +
                "this strategic battle of X and O! \n\nLet's the best win!");
        System.out.println();
    }
}




