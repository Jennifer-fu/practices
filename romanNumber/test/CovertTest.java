import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CovertTest {
    @Test
    public void one_should_convert_to_I() {
        String romanOne = new Converter().convertArabicToRoman(1);
        assertEquals("I", romanOne);
        String romanFive = new Converter().convertArabicToRoman(5);
        assertEquals("V", romanFive);
        String romanTen = new Converter().convertArabicToRoman(10);
        assertEquals("X", romanTen);
        String romanFifty = new Converter().convertArabicToRoman(50);
        assertEquals("L", romanFifty);
        String romanHundred = new Converter().convertArabicToRoman(100);
        assertEquals("C", romanHundred);
        String romanFiveHundred = new Converter().convertArabicToRoman(500);
        assertEquals("D", romanFiveHundred);
        String romanOneThousand = new Converter().convertArabicToRoman(1000);
        assertEquals("M", romanOneThousand);
    }

    @Test
    public void I_should_convert_to_one() {
        int one = new Converter().convertRomanToArabic("I");
        assertEquals(1, one);
        int five = new Converter().convertRomanToArabic("V");
        assertEquals(5, five);
        int ten = new Converter().convertRomanToArabic("X");
        assertEquals(10, ten);
        int fifty = new Converter().convertRomanToArabic("L");
        assertEquals(50, fifty);
        int hundred = new Converter().convertRomanToArabic("C");
        assertEquals(100, hundred);
        int fiveHundred = new Converter().convertRomanToArabic("D");
        assertEquals(500, fiveHundred);
        int thousand = new Converter().convertRomanToArabic("M");
        assertEquals(1000, thousand);

    }

}
