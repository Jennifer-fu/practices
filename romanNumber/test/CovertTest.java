import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CovertTest {
    @Test
    public void one_should_convert_to_I() {
        char romanOne = new Converter().convertSingleArabicToRoman(1);
        assertEquals('I', romanOne);
        char romanFive = new Converter().convertSingleArabicToRoman(5);
        assertEquals('V', romanFive);
        char romanTen = new Converter().convertSingleArabicToRoman(10);
        assertEquals('X', romanTen);
        char romanFifty = new Converter().convertSingleArabicToRoman(50);
        assertEquals('L', romanFifty);
        char romanHundred = new Converter().convertSingleArabicToRoman(100);
        assertEquals('C', romanHundred);
        char romanFiveHundred = new Converter().convertSingleArabicToRoman(500);
        assertEquals('D', romanFiveHundred);
        char romanOneThousand = new Converter().convertSingleArabicToRoman(1000);
        assertEquals('M', romanOneThousand);
    }

    @Test
    public void I_should_convert_to_one() {
        int one = new Converter().convertSingleRomanToArabic('I');
        assertEquals(1, one);
        int five = new Converter().convertSingleRomanToArabic('V');
        assertEquals(5, five);
        int ten = new Converter().convertSingleRomanToArabic('X');
        assertEquals(10, ten);
        int fifty = new Converter().convertSingleRomanToArabic('L');
        assertEquals(50, fifty);
        int hundred = new Converter().convertSingleRomanToArabic('C');
        assertEquals(100, hundred);
        int fiveHundred = new Converter().convertSingleRomanToArabic('D');
        assertEquals(500, fiveHundred);
        int thousand = new Converter().convertSingleRomanToArabic('M');
        assertEquals(1000, thousand);

    }

    @Test
    public void II_should_convert_to_two() {
        int two = new Converter().convertRomanToArabic("II");
        assertEquals(2, two);
        int six = new Converter().convertRomanToArabic("VI");
        assertEquals(6, six);
    }

    @Test
    public void IV_should_convert_to_four() {
        int two = new Converter().convertRomanToArabic("IV");
        assertEquals(4, two);
    }

    @Test
    public void two_should_convert_to_II() {
        String II = new Converter().convertArabicToRoman(2);
        assertEquals("II", II);
        String VI = new Converter().convertArabicToRoman(6);
        assertEquals("VI", VI);
    }
}
