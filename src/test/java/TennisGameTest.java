import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TennisGameTest {

    private final TennisGame underTest = new TennisGame("Bob", "Rob");

    @ParameterizedTest
    @CsvSource({
            "0,0,Love all",
            "1,1,Fifteen all",
            "2,2,Thirty all",
            "3,3,Deuce",
            "4,3,Advantage Bob",
            "4,5,Advantage Rob",
            "4,6,Game Rob",
            "6,4,Game Bob",
            "0,1,Love Fifteen",
            "1,2,Fifteen Thirty",
            "4,2,Game Bob",
            "1,0,Fifteen Love",
        	   "0, 1, Love Fifteen",
                "2, 0, Thirty Love",
                "0, 2, Love Thirty",
                "3, 0, Forty Love",
                "0, 3, Love Forty",
    }
    )
    public void testLoveAll(int playerOneScore, int playerTwoScore, String expectedScore) {
        for (int i = 0; i < playerOneScore; i++) {
            underTest.playerOneScored();
        }
        for (int i = 0; i < playerTwoScore; i++) {
            underTest.playerTwoScored();
        }
        Assertions.assertEquals(expectedScore, underTest.getScore());
    }
    
    
    @ParameterizedTest
    @CsvSource(
    		 {
    			 "2, 1, Thirty Fifteen",
    			 "1, 2, Fifteen Thirty",
    			 "3, 1, Forty Fifteen",
    			 "1, 3, Fifteen Forty",
    			 "3, 3, Deuce",
    			 "4, 3, Advantage Bob",
    		     "3, 4, Advantage Rob",
    		     "4, 2, Game Bob",
    		     "2, 4, Game Rob",
    }
    )
    public void testAnothLevel(int playerOneScore, int playerTwoScore, String expectedScore) {
        for (int i = 0; i < playerOneScore; i++) {
            underTest.playerOneScored();
        }
        for (int i = 0; i < playerTwoScore; i++) {
            underTest.playerTwoScored();
        }
        Assertions.assertEquals(expectedScore, underTest.getScore());
    }
    
    
    @ParameterizedTest
    @CsvSource(
    		 {
    			 "2, 1, Thirty Fifteen",
    			 "1, 2, Fifteen Thirty",
    			 "3, 1, Forty Fifteen",
    			 "1, 3, Fifteen Forty",
    			 "3, 3, Deuce",
    			 "4, 3, Advantage Bob",
    		     "3, 4, Advantage Rob",
    		     "4, 1, Game Bob",
                 "1, 4, Game Rob",
    }
    )
    public void testSecodnLevel(int playerOneScore, int playerTwoScore, String expectedScore) {
        for (int i = 0; i < playerOneScore; i++) {
            underTest.playerOneScored();
        }
        for (int i = 0; i < playerTwoScore; i++) {
            underTest.playerTwoScored();
        }
        Assertions.assertEquals(expectedScore, underTest.getScore());
    }
    
    
    @Test
    public void thirtyAllTest() {
        for (int i = 0; i < 2; i++) {
        	underTest.playerOneScored();
            underTest.playerTwoScored();
        }
        Assertions.assertEquals("Thirty all", underTest.getScore());
    }
    
    @Test
    public void deuceTest() {
    	
        for (int i = 0; i < 3; i++) {
        	underTest.playerOneScored();
            underTest.playerTwoScored();
        }
        Assertions.assertEquals("Deuce", underTest.getScore());
    }
    
    @Test
    public void advantagePlayer1Test() {
        for (int i = 0; i < 3; i++) {
        	underTest.playerOneScored();
            underTest.playerTwoScored();
        }
    	underTest.playerOneScored();
        Assertions.assertEquals("Advantage Bob", underTest.getScore());
    }
    
    @Test
    public void advantagePlayer2Test() {
        for (int i = 0; i < 3; i++) {
        	underTest.playerOneScored();
            underTest.playerTwoScored();
        }
        underTest.playerTwoScored();
       Assertions.assertEquals("Advantage Rob", underTest.getScore());
    }

    @Test
    public void winForPlayer1Test() {
        for (int i = 0; i < 4; i++) {
        	underTest.playerOneScored();
        }
        Assertions.assertEquals("Game Bob", underTest.getScore());
    }
    
    @Test
    public void winForPlayer2Test() {
        
        for (int i = 0; i < 4; i++) {
        	underTest.playerTwoScored();
        }
        Assertions.assertEquals("Game Rob", underTest.getScore());
    }
    
    @Test
    public void fortyLoveTest() {
        for (int i = 0; i < 3; i++) {
        	underTest.playerOneScored();
        }
        Assertions.assertEquals("Forty Love", underTest.getScore());
    }
    
    @Test
    public void loveFortyTest() {
        
        for (int i = 0; i < 3; i++) {
        	underTest.playerTwoScored();
        }
        Assertions.assertEquals("Love Forty", underTest.getScore());
    }

    @Test
    public void fifteenThirtyTest() {
       
    	underTest.playerOneScored();
        for (int i = 0; i < 2; i++) {
        	underTest.playerTwoScored();
        }
        Assertions.assertEquals("Fifteen Thirty", underTest.getScore());
    }


}
