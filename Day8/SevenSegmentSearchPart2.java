import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SevenSegmentSearchPart2 {
    public static void main(String[] args) {

        char[] baseDigit = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        
        int sum = 0;

        File puzzleInput = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day8\\SevenSegmentSearchPuzzleInput.txt");
        
        try {
            Scanner input = new Scanner(puzzleInput);

            while(input.hasNextLine()) {

                String zero = input.next();
                String one = input.next();
                String two = input.next();
                String three = input.next();
                String four = input.next();
                String five = input.next();
                String six = input.next();
                String seven = input.next();
                String eight = input.next();

                String[] uniqueSignal = {zero, one, two, three, four, five, six, seven, eight};
                
                for (String i : uniqueSignal) {
                    // i = 1
                    if (i.length() == 2) {
                        uniqueSignal[1] = i;
                    }
                    // i = 7
                    else if (i.length() == 3) {
                        uniqueSignal[7] = i;
                    }
                    // i = 4
                    else if (i.length() == 4) {
                        uniqueSignal[4] = i;
                    }
                    // i = 8
                    else if (i.length() == 7) {
                        uniqueSignal[8] = i;
                    }
                }



                if (input.next().equals("|")) {

                    String digit1 = input.next();
                    String digit2 = input.next();
                    String digit3 = input.next();
                    String digit4 = input.next();
                    String[] screenOutput = {digit1, digit2, digit3, digit4};

                    for (int outputIndex = 0; outputIndex < 4; outputIndex++) {
                        for(int index = 0; index < digits.length; index++) {
                            if (screenOutput[outputIndex].length() == digits[index]) {
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

    public static String compare(String smallString, String largeString) {
        String s = "";
        for (int index = 0; index < largeString.length(); index++) {
            for (int i = 0; i < smallString.length(); i++) {
                if (largeString.charAt(index) != smallString.charAt(i)) {
                }
            }
        }   
        return 
    }

}