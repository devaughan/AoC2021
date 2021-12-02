import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Dive{
    public static void main(String[] args) {
        int horizontalPosition = 0;
        int depth = 0;

        try {
            File puzzleInput = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day2\\DivePuzzleInput.txt");
            Scanner input = new Scanner(puzzleInput);
            while (input.hasNextLine()) {
                String nextInput = input.next();
                if (nextInput.equals("forward")) {
                    horizontalPosition += input.nextInt();
                }
                else if (nextInput.equals("down")) {
                    depth = depth + input.nextInt();
                }
                else if (nextInput.equals("up")) {
                    depth = depth - input.nextInt();
                }
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        System.out.println(depth * horizontalPosition);
    }
}