/**
 * Created by Administrator on 7/1/2017.
 */
public class NumberToWord {

    public static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public static final String[] tens = {
            "",        // 0
            "",        // 1
            "twenty",  // 2
            "thirty",  // 3
            "forty",   // 4
            "fifty",   // 5
            "sixty",   // 6
            "seventy", // 7
            "eighty",  // 8
            "ninety"   // 9
    };

    public static String inWords(int n) {
        String result = "";
        if (n < 20) {
            result = result + units[n];
        } else if (n < 100) {
            result = result + tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        } else if (n < 1000) {
            result = result + units[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + inWords(n % 100);
        } else {
            result = result + inWords(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + inWords(n % 1000);
        }
        return result;
    }
}

