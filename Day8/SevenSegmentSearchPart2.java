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
                String nine = input.next();

                String[] uniqueSignal = {zero, one, two, three, four, five, six, seven, eight, nine};
                String[] signalSorted = new String[10];
                
                // find easy numbers
                for (String i : uniqueSignal) {
                    // i = 1
                    if (i.length() == 2) {
                        signalSorted[1] = i;
                    }
                    // i = 7
                    else if (i.length() == 3) {
                        signalSorted[7] = i;
                    }
                    // i = 4
                    else if (i.length() == 4) {
                        signalSorted[4] = i;
                    }
                    // i = 8
                    else if (i.length() == 7) {
                        signalSorted[8] = i;
                    }
                }

                for (String i : uniqueSignal) {
                    if (i.length() == 6) {
                        // i = 6
                        if (!containsAllLetters(i, signalSorted[1])) {
                            signalSorted[6] = i;
                        }
                        // i = 9
                        else if (containsAllLetters(i, signalSorted[4])) {
                            signalSorted[9] = i;
                        }
                        // i = 0
                        else {
                            signalSorted[0] = i;
                        }
                    }
                    else if (i.length() == 5) {
                        // i = 3
                        if (containsAllLetters(i, signalSorted[1])) {
                            signalSorted[3] = i;
                        }
                        // i = 5
                        else if (numberOfSharedSides(i, signalSorted[4]) == 3) {
                            signalSorted[5] = i;
                        }
                        // i = 2
                        else {
                            signalSorted[2] = i;
                        }
                    }
                }

                // | deliminator
                input.next();
                

                String digit1 = input.next();
                String digit2 = input.next();
                String digit3 = input.next();
                String digit4 = input.next();

                String[] screenOutput = {digit1, digit2, digit3, digit4};

                for (int index = 0; index < screenOutput.length; index++) {
                    for (int count = 0; count < signalSorted.length; count++) {
                        if (exactCopy(screenOutput[index], signalSorted[count])) {
                            sum += Math.pow(10, 3 - index) * count;
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

    public static boolean containsAllLetters(String mainString, String smallString) {
        boolean hasLetters;
        for (int smallIndex = 0; smallIndex < smallString.length(); smallIndex++) {
            hasLetters = false;
            for (int mainIndex = 0; mainIndex < mainString.length(); mainIndex++) {
                if (smallString.charAt(smallIndex) == mainString.charAt(mainIndex)) {
                    hasLetters = true;
                    break;
                }
            }
            if (!hasLetters) {
                return false;
            }
        }
        return true;
    }

    public static boolean exactCopy(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        boolean hasLetters;
        for (int smallIndex = 0; smallIndex < string2.length(); smallIndex++) {
            hasLetters = false;
            for (int mainIndex = 0; mainIndex < string1.length(); mainIndex++) {
                if (string2.charAt(smallIndex) == string1.charAt(mainIndex)) {
                    hasLetters = true;
                    break;
                }
            }
            if (!hasLetters) {
                return false;
            }
        }
        return true;
    }

    public static int numberOfSharedSides(String string1, String string2) {
        int sum = 0;
        for (int i = 0; i < string1.length(); i++) {
            for (int j = 0; j < string2.length(); j++) {
                if (string1.charAt(i) == string2.charAt(j)) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
