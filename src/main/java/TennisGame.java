import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    private static final Map<Integer, String> SCORE_MAP = new HashMap<>();

    static {
        SCORE_MAP.put(0, "Love");
        SCORE_MAP.put(1, "Fifteen");
        SCORE_MAP.put(2, "Thirty");
        SCORE_MAP.put(3, "Forty");
    }

    private final String player1Name;
    private final String player2Name;
    private int playerOneScore;
    private int playerTwoScore;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore) {
            return playerOneScore > 2 ? "Deuce" : SCORE_MAP.get(playerOneScore) + " all";
        } else {
            if (Math.max(playerOneScore, playerTwoScore) > 3) {
                int pointDifference = Math.abs(playerOneScore - playerTwoScore);
                return (pointDifference == 1 ?  "Advantage " : "Game ") + getHighScorerPlayerName();
            } else {
                return SCORE_MAP.get(playerOneScore) + " " + SCORE_MAP.get(playerTwoScore);
            }
        }
    }

    private String getHighScorerPlayerName() {
        return playerOneScore > playerTwoScore ? player1Name : player2Name;
    }

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScore++;
    }
}
