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
			return "Player1: " + getScoreName(player1Score) + " - " + "Player2: " + getScoreName(player2Score);// + "
																												// all";
		} else if (player1Score >= 4 || player2Score >= 4) {
			int scoreDifference = player1Score - player2Score;
			if (scoreDifference == 1)
				return "Advantage Player1";
			else if (scoreDifference == -1)
				return "Advantage Player2";
			else if (scoreDifference >= 2)
				return "Win for Player1";
			else
				return "Win for Player2";
		} else {
			return "Player1: " + getScoreName(player1Score) + " - " + "Player1: " + getScoreName(player2Score);
		}
	}

	static private String getScoreName(int score) {
		switch (score) {
		case 0:
			return "Love All";
		case 1:
			return "Fifteen";
		case 2:
			return "Thirty";
		case 3:
			return "Forty";
		default:
			return " A";
		}
	}

	public static void main(String[] args) {

		TennisGame game = new TennisGame();

		try {
			boolean enterScoreAgain = false;

			do {
				int enterScore = Integer
						.parseInt(JOptionPane.showInputDialog("                Please enter the player who scored, \n "
								+ "Enter Digit '1' for Server=1 Digit '2' for Receiver=2 ?"));

				if (enterScore == 1) {
					game.server();
				} else if (enterScore == 2) {
					game.receiver();
				} else {
					enterScore = Integer.parseInt(JOptionPane.showInputDialog(
							"Please give valid input digit 1 OR 2 " + "\n 1 For Receiver & 2 For Server!"));
				}

				int n = JOptionPane.showConfirmDialog(null, "You want to enter the score ?", null,
						JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (n == JOptionPane.YES_OPTION) {
					enterScoreAgain = true;
				} else if (n == JOptionPane.NO_OPTION) {
					enterScoreAgain = false;
				} else {
					enterScoreAgain = null != null;
				}

				System.out.println(enterScoreAgain + "\n" + game.getScore());

			} while (enterScoreAgain);

		} catch (NumberFormatException e) {
			System.out.println("Please provide valid scores !");
			e.getMessage();
		}

		// game.receiver();
		// game.receiver();
		JOptionPane.showMessageDialog(null,
				"Player1 =" + getScoreName(player1Score) + "\nPlayer2 =" + getScoreName(player2Score));
		// JOptionPane.showMessageDialog(null,game.getScore());
		// System.out.println(game.getScore()); //Fifteen - Fifteen

	}

}
