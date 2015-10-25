package lab1.zad3;

/**
 * Created by 7_lol_000 on 2015-10-24.
 */
public class LinesCounter {
    boolean allowEmptyLines, allowBrackets;
    int count = 0;

    public void checkIfCounts(LineChecker checker) {
        if (!checker.isEmpty || allowEmptyLines) {
            if (!checker.isComment) {
                if (!checker.startsComment)
                    if (!checker.hasOnlyBrackets || allowBrackets)
                        count++;
            }
        }
    }

    public int sum() {
        return count;
    }

    public void setAllowEmptyLines(boolean value) {
        allowEmptyLines = value;
    }

    public void setAllowBrackets(boolean value) {
        allowBrackets = value;
    }
}
