import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Player {
    GameLogic gameLogic;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void userMove() throws IOException {           // the user move
        System.out.print("Please type a column (A, B, or C): ");
        String columnIndex = reader.readLine();
        System.out.print("Please type a row (0, 1, or 2): ");
        int row = Integer.parseInt(reader.readLine());
        int column = getColumnNumber(columnIndex);
        if (gameLogic.isValidMove(row, column) && gameLogic.grid[row][column] == '-')
            gameLogic.grid[row][column] = gameLogic.currentPlayer;
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
            if (gameLogic.isValidMove(row,column) && gameLogic.grid[row][column] == '-') {
                gameLogic.grid[row][column] = gameLogic.currentPlayer;
                System.out.println("My choise is: " +getColumnLetter(column) + row);
                System.out.println();
                validMove = true;
            }
        }
    }

    public char getColumnLetter(int column){        // refectoring random computer int to String
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
    public int getColumnNumber(String column) {     // refactoring user input String to int
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
}
