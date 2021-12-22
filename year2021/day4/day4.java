import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        System.out.println("Part 1: " + part1());
        // System.out.println("Part 2: " + part2());
    }

    public static int part1() {
        int winningScore = 0;
        
        int[] numbers = readNumbers();
        ArrayList<ArrayList<Integer>> bingoBoards = readBoards();

        int iteration = 0;

        mainloop:
        for(int num : numbers) {
            iteration++;

            for(int i = 0; i < bingoBoards.size(); i++) {
                ArrayList<Integer> currentBoard = bingoBoards.get(i);
                
                if(currentBoard.contains(num)) {
                    currentBoard.set(currentBoard.indexOf(num), -1);
                }

                if(iteration >= 5) { // minimum of 5 draws to win
                    if(checkBoardForWin(currentBoard)) {
                        printBoard(currentBoard);
                        winningScore = calculateScore(currentBoard, num);
                        break mainloop;
                    }
                }
            }
        }

        return winningScore;
    }

    public static int part2() {
        return 0;
    }

    public static int[] readNumbers() {
        int[] numbers = null;

        try{
            File file = new File("year2021/day4/day4.txt");
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);

            String line = reader.readLine();
            
            numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();

            reader.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return numbers;
    }

    public static ArrayList<ArrayList<Integer>> readBoards() {
        ArrayList<ArrayList<Integer>> boards = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> currentBoard = new ArrayList<>();
        
        try{
            File file = new File("year2021/day4/day4.txt");
            Scanner sc = new Scanner(file);

            sc.nextLine();
            sc.nextLine();

            while(sc.hasNextLine()) {
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 5; j++) {
                        currentBoard.add(sc.nextInt());
                    }
                }

                boards.add(currentBoard);
                
                currentBoard = new ArrayList<>();
                sc.nextLine();
            }

            // System.out.println("Boards: " + boards.toString());
            sc.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return boards;
    }

    public static void printBoard(ArrayList<Integer> board) {
        for(int i = 0; i < 25; i += 5) {
            System.out.print("|");
            System.out.print(board.get(i) + " ");
            System.out.print(board.get(i + 1) + " ");
            System.out.print(board.get(i + 2) + " ");
            System.out.print(board.get(i + 3) + " ");
            System.out.println(board.get(i + 4));
        }
    }

    public static boolean checkBoardForWin(ArrayList<Integer> board) {
        for(int i = 0; i < 25; i += 5) {
            if(board.get(i) == -1 && 
               board.get(i + 1) == -1 &&
               board.get(i + 2) == -1 &&
               board.get(i + 3) == -1 &&
               board.get(i + 4) == -1)
                return true;
        }

        for(int i = 0; i < 5; i++) {
            if(board.get(i) == -1 && 
               board.get(i + 5) == -1 &&
               board.get(i + 10) == -1 &&
               board.get(i + 15) == -1 &&
               board.get(i + 20) == -1)
                return true;
        }

        return false;
    }

    public static int calculateScore(ArrayList<Integer> board, int num) {
        int score = 0;

        for(int x : board) {
            if(x != -1)
                score += x;
        }

        return score * num;
    }
}
