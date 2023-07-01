import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int column = 0;
        int row = 0;
        String column1 = " ";

        System.out.print("Hello dude! Welcome in Tic-Tac-Toe game. Please type your name: ");
        //String name = scanner.nextLine();
        //System.out.println("Hello " + name + "! My name is Computer" + " Let's start the game!");
        System.out.println();

        game.genererateGrid();
        game.printRules();
        game.printGrid();

            System.out.println("Please type a column: ");
            column1 = scanner.nextLine();
            System.out.println("Please type a row: ");
            row = scanner.nextInt();
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
        game.assignCoordinates(column, row);
        game.printGrid();
        game.computerMove(column, row);




        // ruch kompa


        game.printGrid();
    }
}




