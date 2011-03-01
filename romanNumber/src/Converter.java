import java.util.HashMap;

public class Converter {
    private final HashMap<Integer, Character> arabicToRoman = new HashMap<Integer, Character>() {
        {
            put(1, 'I');
            put(5, 'V');
            put(10, 'X');
            put(50, 'L');
            put(100, 'C');
            put(500, 'D');
            put(1000, 'M');
        }
    };

    private final HashMap<Character, Integer> romanToArabic = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public char convertSingleArabicToRoman(int arabicNum) {
        return arabicToRoman.get(arabicNum);
    }

    public int convertSingleRomanToArabic(char romanNum) {
        return romanToArabic.get(romanNum);
    }


    public int convertRomanToArabic(String multiRomanNum) {
        char[] simpleRomanArray = multiRomanNum.toCharArray();
        int result = 0;
        for (int i = 0; i < simpleRomanArray.length;) {
            int current = convertSingleRomanToArabic(simpleRomanArray[i]);
            int after = 0;
            if (i < simpleRomanArray.length - 1) {
                after = convertSingleRomanToArabic(simpleRomanArray[i + 1]);
            }
            if (after > current) {
                result += (after - current);
                i += 2;
            } else {
                result += current;
                i++;
            }
        }
        return result;
    }
}
