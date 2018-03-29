import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        Pattern pattern =Pattern.compile("[$_A-Za-z]+");
        System.out.println(pattern.matcher("$$").matches());
    }
}
