import StringCalc.StringCalc;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.junit.*;

/**
 * Created by Nadia on 12.11.2015.
 */
public class StringCalcTest {
    private StringCalc calculator = new StringCalc();
    @Test
    public void calculatorShouldAdd() {
        checkAdd("", 0);
        checkAdd("1", 1);
        checkAdd("2", 2);
        checkAdd("1,2", 3);
        checkAdd("1\n2", 3);
        checkAdd("//;1;2;3", 6);
    }

    @Test
    public void calculatorShouldAddNoNegative() {
        try {
            calculator.add("-1");
            fail();
        }
        catch (Exception e){
            assertEquals("-1", e.getMessage());

        }
    }

    @Test
    public void calculatorShouldAddNoNegativeValues(){
        try {
            calculator.add("-1,2,-2");
        }
        catch (Exception e){
            assertEquals("-1,-2", e.getMessage());
        }
    }

    private void checkAdd(String s, int i) {
        assertEquals(i, calculator.add(s));
    }
}
