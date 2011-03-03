import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Converter {
    private final HashMap<Integer, String> arabicToRoman = new HashMap<Integer, String>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
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

    public String convertArabicToStaticRoman(int arabicNum) {
        return arabicToRoman.get(arabicNum);
    }

    public int convertSingleRomanToArabic(char romanNum) {
        return romanToArabic.get(romanNum);
    }


    public int convertRomanToArabic(String compositeRoman) {
        char[] simpleRomanArray = compositeRoman.toCharArray();
        int result = 0;
        for (int i = 0; i < simpleRomanArray.length; i = i + 2) {
            char current = simpleRomanArray[i];
            char after = 0;
            if (i < simpleRomanArray.length - 1) {
                after = simpleRomanArray[i + 1];
            }
            result += convertTwoRomanToArabic(current, after);
        }
        return result;
    }

    private int convertTwoRomanToArabic(char current, char after) {
        int currentArabic = convertSingleRomanToArabic(current);
        int afterArabic = convertSingleRomanToArabic(after);
        if (afterArabic > currentArabic) {
            return afterArabic - currentArabic;
        }
        return currentArabic + afterArabic;
    }

    public String convertArabicToRoman(int compositeArabic) {
        StringBuffer roman = new StringBuffer();
        TreeSet<Integer> staticArabicNumbers = new TreeSet<Integer>(arabicToRoman.keySet());
        Iterator<Integer> iterator = staticArabicNumbers.descendingIterator();
        while (iterator.hasNext()){
            compositeArabic = generateRoman(compositeArabic, roman, iterator.next());
        }
        return roman.toString();
    }

    private int generateRoman(int compositeArabic, StringBuffer roman, int simpleArabic) {
        int m = 0;
        if (compositeArabic / simpleArabic != 0) m = compositeArabic / simpleArabic;
        for (int count = 0; count < m; count++) {
            roman.append(convertArabicToStaticRoman(simpleArabic));
        }
        compositeArabic %= simpleArabic;
        return compositeArabic;
    }
}
