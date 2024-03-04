import board.Board;
import player.Player;

public class App {
    public static void main(String[] args) throws Exception {

        Board b = new Board(3, '@');
        b.printBoardConfig();
        Player P1 = new Player();
        P1.setPlayerDetails("Lakshya", 18, "Meerut", 999999999, "lakshya1234@gmail.com", 'X');
        P1.getPlayerDetails();
    }
}
