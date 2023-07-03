import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GameLogic {
    char[][] grid = new char[3][3];
    boolean isGameOver = false;
    char currentPlayer = 'O';
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Board board = new Board();


    void playGame() throws IOException {        // the game method
        board.genererateGrid(grid);

        while (!isGameOver) {
            board.printGrid(grid);
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

    void userMove() throws IOException {           // the user move
        System.out.print("Please type a column (A, B, or C): ");
        String columnIndex = reader.readLine();
        System.out.print("Please type a row (0, 1, or 2): ");
        int row = Integer.parseInt(reader.readLine());
        int column = getColumnNumber(columnIndex);
            if (isValidMove(row, column) && grid[row][column] == '-')
                grid[row][column] = currentPlayer;
            else {
                System.out.println("Incorrect move dude... Please, try again");
                userMove();
            }
        }

    void computerMove() {                           // the computer move
        boolean validMove = false;
        System.out.println();
        System.out.println("Ok, now my move!");
        while (!validMove) {
            int row = (int) (Math.random() * 3);
            int column = (int) (Math.random() * 3);
                if (isValidMove(row,column) && grid[row][column] == '-') {
                    grid[row][column] = currentPlayer;
                    System.out.println("My choise is: " +getColumnLetter(column) + row);
                    System.out.println();
                    validMove = true;
                }
            }
        }
    public char getColumnLetter(int column){
        switch (column) {
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
        board.printGrid(grid);
        if(checkResult('O'))
            System.out.println("Congratulations! You Won :)");
        else if(checkResult('X'))
            System.out.println("Oh no... You lost :(");
        else {
            board.printGrid(grid);
            System.out.println("Nobody won. Would you like to play again? ;) :(");
        }
    }

    public void gameStatus(char player) {           // check if the game is over
        if (isGridFull() || checkResult('O') || checkResult('X')) {
            isGameOver = true;
        }
    }

    boolean checkResult(char player) {  // check the result of game
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

    void switchPlayer(){                                    // switch the player after move
        currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }  // switch user to computer



}




