package game;
import player.Player;
import board.Board;
import java.util.Scanner;

public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean isGameOver;
    String zero;
    String cross;

    public Game(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.isGameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for(int i = 0; i < board.size; i++) {
            z.append("0");
            c.append("X");
        }

        this.zero = z.toString();
        this.cross = c.toString();
    }

    public void printBoardConfig(){
        board.printBoardConfig();
    }

    public void play() {
        printBoardConfig();
        int sz = board.size;

        while(!isGameOver) {
            noOfMoves++;
            int pos = getIndex();
            int row = pos / sz;
            int col = pos % sz;

            board.matrix[row][col] = players[turn].getPlayerSymbol();
            if(noOfMoves >= sz*sz) {
                isGameOver = true;
                System.out.println("Game is a draw");
                return;
            }
            else if(noOfMoves >= 2*sz-1 && checkCombination()) {
                printBoardConfig();
                System.out.println("Player: " + players[turn].getPlayerName() + " wins");
                isGameOver = true;
                return;
            }
            turn = (turn + 1) % 2;
            printBoardConfig();
        }
    }

    public int getIndex() {
        while(true) {
            System.out.print("Player: " + players[turn].getPlayerName() + " give the position: ");
            Scanner sr = new Scanner(System.in);
            int pos = sr.nextInt() - 1;

            int sz = board.size;
            int row = pos / sz;
            int col = pos % sz;

            if(row < 0 || row >= sz || col < 0 || col >= sz) {
                System.out.println("Invalid position, please enter again");
                continue;
            } 
            else if(board.matrix[row][col] != '@') {
                System.out.println("Position already occupied, please enter again");
                continue;
            }
            return pos;
        }
    }

    public boolean checkCombination() {
        int sz = board.size;

        for(int i = 0; i<sz; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();

            for(int j = 0; j<sz; j++) {
                row.append(board.matrix[i][j]);
                col.append(board.matrix[j][i]);
            }

            if(row.toString().equals(zero) || col.toString().equals(zero)) {
                return true;
            }
            else if(row.toString().equals(cross) || col.toString().equals(cross)) {
                return true;
            }
        }

        StringBuilder diag = new StringBuilder();
        StringBuilder antiDiag = new StringBuilder();
        int i = 0, j = 0;
        while(i < sz && j < sz) {
            diag.append(board.matrix[i][j]);
            i++;
            j++;
        }

        if(diag.toString().equals(zero) || antiDiag.toString().equals(zero)) {
            return true;
        }

        i = 0;
        j = sz-1;
        while(i < sz && j >= 0) {
            antiDiag.append(board.matrix[i][j]);
            i++;
            j--;
        }
        
        if(diag.toString().equals(cross) || antiDiag.toString().equals(cross)) {
            return true;
        }

        return false;
    }
}
