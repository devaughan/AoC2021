import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SevenSegmentSearch {
    public static void main(String[] args) {

        int one = 2;
        int four = 4;
        int seven = 3;
        int eight = 7;

        int[] easyDigits = {one, four, seven, eight};
        
        int sum = 0;

        File puzzleInput = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day8\\SevenSegmentSearchPuzzleInput.txt");
        
        try {
            Scanner input = new Scanner(puzzleInput);

            while(input.hasNextLine()) {
                if (input.next().equals("|")) {
                    String digit1 = input.next();
                    String digit2 = input.next();
                    String digit3 = input.next();
                    String digit4 = input.next();
                    String[] screenOutput = {digit1, digit2, digit3, digit4};
                    for (int outputIndex = 0; outputIndex < 4; outputIndex++) {
                        for(int index = 0; index < easyDigits.length; index++) {
                            if (screenOutput[outputIndex].length() == easyDigits[index]) {
                                sum++;
                                break;
                            }
                        }
                    }
                    
                }
            }

            input.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
        System.out.println(sum);

    }
}