import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

public class day1 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int numberIncreasing = 0;

        try {
            File file = new File("year2021/day1/day1.txt");
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);
            
            String lastLine = reader.readLine();
            String line = reader.readLine();
            
            while(line != null) {
                if(Integer.parseInt(line) > Integer.parseInt(lastLine))
                    numberIncreasing++;
                
                lastLine = line;
                line = reader.readLine();
            }

            reader.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return numberIncreasing;
    }

    public static int part2() {
        int x = 0;

        return x;
    }
}
