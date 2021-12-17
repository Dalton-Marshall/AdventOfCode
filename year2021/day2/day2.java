import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;

public class day2 {
    public static void main(String[] args) {
        int horizontal = 0;
        int vertical = 0;
        
        try{
            File file = new File("year2021/day2/day2.txt");
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);

            String line = reader.readLine();
            String direction = "";
            int distance = 0;

            while(line != null) {
                direction = line.split(" ")[0];
                distance = Integer.parseInt(line.split(" ")[1]);

                switch(direction) {
                    case "forward":
                        horizontal += distance;
                        break;
                    case "down":
                        vertical -= distance;
                        break;
                    case "up":
                        vertical += distance;
                        break;
                    default:
                        System.out.println("Default case found.");
                }

                line = reader.readLine();
            }

            reader.close();
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(vertical < 0)
            vertical *= -1;

        System.out.println("Horizontal: " + horizontal);
        System.out.println("Vertical: " + vertical);
        System.out.println(horizontal * vertical);
    }
}
