import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        if(args.length>0) {
            if(args[0].equalsIgnoreCase("--custom") || args[0].equalsIgnoreCase("-c")) {
                ticTacToe.initPlayers();
            }
        }else {
            ticTacToe.initBasicPlayers();
        }

        boolean playAgain;
        do {
            ticTacToe.play();
            System.out.println("Play again ? (Y/n)");
            String again = input.next();
            playAgain = again.matches("^(?:y(?:es)?|1)$");
        }while (playAgain);
    }
}
