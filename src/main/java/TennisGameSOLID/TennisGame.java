package TennisGameSOLID;

interface ScoreFormatter {
    String format(int player1Score, int player2Score);
}

class TennisGame {
    private int player1Score;
    private int player2Score;
    private ScoreFormatter formatter;

    public TennisGame(ScoreFormatter formatter) {
        player1Score = 0;
        player2Score = 0;
        this.formatter = formatter;
    }

    public void player1Scores() {
        player1Score++;
    }

    public void player2Scores() {
        player2Score++;
    }

    public String getScore() {
        return formatter.format(player1Score, player2Score);
    }
}

class BasicScoreFormatter implements ScoreFormatter {
    public String format(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            switch (player1Score) {
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                default:
                    return "Deuce";
            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int scoreDiff = player1Score - player2Score;
            if (scoreDiff == 1) return "Advantage player1";
            else if (scoreDiff == -1) return "Advantage player2";
            else if (scoreDiff >= 2) return "Win for player1";
            else return "Win for player2";
        } else {
            String score = "";
            int tempScore;
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    score += "-";
                    tempScore = player2Score;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
            return score;
        }
    }
}

