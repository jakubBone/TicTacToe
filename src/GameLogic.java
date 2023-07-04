import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GameLogic {
    char[][] grid = new char[3][3];
    boolean isGameOver = false;
    char currentPlayer = 'O';
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Board board = new Board();
    Player player = new Player();


    void playGame() throws IOException {        // the game method
        board.genererateGrid(grid);

        while (!isGameOver) {
            board.printGrid(grid);
            player.userMove(grid, currentPlayer);
            switchPlayer();
            gameStatus(currentPlayer);
            if (isGameOver)
                break;
            player.computerMove(grid, currentPlayer);
            switchPlayer();
            gameStatus(currentPlayer);
        }
            whoIsWinner();
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

    boolean checkResult(char player) {
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

    public boolean isGridFull(){                            // check if the grid is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    void switchPlayer(){                                    // switch the player after move
        currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }  // switch player after movement

}




