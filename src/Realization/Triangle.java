package Realization;

/**
 * Created by Polina on 09-Aug-15.
 */
public class Triangle {

    private String firstBit;
    private String lastBits;
    private int entrails;

    public Triangle(String firstBit, String lastBits) {
        this.firstBit = firstBit;
        this.lastBits = lastBits;
        entrails = Integer.valueOf(firstBit + lastBits,2);
    }

    public void setFirstBitAndLastBitsByEntrails() {
        String temp = Integer.toBinaryString(entrails);
        firstBit = temp.substring(0, 1);
        lastBits = temp.substring(1);

    }

    public String getFirstBit() {
        return firstBit;
    }

    public String getLastBits() {
        return lastBits;
    }

    public void permutate() throws Exception {
        while (true) {
            if (entrails == 0) return;
            if (entrails == 15) return;
            entrails = permutation(entrails);
            setFirstBitAndLastBitsByEntrails();
        }
    }

    public int permutation(int start) throws Exception {
        switch (start) {
            case 0:
                return 0;
            case 1:
                return 8;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 0;
            case 5:
                return 2;
            case 6:
                return 11;
            case 7:
                return 11;
            case 8:
                return 4;
            case 9:
                return 5;
            case 10:
                return 7;
            case 11:
                return 15;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 7;
            case 15:
                return 15;
            default:
                throw new Exception("Wront input parameter to permutate");
        }
    }

    @Override
    public String toString() {
        return firstBit + lastBits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (entrails != triangle.entrails) return false;
        if (!firstBit.equals(triangle.firstBit)) return false;
        return lastBits.equals(triangle.lastBits);

    }

    @Override
    public int hashCode() {
        int result = firstBit.hashCode();
        result = 31 * result + lastBits.hashCode();
        result = 31 * result + entrails;
        return result;
    }
}
