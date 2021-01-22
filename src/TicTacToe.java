import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private Integer round, game, nul, lastFirst;
    private final Board board;
    private final Player[] players;

    public TicTacToe() {
        board = new Board();
        players = new Player[2];
        round = 0;
        lastFirst = 1;
        game = 0;
        nul = 0;
    }

    public void initPlayers() {
        Scanner input = new Scanner(System.in);
        System.out.print("Player 1 enter your name: ");
        String name = input.next();
        System.out.print("Enter your symbol: ");
        char symbol = input.next().charAt(0);
        players[0] = new Player(name, symbol);

        do {
            System.out.print("Player 2 enter your name: ");
            name = input.next();
            if(name == player[0].getName()) System.out.println("You can't use the same name as player 1.");
        }while(name == player[0].getName())
        do{
            System.out.print("Enter your symbol: ");
            symbol = input.next().charAt(0);
            if(name == player[0].getSymbol()) System.out.println("You can't use the same symbol as player 1.");
        }while (symbol == players[0].getSymbol());
        players[1] = new Player(name, symbol);
    }

    public void initBasicPlayers() {
        players[0] = new Player("Player1", 'X');
        players[1] = new Player("Player2", 'O');
    }

    private int askIndex(String player) {
        Scanner input = new Scanner(System.in);
        boolean keep = false;
        int index = 0;
        do{
            keep = false;
            try {
                System.out.print("\n"+player+" where do you wan't to play ? (0-8) ");
                index = input.nextInt();
                if(index<0 || index>8) throw new Exception();

            }catch (Exception e) {
                System.out.println("Error.");
                keep = true;
            }
        }while(keep);

        return index;
    }

    public void print() {
        System.out.println(players[0]);
        board.print();
        System.out.println(players[1]);
    }

    public void play() {
        if(lastFirst==0) {
            round = 1;
        }else {
            round = 0;
        }
        lastFirst = round;
        game++;
        board.reset();

        //board.setBoard(new Character[] {'X', 'X', null, 'O', null, 'O', null, null, 'X'});

        System.out.println("Game "+game+", null: "+nul);
        Player player;
        do{
            print();
            player = players[round%2];
            boolean result;
            do{
                int playIndex = askIndex(player.getName());
                result = board.play(playIndex, player.getSymbol());
                if(!result) {
                    System.out.println("You can't play here");
                }
            }while(!result);

            round++;
        }while(!board.testVictory() && round<=8);

        print();

        if(board.testVictory()) {
            System.out.println("\n\n"+player.getName()+" you win !\n\n");
            player.addVictory();
        }else {
            System.out.println("It's a tie.");
            nul++;
        }
    }
}
