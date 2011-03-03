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
        int i = 0, v = 0, x = 0, l = 0, c = 0, d = 0, m = 0;
        if (compositeArabic / 1000 != 0) m = compositeArabic / 1000;
        for (int count = 0; count < m; count++) {
            roman.append(convertSingleArabicToRoman(1000));
        }
        compositeArabic %= 1000;
        if (compositeArabic == 900) {
            roman.append(convertArabicToRoman(100)).append(convertArabicToRoman(1000));
        } else {
            if (compositeArabic / 500 != 0) d = compositeArabic / 500;
            for (int count = 0; count < d; count++) {
                roman.append(convertSingleArabicToRoman(500));
            }
            compositeArabic %= 500;

            if (compositeArabic / 100 != 0) c = compositeArabic / 100;
            if (c <= 3) {
                for (int count = 0; count < c; count++) {
                    roman.append(convertSingleArabicToRoman(100));
                }
            } else {
                roman.append(convertArabicToRoman(100)).append(convertArabicToRoman(500));
            }
            compositeArabic %= 100;
            if (compositeArabic == 90) {
                roman.append(convertArabicToRoman(10)).append(convertArabicToRoman(100));
            } else {
                if (compositeArabic / 50 != 0) l = compositeArabic / 50;
                for (int count = 0; count < l; count++) {
                    roman.append(convertSingleArabicToRoman(50));
                }
                compositeArabic %= 50;
                if (compositeArabic / 10 != 0) x = compositeArabic / 10;
                if (x <= 3) {
                    for (int count = 0; count < x; count++) {
                        roman.append(convertSingleArabicToRoman(10));
                    }
                } else {
                    roman.append(convertArabicToRoman(10)).append(convertArabicToRoman(50));
                }
                compositeArabic %= 10;
                if (compositeArabic == 9) {
                    roman.append(convertArabicToRoman(1)).append(convertArabicToRoman(10));
                } else {
                    if (compositeArabic / 5 != 0) v = compositeArabic / 5;
                    for (int count = 0; count < v; count++) {
                        roman.append(convertSingleArabicToRoman(5));
                    }
                    compositeArabic %= 5;

                    if (compositeArabic != 0) i = compositeArabic;
                    if (i <= 3) {
                        for (int count = 0; count < i; count++) {
                            roman.append(convertSingleArabicToRoman(1));
                        }
                    } else {
                        roman.append(convertArabicToRoman(1)).append(convertArabicToRoman(5));
                    }
                }
            }
        }
        return roman.toString();
    }
}
