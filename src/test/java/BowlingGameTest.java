import BowlingGame.Game;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nadia on 15.11.2015.
 */
public class BowlingGameTest {

    private Game game = new Game();
    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes(){;
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
     public void canRollSpare (){
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void canRollStrike(){
        rollStrike(); //strike
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(26, game.score());
    }

    @Test
    public void perfectGame(){
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollMany(int n, int pins){
        for (int i=0; i<n; i++){
            game.roll(pins);
        }
    }

    private void rollSpare(){
        game.roll(5);
        game.roll(5); //spare
    }

    private void rollStrike(){
        game.roll(10);
    }

}
