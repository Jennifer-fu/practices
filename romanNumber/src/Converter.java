import java.util.HashMap;

public class Converter {
    private final HashMap<Integer,String> numMap = new HashMap<Integer,String>(){
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
    public String convert(int arabicNum) {
        return numMap.get(arabicNum);
    }
}
