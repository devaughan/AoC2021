import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryDiagnostic {
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
            String epsilon = epsilonRate(gamma);
            int total = binaryToDecimal(gamma) * binaryToDecimal(epsilon);
            System.out.println(gamma + " * " + epsilon + " = " + total);

            fileReader.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    public static String gammaRate(String[] array) {
        String gamma = "";
        int count = 0;
        for (int i = 0; i < array[0].length(); i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].charAt(i) == '0') {
                    count++;
                }
            }
            if (count > array.length / 2) {
                gamma = gamma.concat("0");
            }
            else {
                gamma = gamma.concat("1");
            }
            System.out.println("count: " + count + "\tlength: " + array.length + "\tgamma: " + gamma);
            count = 0;
        }
        return gamma;
    }

    public static String epsilonRate(String gamma) {
        String epsilon = "";
        for (int i = 0; i < gamma.length(); i++) {
            if (gamma.charAt(i) == '0') {
                epsilon = epsilon.concat("1");
            }
            else {
                epsilon = epsilon.concat("0");
            }
        }
        return epsilon;
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(i) - '0') * Math.pow(2, (binary.length() - (i + 1)));
        }
        return decimal;
    }
}