import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class day1 {
    public static void main(String[] args) {
        int[] numbers = readFile();

        System.out.println(part1(numbers));
        System.out.println(part2(numbers));
    }
    
    public static int[] readFile() {
        List<Integer> numbers = new ArrayList<>();

        try{
            File file = new File("year2021/day1/day1.txt");
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);

            String line = reader.readLine();

            while(line != null) {
                numbers.add(Integer.parseInt(line));
                
                line = reader.readLine();
            }

            reader.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return numbers.stream().mapToInt(x -> x).toArray();
    }

    public static int part1(int[] numbers) {
        int numberIncreasing = 0;

        for(int i = 0; i < numbers.length-1; i++) {
            if(numbers[i] < numbers[i+1])
                numberIncreasing++;
        }

        return numberIncreasing;
    }

    public static int part2(int[] numbers) {
        int numberIncreasing = 0;

        for(int i = 0; i < numbers.length - 3; i++) {
            int set1Sum = numbers[i] + numbers[i+1] + numbers[i+2];
            int set2Sum = numbers[i+1] + numbers[i+2] + numbers[i+3];

            if(set1Sum < set2Sum)
                numberIncreasing++;
        }

        return numberIncreasing;
    }
}
