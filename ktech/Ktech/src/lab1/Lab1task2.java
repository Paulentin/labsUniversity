package lab1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab1task2 {
    public static void massProc(int n) {
        int[][] matrix = new int[n + 15][n + 15];
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * ((n + 15 + 1) - (-n - 15)) + (-n - 15));
            }
        }
        System.out.println("Generated mass");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        //sort
        for (int i = 0; i < matrix[0].length; i++) {
            if (i % 2 != 0) {
                Arrays.sort(matrix[i]);
            }
        }

        System.out.println();
        System.out.println("Sorted array:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.format("%-3d     ", matrix[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Lab1task2.massProc(1);
    }
}
