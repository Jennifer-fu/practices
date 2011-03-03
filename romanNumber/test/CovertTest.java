import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CovertTest {
    @Test
    public void one_should_convert_to_I() {
        String romanOne = new Converter().convertArabicToStaticRoman(1);
        assertEquals("I", romanOne);
        String romanFive = new Converter().convertArabicToStaticRoman(5);
        assertEquals("V", romanFive);
        String romanTen = new Converter().convertArabicToStaticRoman(10);
        assertEquals("X", romanTen);
        String romanFifty = new Converter().convertArabicToStaticRoman(50);
        assertEquals("L", romanFifty);
        String romanHundred = new Converter().convertArabicToStaticRoman(100);
        assertEquals("C", romanHundred);
        String romanFiveHundred = new Converter().convertArabicToStaticRoman(500);
        assertEquals("D", romanFiveHundred);
        String romanOneThousand = new Converter().convertArabicToStaticRoman(1000);
        assertEquals("M", romanOneThousand);
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

    @Test
    public void four_should_convert_to_IV() {
        String IV = new Converter().convertArabicToRoman(4);
        assertEquals("IV", IV);
        String XL = new Converter().convertArabicToRoman(40);
        assertEquals("XL", XL);
        String CD = new Converter().convertArabicToRoman(400);
        assertEquals("CD", CD);
    }

    @Test
    public void nine_should_convert_to_IX() {
        String IX = new Converter().convertArabicToRoman(9);
        assertEquals("IX", IX);
        String XC = new Converter().convertArabicToRoman(90);
        assertEquals("XC", XC);
        String CM = new Converter().convertArabicToRoman(900);
        assertEquals("CM", CM);
    }

    @Test
    public void fifteen_should_convert_to_xv(){
        String XV = new Converter().convertArabicToRoman(15);
        assertEquals("XV",XV);
    }

    @Test
       public void ninty_one_should_convert_to_XCI() {
           String XCI = new Converter().convertArabicToRoman(91);
           assertEquals("XCI", XCI);
           String CMXI = new Converter().convertArabicToRoman(911);
           assertEquals("CMXI", CMXI);
       }

}
