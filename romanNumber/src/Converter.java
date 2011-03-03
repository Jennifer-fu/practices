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

    private final HashMap<Integer, String> arabicToCompositeRoman = new HashMap<Integer, String>() {
        {
            put(4, "IV");
            put(9, "IX");
            put(40, "XL");
            put(90, "XC");
            put(400, "CD");
            put(900, "CM");
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
        Character simpleRoman = arabicToRoman.get(arabicNum);
        if (simpleRoman != null) return String.valueOf(simpleRoman);
        return arabicToCompositeRoman.get(arabicNum);
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
        int i = 0, v = 0, x = 0, l = 0, c = 0;
        compositeArabic = generateRoman(compositeArabic, roman, 1000);
        compositeArabic = generateRoman(compositeArabic, roman, 900);
        compositeArabic = generateRoman(compositeArabic, roman, 500);
        compositeArabic = generateRoman(compositeArabic, roman, 400);
        compositeArabic = generateRoman(compositeArabic, roman, 100);
        compositeArabic = generateRoman(compositeArabic, roman, 90);
        compositeArabic = generateRoman(compositeArabic, roman, 50);
        compositeArabic = generateRoman(compositeArabic, roman, 40);
        compositeArabic = generateRoman(compositeArabic, roman, 10);
        compositeArabic = generateRoman(compositeArabic, roman, 9);
        compositeArabic = generateRoman(compositeArabic, roman, 5);
        compositeArabic = generateRoman(compositeArabic, roman, 4);
        generateRoman(compositeArabic, roman, 1);
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
