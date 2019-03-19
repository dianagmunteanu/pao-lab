import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
    Source:
    https://www.vogella.com/tutorials/JavaRegularExpressions/article.html#pattern-and-matcher
 */
public class RegexTestPatternMatcher {
    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
        // now create a new pattern and matcher to replace whitespace with tabs
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        String resultedString = matcher2.replaceAll("\t");
        System.out.println(resultedString);
        System.out.println(resultedString.replace("\t", "\n"));
        System.out.println(EXAMPLE_TEST);
    }
}
