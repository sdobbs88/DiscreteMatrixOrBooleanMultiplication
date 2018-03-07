/**
* Class: CSCI2625 Discrete Structures -- Section 001
* Instructor: Dr. Hong Zhang
* Description: Given a matrix input, the program will perform matrix multiplication
* and produce a boolean matrix product. 
* Due: 10/12/2016
* @author Shaun C. Dobbs
* @version 1.0
*/
import java.util.Scanner;

public class Project6 {

    public static void main(String[] args) {
        //Create scanner
        Scanner s = new Scanner(System.in);

        int row0, column0, row1, column1, choice;

        System.out.println("Press 0 and then enter for matrix multiplication. Press 1 and then enter for boolean matrix multiplication: ");
        choice = s.nextInt();

        if (choice == 0) {
            System.out.println("Enter number of rows for matrix 1: ");
            row0 = s.nextInt();
            System.out.println("Enter number of columns for matrix 1: ");
            column0 = s.nextInt();
            System.out.println("Enter number of rows for matrix 2: ");
            row1 = s.nextInt();
            System.out.println("Enter number of columns for matrix 2: ");
            column1 = s.nextInt();

            double[][] a = new double[row0][column0];
            double[][] b = new double[row1][column1];

            //Prompt matrix 1 to be entered
            System.out.print("Enter matrix 1 a row at a time: ");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = s.nextDouble();
                }
            }

            //Prompt matrix 2 to be entered
            System.out.print("Enter matrix 2 a row at a time: ");
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    b[i][j] = s.nextDouble();
                }
            }
            double[][] matrixProduct = matrixProduct(a, b);

            System.out.println("Solution: ");
            for (int i = 0; i < matrixProduct.length; i++) {
                for (int j = 0; j < matrixProduct[0].length; j++) {
                    System.out.print(matrixProduct[i][j] + " ");
                }
                System.out.println();
            }

        } else {

            System.out.println("Enter number of rows for matrix 1: ");
            row0 = s.nextInt();
            System.out.println("Enter number of columns for matrix 1: ");
            column0 = s.nextInt();
            System.out.println("Enter number of rows for matrix 2: ");
            row1 = s.nextInt();
            System.out.println("Enter number of columns for matrix 2: ");
            column1 = s.nextInt();

            int[][] a = new int[row0][column0];
            int[][] b = new int[row1][column1];

            //Prompt matrix 1 to be entered
            System.out.print("Enter matrix 1 a row at a time: ");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] = s.nextInt();
                }
            }

            //Prompt matrix 2 to be entered
            System.out.print("Enter matrix 2 a row at a time: ");
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    b[i][j] = s.nextInt();
                }
            }

            int[][] booleanMatrixProduct = booleanMatrixProduct(a, b);

            System.out.println("Solution: ");
            for (int i = 0; i < booleanMatrixProduct.length; i++) {
                for (int j = 0; j < booleanMatrixProduct[0].length; j++) {
                    System.out.print(booleanMatrixProduct[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    //Calculate matrix product and send double array back to main to be printed
    public static double[][] matrixProduct(double[][] a, double[][] b) {

        double[][] newMatrix = new double[a.length][b[0].length];
        double sum = 0;

        for (int t = 0; t < a.length; t++) {
            for (int i = 0; i < b[0].length; i++) {
                for (int j = 0; j < b.length; j++) {
                    sum += (a[t][j] * b[j][i]);
                }
                newMatrix[t][i] = sum;
                sum = 0;
            }
        }
        return newMatrix;
    }

    //Calculate boolean matrix product and send int array back to main to be printed
    public static int[][] booleanMatrixProduct(int[][] a, int[][] b) {
        int[][] newMatrix = new int[a.length][b[0].length];

        int count = 0;
        
        for (int t = 0; t < a.length; t++) {
            for (int i = 0; i < b[0].length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (a[t][j] == 1 && b[j][i] == 1) {
                        count++;
                    } else if (a[t][j] == 0 && b[j][i] == 0) {
                        count++;
                    }
                }
                if (count >= 1) {
                    newMatrix[t][i] = 1;
                } else {
                    newMatrix[t][i] = 0;
                }
                count = 0;
            }
        }
        return newMatrix;
    }
}
