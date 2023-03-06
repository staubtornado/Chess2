public class Player {
    private PlayerColor color;
    private String name;
    public int elo;
    public String ip;
    public int port;
    public int id;
    public int wins;
    public int losses;
    public int draws;

    public Player(PlayerColor color, String name, int elo, String ip, int port, int id, int wins, int losses, int draws) {
        this.color = color;
        this.name = name;
        this.elo = elo;
        this.ip = ip;
        this.port = port;
        this.id = id;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }

    private void send(String message) {

    }
}
