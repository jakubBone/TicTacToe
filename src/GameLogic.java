import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.IOException;

public class GameLogic  {
    char[][] grid = new char[3][3];
    Random random;
    boolean isGameOver = false;

    char currentPlayer = 'O';
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ///////
    String column1 = " ";
    int column = 0;
    int row = 0;




    void start() throws IOException {
        printRules();
        genererateGrid();
        playGame();

    }

    void playGame() throws IOException {
        while (!isGameOver) {
            printGrid();
            System.out.println("Please type a column: ");
            column1 = reader.readLine();
            System.out.println("Please type a row: ");
            row = Integer.parseInt(reader.readLine());
            switch (column1) {
                case ("A"):
                    column = 0;
                    break;
                case ("B"):
                    column = 1;
                    break;
                case ("C"):
                    column = 2;
            }
            assignCoordinates();
            switchPlayer();
            computerMove();
            switchPlayer();
            //isGameOver = true;
        }
    }
    void computerMove() {
        System.out.println("Ok, now my move!");
        System.out.println();
        //while (grid[row][column] == 'X'){
            column = random.nextInt(3);
            row = random.nextInt(3);
            assignCoordinates();
            printGrid();
    }
            /*void assignComputerCoordinates() {
        if (column >= 0 && column <= 2 && row >= 0 && row <= 2) {
            if(grid[column][row] == '-' && grid[column][row] != 'O')
                grid[row][column] = computerMark;
        }
        System.out.println();
    }*/




    void assignCoordinates() {
        if (column >= 0 && column <= 2 && row >= 0 && row <= 2) {
                grid[row][column] = currentPlayer;
                System.out.println();
        }

    }
    void switchPlayer(){
        currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }

    void printGrid() {                                          // drukuje aktualną tablicę
        System.out.println("  A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    void genererateGrid() {                                     // generuje tablicę
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }



    void printRules() {                                          // drukuje zasady
        System.out.print("Hello dude! Welcome in Tic-Tac-Toe game. Please type your name: ");
        //String name = scanner.nextLine();
        //System.out.println("Hello " + name + "! My name is Computer" + " Let's start the game!");
        System.out.println();
        System.out.println("Rules: In this game you need... So, let's play! ");
        System.out.println();
    }



}




