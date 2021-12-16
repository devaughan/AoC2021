import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GiantSquidPart2 {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int answer;
        int totalBingos = 0;
        int numberOfBingoBoards = 100;

        //int[] drawOrder = {7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1};
        int[] drawOrder = {28,82,77,88,95,55,62,21,99,14,30,9,97,92,94,3,60,22,18,86,78,71,61,43,79,33,65,81,26,49,47,51,0,89,57,75,42,35,80,1,46,83,39,53,40,36,54,70,76,38,50,23,67,2,20,87,37,66,84,24,98,4,7,12,44,10,29,5,48,59,32,41,90,17,56,85,96,93,27,74,45,25,15,6,69,16,19,8,31,13,64,63,34,73,58,91,11,68,72,52};

        int[] array = new int[25];
        BingoBoard[] boards = new BingoBoard[numberOfBingoBoards];

        File file = new File("C:\\Users\\devau\\OneDrive\\Documents\\Coding\\AdventOfCode\\2021\\Day4\\GiantSquidPuzzleInput.txt");

        try {
            Scanner input = new Scanner(file);

            int arrayIndex = 0;
            int boardIndex = 0;
            BingoBoard bingo;

            // filling the BingoBoard array
            while (input.hasNextLine()) {

                array[arrayIndex] = input.nextInt();

                arrayIndex++;

                if (arrayIndex == 25) {

                    bingo = new BingoBoard(array);

                    boards[boardIndex] = bingo;
                    arrayIndex = 0;
                    boardIndex++;
                }
            }

            input.close();

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int x = 0;
        int i = 0;

        outer:
        for (x = 0; x < drawOrder.length; x++) {
            System.out.print(drawOrder[x] + " ");
            for (i = 0; i < boards.length; i++) {
                while (boards[i].getBingo()) {
                    i++;
                    if (i == boards.length) {
                        x++;
                        i = 0;
                    }
                }
                if (boards[i].setClear(drawOrder[x])) {
                    totalBingos++;
                    if (totalBingos == numberOfBingoBoards) {
                        break outer;
                    }
                }
            }
        }
        
        System.out.println();

        System.out.print(boards[i].sumOfUnmarkedNumbers() + " * " + drawOrder[x] + " = ");
        
        answer = boards[i].sumOfUnmarkedNumbers() * drawOrder[x];
        System.out.println(answer);

        long totalTime = (System.nanoTime() - startTime);
        //System.out.println(totalTime);
    
    }
}