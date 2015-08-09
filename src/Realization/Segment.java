package Realization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Polina on 09-Aug-15.
 */
public class Segment {


    private String line1;
    private String line2;
    private List<Triangle> triangles = new ArrayList<Triangle>();
    private int amountOfTriangles; //in segment

    public Segment(String line1, String line2, int number) {
        this.line1 = line1;
        this.line2 = line2;
        amountOfTriangles = number * 2 - 1; // Arithmetic progression formula.
        constructSegment();
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }

    public void constructSegment() { //let's pretend it really works %)
        int startForLine1 = 0;
        int endForLine1 = 1;
        int startForLine2 = 0;
        int endForLine2 = 3;
        String upper, lower;
        Triangle temp;
        for (int i = 1; i <= amountOfTriangles; i++) {
            if (i == amountOfTriangles) {
                upper = line1.substring(startForLine1);
                lower = line2.substring(startForLine2);
                temp = new Triangle(upper, lower);
            } else {
                if (i % 2 == 1) {
                    upper = line1.substring(startForLine1, endForLine1);
                    lower = line2.substring(startForLine2, endForLine2);
                    startForLine1 = endForLine1;
                    endForLine1 += 3;
                    startForLine2 = endForLine2;
                    endForLine2 += 1;
                    temp = new Triangle(upper, lower);
                } else {
                    upper = line1.substring(startForLine1, endForLine1);
                    lower = line2.substring(startForLine2, endForLine2);
                    startForLine1 = endForLine1;
                    endForLine1 += 1;
                    startForLine2 = endForLine2;
                    endForLine2 += 3;
                    temp = new Triangle(lower, upper);
                }
            }
            triangles.add(temp);
        }
    }

    public String permutateSegment() { //returns String of bits instead segment of Triangles
        StringBuilder result = new StringBuilder();
        Triangle temp;
        for (int i = 0; i < triangles.size(); i++) {
            temp = triangles.get(i);
            try {
                temp.permutate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.append(temp.getFirstBit());
        }
        return result.toString();
    }

}
