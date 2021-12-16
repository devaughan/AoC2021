// https://adventofcode.com/2021/day/6
// Advent of Code 2021
// Day 6: Lanternfish

public class Lanternfish {
    public static void main(String[] args) {
        
        int dayNumber;
        int lastDay = 80;

        int[] fish = {4,2,4,1,5,1,2,2,4,1,1,2,2,2,4,4,1,2,1,1,4,1,2,1,2,2,2,2,5,2,2,3,1,4,4,4,1,2,3,4,4,5,4,3,5,1,2,5,1,1,5,5,1,4,4,5,1,3,1,4,5,5,5,4,1,2,3,4,2,1,2,1,2,2,1,5,5,1,1,1,1,5,2,2,2,4,2,4,2,4,2,1,2,1,2,4,2,4,1,3,5,5,2,4,4,2,2,2,2,3,3,2,1,1,1,1,4,3,2,5,4,3,5,3,1,5,5,2,4,1,1,2,1,3,5,1,5,3,1,3,1,4,5,1,1,3,2,1,1,1,5,2,1,2,4,2,3,3,2,3,5,1,5,1,2,1,5,2,4,1,2,4,4,1,5,1,1,5,2,2,5,5,3,1,2,2,1,1,4,1,5,4,5,5,2,2,1,1,2,5,4,3,2,2,5,4,2,5,4,4,2,3,1,1,1,5,5,4,5,3,2,5,3,4,5,1,4,1,1,3,4,4,1,1,5,1,4,1,2,1,4,1,1,3,1,5,2,5,1,5,2,5,2,5,4,1,1,4,4,2,3,1,5,2,5,1,5,2,1,1,1,2,1,1,1,4,4,5,4,4,1,4,2,2,2,5,3,2,4,4,5,5,1,1,1,1,3,1,2,1};
        /*
        System.out.print("Initial state: ");
        printArray(fish);
        System.out.println(); 
        */

        for (dayNumber = 1; dayNumber <= lastDay; dayNumber++) {
            fish = subtractArray(fish);
            /* System.out.print("After ");
            if (dayNumber / 10 == 0) {
                System.out.print(" ");
            }
            System.out.print(dayNumber + " ");
            if (dayNumber == 1) {
                System.out.print("day:  ");
            }
            else {
                System.out.print("days: ");
            }
            printArray(fish);
            System.out.println(); 
            */
        }


        System.out.println(fish.length);

    }

    public static int[] subtractArray(int[] array) {
        int newFish = 0;
        for (int index = 0; index < array.length; index++) {
            array[index]--;
            if (array[index] == -1) {

                // add new fish
                newFish++;
                array[index] = 6;

            }
        }

        array = addNewFish(array, newFish);

        return array;
    }

    public static int[] addNewFish(int[] array, int newFish) {
        int[] newArray = new int[array.length + newFish];
        // putting old array values into new array
        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }

        // adding new fish
        for (int index = array.length; index < newArray.length; index++) {
            newArray[index] = 8;
        }

        return newArray;
    }

    public static void printArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index]);
            if (index < array.length - 1) {
                System.out.print(",");
            }
        }
    }

}