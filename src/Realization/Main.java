package Realization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Main {

    public static void main(String[] args) {
        try {
            Tribit tribit = new Tribit("1100100100001111110110101010001000100001011010001100001000110100");
            System.out.println(tribit.countCheckSum());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
