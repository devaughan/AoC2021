// Advent Of Code 2021
// Day 5: Hydrothermal Venture
// https://adventofcode.com/2021/day/5

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HydrothermalVenturePart2 {
    public static void main(String[] args) {
        int width = 1000;
        int length = 1000;
        int[][] array = new int[width][length];
        File puzzleInput = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day5\\HydrothermalVenturePuzzleInput.txt");

        try {
            Scanner input = new Scanner(puzzleInput);
            
            while (input.hasNextLine()) {

                int[][] vector = new int[2][2];

                // this will break with new input 
                // fix

                vector[0][0] = input.nextInt();
                vector[0][1] = input.nextInt();
                vector[1][0] = input.nextInt();
                vector[1][1] = input.nextInt();

                int smallerX = Math.min(vector[0][0], vector[1][0]);
                int largerX = Math.max(vector[0][0], vector[1][0]);
                int smallerY = Math.min(vector[0][1], vector[1][1]);
                int largerY = Math.max(vector[0][1], vector[1][1]);

                //System.out.println(vector[0][0] + "," + vector[0][1] + " -> " + vector[1][0] + "," + vector[1][1]);

                // horizontal line
                if (vector[0][0] == vector[1][0]) { 
                    for (int i = smallerY; i <= largerY; i++) {
                        array[i][vector[0][0]]++;
                    }
                }
                // vertical line
                else if (vector[0][1] == vector[1][1]) {
                    for (int i = smallerX; i <= largerX; i++) {
                        array[vector[0][1]][i]++;
                    }
                }
                // diagonal line
                else {
                    int xDifference = vector[0][0] - vector[1][0];
                    int xIncrement = xDifference / Math.abs(xDifference);
                    int yDifference = vector[0][1] - vector[1][1];
                    int yIncrement = yDifference / Math.abs(yDifference);

                    for (int x = vector[0][0], y = vector[0][1]; ; x-=xIncrement, y-=yIncrement) {
                        array[y][x]++;
                        if (x == vector[1][0]) 
                            break;
                    }
                }
                //print(array);
                //System.out.println();
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file does not exist");
        }

        // print(array);

        System.out.println("answer: " + answer(array));

    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 0) {
                    System.out.print(".");
                }
                else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static int answer(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}