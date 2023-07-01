import java.util.Random;

public class GameLogic {
    char[][] grid = new char[3][3];
    char userMark = 'O';
    char computerMark = 'X';
    Random random = new Random();

    void computerMove(int column, int row) {
        System.out.println("Ok, now my move!");
        System.out.println();
        while (grid[row][column] == computerMark){
            if(grid[column][row] == '-') {
                column = random.nextInt(3);
                row = random.nextInt(3);
                grid[row][column] = computerMark;
            }
        }
    }

    void assignCoordinates(int column, int row) {
        if (column >= 0 && column <= 2 && row >= 0 && row <= 2) {
            grid[row][column] = userMark;
            System.out.println();
        }
    }


/*
            if(userType.equals("A0"))
                grid[0][0] = 'O';
            else if (userType.equals("B0"))
                grid[0][1] = 'O';
            else if (userType.equals("C0"))
            grid[0][2] = 'O';
            else if(userType.equals("A1"))
            grid[1][0] = 'O';
            else if (userType.equals("B1"))
            grid[1][1] = 'O';
            else if (userType.equals("C1"))
            grid[1][2] = 'O';
            else if (userType.equals("A2"))
            grid[2][0] = 'O';
            else if (userType.equals("B2"))
            grid[2][1] = 'O';
            else if (userType.equals("C2"))
            grid[2][2] = 'O';
            else
            System.out.println("Incorrect answer, try again...");
        }*/


    void genererateGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = '-';
            }
        }
    }

    void printGrid() {
        System.out.println("  A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    void printRules() {
        System.out.println("Rules: In this game you need... So, let's play! ");
        System.out.println();
    }

}




