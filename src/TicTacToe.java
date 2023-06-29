import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hello dude! Welcome in Tic-Tac-Toe game. Please type your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!" + " Let's start the game!");
        System.out.println();

        game.genererateGrid();
        game.printRules();
        game.printGrid();
        System.out.println("Please type a field: ");
        game.userType = scanner.nextLine();
        game.game();
        game.printGrid();



        }

    }




