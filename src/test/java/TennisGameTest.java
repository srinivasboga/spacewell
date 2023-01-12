import org.junit.jupiter.api.Assertions;
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
}
