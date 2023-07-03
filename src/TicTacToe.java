import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GameLogic gameLogic = new GameLogic();

            System.out.print("Hi buddy! Welcome in Tic-Tac-Toe game. Please type your name: ");
            String name = reader.readLine();
            System.out.println("Hello " + name + "! My name is Computer. " + "Let's start the game!");
            System.out.println();
            System.out.println("The rules: \nIn this game we will try to place three of our symbols in the line a row on" +
                    " a 3x3 board. The row can be horizontal, vertical,\nor diagonal. The first one to do it wins the " +
                    "game. You as a master will get the O, while I, as the humble computer, will take the X sign. \n" +
                    "If the entire board gets filled up without a winning line, it's a tie. Alright, let's dive into " +
                    "this strategic battle of X and O, dude! \n\nLet's the best win!");
            System.out.println();

            gameLogic.playGame();

        }
    }




