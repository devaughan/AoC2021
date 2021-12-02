import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DivePart2 {
    public static void main(String[] args) {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        try {
            File puzzleInput = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day2\\DivePuzzleInput.txt");
            Scanner input = new Scanner(puzzleInput);
            while (input.hasNextLine()) {
                String nextInput = input.next();
                if (nextInput.equals("forward")) {
                    int forward = input.nextInt();
                    horizontalPosition += forward;
                    depth += aim * forward;
                }
                else if (nextInput.equals("down")) {
                    aim += input.nextInt();
                }
                else if (nextInput.equals("up")) {
                    aim -= input.nextInt();
                }
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        System.out.println("depth: " + depth);
        System.out.println("horizontalPosition: " + horizontalPosition); 
        System.out.println(depth * horizontalPosition);
    }
}