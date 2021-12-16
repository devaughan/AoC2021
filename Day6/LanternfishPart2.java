// https://adventofcode.com/2021/day/6
// Advent of Code 2021
// Day 6: Lanternfish

public class LanternfishPart2 {
    public static void main(String[] args) {
        
        int days;
        int lastDay = 256;
        double answer = 0;

        double[] initialArray = {4,2,4,1,5,1,2,2,4,1,1,2,2,2,4,4,1,2,1,1,4,1,2,1,2,2,2,2,5,2,2,3,1,4,4,4,1,2,3,4,4,5,4,3,5,1,2,5,1,1,5,5,1,4,4,5,1,3,1,4,5,5,5,4,1,2,3,4,2,1,2,1,2,2,1,5,5,1,1,1,1,5,2,2,2,4,2,4,2,4,2,1,2,1,2,4,2,4,1,3,5,5,2,4,4,2,2,2,2,3,3,2,1,1,1,1,4,3,2,5,4,3,5,3,1,5,5,2,4,1,1,2,1,3,5,1,5,3,1,3,1,4,5,1,1,3,2,1,1,1,5,2,1,2,4,2,3,3,2,3,5,1,5,1,2,1,5,2,4,1,2,4,4,1,5,1,1,5,2,2,5,5,3,1,2,2,1,1,4,1,5,4,5,5,2,2,1,1,2,5,4,3,2,2,5,4,2,5,4,4,2,3,1,1,1,5,5,4,5,3,2,5,3,4,5,1,4,1,1,3,4,4,1,1,5,1,4,1,2,1,4,1,1,3,1,5,2,5,1,5,2,5,2,5,4,1,1,4,4,2,3,1,5,2,5,1,5,2,1,1,1,2,1,1,1,4,4,5,4,4,1,4,2,2,2,5,3,2,4,4,5,5,1,1,1,1,3,1,2,1};
        double[] fish = new double[9];


        fish = convertArray(initialArray);

        for (days = 0; days < lastDay; days++) {
            fish = dayPasses(fish);
        }
        
        for (int index = 0; index < fish.length; index++) {
            answer += fish[index];
        }

        System.out.printf("%.0f\n",answer);

    }

    // creates a new array of size 9 that counts the number of fish that are in each day 
    // this way it only has to account for the number of fish in each state rather than every individual fish
    public static double[] convertArray(double[] array) {
        double[] newArray = new double[9];
        for (int index = 0; index < array.length; index++) {
            newArray[(int)array[index]]++;
        }

        return newArray;
    }

    // method used to calculate the number of fish after each new day
    public static double[] dayPasses(double[] array) {
        double[] newArray = new double[array.length];

        for (int index = 0; index < array.length; index++) {
            // for fish at index 0 their timer resets to 6
            // all their children get added to index 8
            if (index == 0) {
                newArray[6] = array[0];
                newArray[8] = array[0];
            }
            // adds all other fish to 1 less than their previous index
            else {
                newArray[index - 1] += array[index];
            }
        }
        return newArray;
    }

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
