import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryDiagnosticPart2 {
    public static void main(String[] args) {
        File puzzleInput = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day3\\BinaryDiagnosticPuzzleInput.txt");

        try {
            
            Scanner fileReader = new Scanner(puzzleInput);
            int numberOfLines = 0;
            
            
            String[] temp = new String[1];
            String[] diagnosticReport = new String[1];


            while (fileReader.hasNextLine()) {
                for (int i = 0; i < diagnosticReport.length; i++) {
                    temp[i] = diagnosticReport[i];
                }

                temp[numberOfLines] = fileReader.nextLine();

                numberOfLines++;
                diagnosticReport = temp;
                temp = new String[numberOfLines + 1];

            }
            
            String gamma = gammaRate(diagnosticReport);
            String epsilon = epsilonRate(diagnosticReport);
            int total = binaryToDecimal(gamma) * binaryToDecimal(epsilon);
            System.out.println(gamma + " * " + epsilon + " = " + total);

            fileReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    public static String gammaRate(String[] array) {
        int count = 0;
        outer:
        for (int i = 0; i < array[0].length(); i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].charAt(i) == '0') {
                    count++;
                }
            }
            if (array.length == 1) {
                break outer;
            }
            // store all 0s
            if (count > array.length / 2) {
                array = ratingValue(array, '0', i);
            }
            // store all 1s
            else {
                array = ratingValue(array, '1', i);
            }
            System.out.println("count: " + count + "\tlength: " + array.length + "\tgamma: " + array[0]);
            count = 0;
        }
        return array[0];
    }

    public static String epsilonRate(String[] array) {
        int count = 0;
        outer:
        for (int i = 0; i < array[0].length(); i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].charAt(i) == '0') {
                    count++;
                }
            }
            if (array.length == 1) {
                break outer;
            }
            if (count > array.length / 2) {
                array = ratingValue(array, '1', i);
            }
            else {
                array = ratingValue(array, '0', i);
            }
            System.out.println("count: " + count + "\tlength: " + array.length + "\tepsilon: " + array[0]);
            count = 0;
        }
        
        return array[0];
    }

    public static String[] ratingValue(String[] array, char binaryDigit, int index) {
        String[] temp = new String[1];
        String[] newArray = new String[1];
        int j = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].charAt(index) == binaryDigit) {
                for (int k = 0; k < newArray.length; k++) {
                    temp[k] = newArray[k];
                }
                temp[j] = array[i];
                j++;
                newArray = temp;
                temp = new String[j + 1];
            }
        }
        return newArray;
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(i) - '0') * Math.pow(2, (binary.length() - (i + 1)));
        }
        return decimal;
    }
}