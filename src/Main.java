public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        if(args.length>0) {
            if(args[0].equalsIgnoreCase("--custom") || args[0].equalsIgnoreCase("-c")) {
                ticTacToe.initPlayers();
            }
        }else {
            ticTacToe.initBasicPlayers();
        }
        ticTacToe.play();
    }
}
