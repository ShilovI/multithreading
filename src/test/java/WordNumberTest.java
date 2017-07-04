/**
 * Created by Administrator on 7/2/2017.
 */
public class WordNumberTest {
    public static void main(String[] args) {
        String testcase1 = "nine thousand nine hundred ninety nine";
        int result1 = WordToNumber.inNumerals(testcase1);
        System.out.println("Result inNumerals : "+result1);
        int testcase2 = 9999;
        String result2 = NumberToWord.inWords(testcase2);
        System.out.println("Result inWord : "+result2);
    }
}
