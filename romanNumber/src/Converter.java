import java.util.HashMap;

public class Converter {
    private final HashMap<Integer,String> arabicToRoman = new HashMap<Integer,String>(){
        {
            put(1,"I");
            put(5,"V");
            put(10,"X");
            put(50,"L");
            put(100,"C");
            put(500,"D");
            put(1000,"M");
        }
    };

    private final HashMap<String,Integer> romanToArabic = new HashMap<String,Integer>(){
        {
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
        }
    };
    public String convertArabicToRoman(int arabicNum) {
        return arabicToRoman.get(arabicNum);
    }

    public int convertRomanToArabic(String romanNum) {
        return romanToArabic.get(romanNum);
    }
}
