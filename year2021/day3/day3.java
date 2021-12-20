import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class day3 {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int powerConsumption = 0;
        
        try{
            File file = new File("year2021/day3/day3.txt");
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);

            String line = reader.readLine();
            int numBits = line.length();
            int numRecords = 0;
            int[] tracker = new int[numBits];

            while(line != null) {
                numRecords++;

                for(int i = 0; i < numBits; i++) {
                    tracker[i] += Integer.parseInt(String.valueOf(line.charAt(i)));
                }

                line = reader.readLine();
            }
            // System.out.println(Arrays.toString(tracker));
            StringBuilder gamma = new StringBuilder(numBits);
            StringBuilder epsilon = new StringBuilder(numBits);

            for(int j = 0; j < numBits; j++) {
                if(tracker[j] > (numRecords / 2)) {
                    gamma.append("1");
                    epsilon.append("0");
                } else {
                    gamma.append("0");
                    epsilon.append("1");
                }
            }

            // System.out.println(gamma.toString());
            // System.out.println(epsilon.toString());

            powerConsumption = Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);

            reader.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return powerConsumption;
    }

    public static int part2() {
        return 0;
    }
}
