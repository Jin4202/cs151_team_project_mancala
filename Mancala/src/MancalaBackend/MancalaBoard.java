package MancalaBackend;

/***
 * MancalaBoard represents a mancala board and controls the flow of the game
 */
public class MancalaBoard {

    private PlayerTypes turn = PlayerTypes.PlayerA;
    private MancalaPit[] playerAPits = new MancalaPit[7];
    private MancalaPit[] playerBPits = new MancalaPit[7];

    /***
     * Creates a new mancala board
     * @param size the starting number of stones to go in each players pits
     */
    public MancalaBoard(PitSize size) {
        startNewGame(size);
    }

    /***
     * starts a new mancala game
     * @param size the starting number of stones to go in each player pits
     */
    public void startNewGame(PitSize size) {
        int pitSize = 3;
        if (size == PitSize.Four) pitSize = 4;

        for (int i = 0; i < 6; i++) {
            playerAPits[i] = new MancalaPit(pitSize, false);
            playerBPits[i] = new MancalaPit(pitSize, false);
        }
        playerAPits[6] = new MancalaPit(0, true);
        playerBPits[6] = new MancalaPit(0, true);

        turn = PlayerTypes.PlayerA;
    }

    /***
     * gets the current players turn
     * @return the current players turn
     */
    public PlayerTypes getTurn() {
        return turn;
    }

    /***
     * Enum that represents the two types of players
     */
    public enum PlayerTypes {
        PlayerA,
        PlayerB
    }

    /***
     * Enum that represents the possible starting sizes
     */
    public enum PitSize {
        Three,
        Four
    }
}
