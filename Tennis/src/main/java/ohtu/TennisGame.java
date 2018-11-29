package ohtu;

public class TennisGame {
    
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String SCORE_DEUCE = "Deuce";
    private static final String SCORE_ALL_SUFFIX = "-All";
    private static final String SCORE_WIN_PREFIX = "Win for ";
    private static final String SCORE_ADV_PREFIX = "Advantage ";
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            ++player1Score;
        } else if (playerName.equals(player2Name)) {
            ++player2Score;
        }
    }
    
    public void reset() {
        player1Score = 0;
        player2Score = 0;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int winScore = SCORE_NAMES.length;
        
        if (player1Score == player2Score) {
            // score is equal
            if (player1Score < winScore) {
                // -All if score isn't enough for Deuce
                score.append(SCORE_NAMES[player1Score]);
                score.append(SCORE_ALL_SUFFIX);
            } else {
                score.append(SCORE_DEUCE);
            }
        } else if (player1Score >= winScore || player2Score >= winScore) {
            // score is high enough for advantage or win
            int pointDifference = Math.abs(player1Score - player2Score);
            // use Advantage for one point difference or Win for more than one
            score.append(pointDifference <= 1 ? SCORE_ADV_PREFIX : SCORE_WIN_PREFIX);
            // append the name of the player that is ahead
            score.append((player1Score > player2Score) ? player1Name : player2Name);
        } else {
            // append the score of the first player
            score.append(SCORE_NAMES[player1Score]);
            score.append("-");
            // append the score of the second player
            score.append(SCORE_NAMES[player2Score]);
        }
        
        return score.toString();
    }
}