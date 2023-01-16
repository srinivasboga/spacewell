package TennisGameSOLID;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TennisGameTest {

    @ParameterizedTest
    @CsvSource({"0,0,Love-All",
    			"1,1,Fifteen-All",
    			"2,2,Thirty-All",
    			"3,3,Deuce",
    			"4,4,Deuce",
    			"1,0,Fifteen-Love",
    			"0,1,Love-Fifteen",
    			"2,0,Thirty-Love",
    			"0,2,Love-Thirty",
                "3,2,Forty-Thirty",
                "2,3,Thirty-Forty",
                "4,3,Advantage player1",
                "3,4,Advantage player2", 
                "4,0,Win for player1",
                "0,4,Win for player2",
           })
    public void testScores(int player1Score, int player2Score, String expectedScore) {
        TennisGame game = new TennisGame(new BasicScoreFormatter());
        for (int i = 0; i < player1Score; i++) {
            game.player1Scores();
        }
        for (int i = 0; i < player2Score; i++) {
            game.player2Scores();
        }
        assertEquals(expectedScore, game.getScore());
    }
    
    @Test
    public void player1WinsWithoutOpponentScoring() {
        TennisGame game = new TennisGame(new BasicScoreFormatter());
        for (int i = 0; i < 6; i++) {
            game.player1Scores();
        }
        assertEquals("Win for player1", game.getScore());
    }
    
    @Test
    public void bothPlayersSameScoreNotAllZero() {
        TennisGame game = new TennisGame(new BasicScoreFormatter());
        for (int i = 0; i < 3; i++) {
            game.player1Scores();
        }
        for (int i = 0; i < 3; i++) {
            game.player2Scores();
        }
        assertEquals("Deuce", game.getScore());
    }

}


