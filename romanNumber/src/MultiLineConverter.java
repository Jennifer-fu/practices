public class MultiLineConverter {

    public String convert(String input) {
        String[] numbers = input.split("\\n");
        StringBuffer output = new StringBuffer();
        for (String number : numbers) {
            if (isValidArabic(number)) {
                output.append(new RomanNumber(Integer.parseInt(number)).toString()).append("\n");
            } else if (isRoman(number)) {
                output.append(new RomanNumber(number).convertToArabic()).append("\n");
            } else {
                output.append("N/A").append("\n");
            }
        }
        String outputString = output.toString();
        return outputString.substring(0,outputString.lastIndexOf('\n'));
    }

    private boolean isRoman(String number) {
        //not very strong
        for(char ch:number.toCharArray()){
            if("IVXLCDM".indexOf(ch)==-1)return false;
        }
        return true;
    }

    private boolean isValidArabic(String number) {
        if(number.charAt(0)>51)return false;
        for(char ch:number.toCharArray()){
            if(ch>57||ch<48)return false;
        }
        return true;
    }
}
