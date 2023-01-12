package TennisGameJSwing;

import javax.swing.JOptionPane;

public class TennisGame {

	
	    private static int player1Score = 0;
	    private static int player2Score = 0;

	    public void server() {
	        player1Score++;
	    }

	    public void receiver() {
	        player2Score++;
	    }

	   public String getScore() {
	        if (player1Score == player2Score) {
	            return getScoreName(player1Score) +"-"+getScoreName(player2Score);// + " all";
	        } else if (player1Score >= 4 || player2Score >= 4) {
	            int scoreDifference = player1Score - player2Score;
	            if (scoreDifference == 1) return "Advantage player1";
	            else if (scoreDifference == -1) return "Advantage player2";
	            else if (scoreDifference >= 2) return "Win for player1";
	            else return "Win for player2";
	        } else {
	            return getScoreName(player1Score) + "-" + getScoreName(player2Score);
	        }
	    }

	   static private String getScoreName(int score) {
	        switch (score) {
	            case 0:
	                return "Zero";
	            case 1:
	                return "Fifteen";
	            case 2:
	                return "Thirty";
	            case 3:
	                return "Forty";
	            default:
	                return "";
	        }
	    }
	
	public static void main(String[] args) {
		
		TennisGame game = new TennisGame();
		
		boolean enterScoreAgain;
		
		do {
		
			int enterScore = Integer.parseInt(JOptionPane.showInputDialog("enter the player who scored, Enter server=1/receiver=2 ?"));
			
			if(enterScore==1) {
				game.server();
			} else {
				game.receiver();
			}
			
			int  n = Integer.parseInt(JOptionPane.showInputDialog("If you want to enter the player who scored, Yes=1/No=0?"));
			if(n==0) {
				enterScoreAgain = false;
			} else {
				enterScoreAgain = true;
			}
			
			System.out.println(enterScoreAgain+"\n"+game.getScore());
		
		}while(enterScoreAgain);
		
		
		//game.receiver();
		//game.receiver();
		JOptionPane.showMessageDialog(null, "Player1 = "+getScoreName(player1Score) + "\n" + "Player2 = "+ getScoreName(player2Score));
		JOptionPane.showMessageDialog(null,game.getScore());
		System.out.println(game.getScore()); //Fifteen - Fifteen

		
	}

}
