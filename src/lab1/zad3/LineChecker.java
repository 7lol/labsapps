package lab1.zad3;

/**
 * Created by 7_lol_000 on 2015-10-21.
 */
public class LineChecker {

    boolean isComment, isEmpty, hasOnlyBrackets, startsComment;

    public void reset() {
        startsComment = false;
        isComment = false;
        isEmpty = false;
        hasOnlyBrackets = false;
    }

    public void checkLine(String line) {
        line = line.replaceAll("\\s", "");
        checkIfEmpty(line);
        checkIfComment(line);
        checkIfBrackets(line);
    }

    private void checkIfEmpty(String line) {
        isEmpty = line.isEmpty();
    }

    private void checkIfBrackets(String line) {
        if ((!line.contains("{")) || ((line.split("\\{").length > 0))) {
            hasOnlyBrackets = !((!line.contains("}")) || ((line.split("\\}").length > 0)));
        } else {
            hasOnlyBrackets = true;
        }
    }

    public void checkIfComment(String line) {
        if ((!line.contains("//")) || (line.split("//").length > 0 && line.split("//")[0].length() != 0)) {
            isComment = !((!line.contains("/*")) || (line.split("/\\*").length > 0 && line.split("/\\*")[0].length() != 0));
        } else isComment = true;
        if (line.contains("/*")) {
            startsComment = true;
        }
        if (line.contains("*/")) {
            startsComment = false;
            isComment = true;
        }
    }
}
