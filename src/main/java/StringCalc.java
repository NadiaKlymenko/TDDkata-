/**
 * Created by Nadia on 12.11.2015.
 */
public class StringCalc {
    private static final String PREFIX = "//";
    public int add(String s) {
        if(s.length() == 0)
            return 0;
        checkNegatives(values(s));
        return sum(values(s));
    }
    private String[] values (String s){
        return numbers(s).split(delimiter(s));
    }

    private String delimiter(String s) {
        String delimiter = ",|\n";
        if (s.startsWith(PREFIX))
            return s.substring(2,3);
        return ",|\n";
    }

    private String numbers(String s) {
        String values = s;
        if (s.startsWith(PREFIX))
            return s.substring(3);
        return s;
    }

    public int sum(String [] values){

        int total = 0;
        for (String value : values){
            total += toInt(value);
        }
        return total;
    }
    private Integer toInt(String value){
        return Integer.valueOf(value);
    }
    private void checkNegatives(String[] values){
        String negatives ="";
        for (String value : values)
            if(toInt(value) < 0)
                negatives += "," + value;
        if (negatives.length() > 0)
            throw new RuntimeException(negatives.substring(1));
    }
}
