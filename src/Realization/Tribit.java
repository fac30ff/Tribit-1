package Realization;

/**
 * Created by Polina on 05-Aug-15.
 */
public class Tribit {

    private String input;
    private int degree;
    private int triangles;
    private int segments;
    private int lines;

    public Tribit(String input) {
    }

    public int checkLength(String input) { //returns degree
        int length = input.length();
        int degree = 0;
        while (length % 4 == 0) {
            length >>= 2;
            degree++;
            if (length == 1) return degree;
        }
        return -1;
    }

    public String countCheckSum() {
        return "0";
    }
}
