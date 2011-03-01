import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CovertTest {
    @Test
    public void one_should_convert_to_I() {
        String romanOne = new Converter().convert(1);
        assertEquals("I", romanOne);
        String romanFive = new Converter().convert(5);
        assertEquals("V", romanFive);
        String romanTen = new Converter().convert(10);
        assertEquals("X", romanTen);
        String romanFifty = new Converter().convert(50);
        assertEquals("L", romanFifty);
        String romanHundred = new Converter().convert(100);
        assertEquals("C", romanHundred);
        String romanFiveHundred = new Converter().convert(500);
        assertEquals("D", romanFiveHundred);
        String romanOneThousand = new Converter().convert(1000);
        assertEquals("M", romanOneThousand);
    }

}
