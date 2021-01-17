public class Player {
    private final String name;
    private Integer victories;
    private final Character symbol;

    public Player(String name, Character symbol) {
        this.name = name;
        this.symbol = symbol;
        this.victories = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getVictories() {
        return victories;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void addVictory() {
        victories++;
    }

    @Override
    public String toString() {
        return name+" "+symbol+" : "+victories;
    }
}