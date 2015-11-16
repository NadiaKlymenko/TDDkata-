package BowlingGame;

/**
 * Created by Nadia on 15.11.2015.
 */
public class Game {
    private static final int FRAME_SIZE = 10 ;
    private int[] rolls = new int[21];
    private int currentRoll;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame=0; frame<FRAME_SIZE; frame++) {
            if (isStrike(frameIndex)){
                score = score + 10 + strikeBonus(frameIndex);
                frameIndex ++;
            } else if (isSpare(frameIndex)){
                score = score +spareBonus(frameIndex) + 10;
                frameIndex = frameIndex + 2;
            } else {
                score = score + sumOfAllInFrame(frameIndex);
                frameIndex = frameIndex + 2;
            }
        }
        return score;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareBonus(int frameIndex) {
        return  rolls[frameIndex+2];
    }

    private int sumOfAllInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex +1];
    }

    private boolean isStrike(int frameIndex){
        return rolls[frameIndex ] ==10;
    }

    private boolean isSpare(int frameIndex){
        return rolls[frameIndex] + rolls [ frameIndex + 1] == 10;
    }
}
