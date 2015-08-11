package Realization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Polina on 05-Aug-15.
 */
public class Tribit {

    private String changeable;
    private int degree;            //would need to rethink about needed variables
    private int triangles;
    private int segments;
    private int lines;
    private List<Segment> segmentsList = new ArrayList<Segment>();


    public Tribit() {
    } //Default constructor used for tests.

    public Tribit(String input) throws Exception {
        changeable = new StringBuilder(input).reverse().toString(); //My logic bases on reversed representation of input.
        degree = checkLength(changeable);
        if (degree == -1) throw new Exception("Wrong input length"); //need to add special exception for wrong input
        triangles = changeable.length() / 4;
        System.out.println("Triangles = " + triangles + ", string " + changeable);
        segments = segmentsCounter(triangles);
        lines = segments * 2;
        constructTribit();
    }

    public List<Segment> getSegmentsList() {
        return segmentsList;
    }

    public int getTriangles() {
        return triangles;
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

    public int segmentsCounter(int triangles) { //as we set triangles, no need to check amount
        int segments = 0;
        int temp = 1;
        while (triangles > 0) {
            triangles -= temp;
            temp += 2;
            segments++;
        }
        return segments;
    }

    public void constructTribit() {       //begin inclusive, end exclusive (for substring)
        int end = 1; // Variable to count amount bits in every line. Every next line increases by 2.
        int start = 0; // Variable for setting boundaries for line separating.
        int step = 3;
        String line1, line2;
        Segment temp;
        for (int i = 1; i <= segments; i++) {
            line1 = changeable.substring(start, end);
            start = end;
            end += step;
            step +=2;
            line2 = changeable.substring(start, end);
            start = end;
            end += step;
            step +=2;
            temp = new Segment(line1, line2, i);
            segmentsList.add(temp);
        }
    }

    public Tribit reconstructTtibit() { //will fail if there's only one triangle in a row but may be handled in exception
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < segmentsList.size(); i++) {
            resultString.append(segmentsList.get(i).permutateSegment());
        }
        Tribit tribit = null;
        resultString.reverse();
        try {
            tribit = new Tribit(resultString.toString());
        } catch (Exception e) {
            System.out.println("Recreation failed because of length problems");
            e.printStackTrace();
        }
        return tribit;
    }

    public String countCheckSum() {
        Tribit temp = this;
        while (true) {
            if (temp.getTriangles() == 1) {
                System.out.println("Last Segment " + temp.getSegmentsList().get(0));
                return temp.getSegmentsList().get(0 ).permutateSegment();
            }
            System.out.println("Intermediate Segment " + temp.getSegmentsList());
            temp = temp.reconstructTtibit();
        }
    }
}
