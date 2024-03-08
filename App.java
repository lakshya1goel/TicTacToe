import board.Board;
import player.Player;
import game.Game;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Board b = new Board(3, '@');
        b.printBoardConfig();

        Scanner sr = new Scanner(System.in);
        Player P1 = new Player();
        System.out.print("Enter the name of the first player: ");
        String playerOneNmae = sr.next();
        System.out.print("Enter the symbol of the first player: ");
        char playerOneSymbol = sr.next().charAt(0);
        P1.setPlayerNameAndSymbol(playerOneNmae, playerOneSymbol);

        Player P2 = new Player();
        System.out.print("Enter the name of the second player: ");
        String playerTwoNmae = sr.next();
        System.out.print("Enter the symbol of the second player: ");
        char playerTwoSymbol = sr.next().charAt(0);
        P2.setPlayerNameAndSymbol(playerTwoNmae, playerTwoSymbol);
        P1.getPlayerNameAndSymbol();
        P2.getPlayerNameAndSymbol();

        Game game = new Game(new Player[] { P1, P2 }, b);
        game.play();
    }
}
