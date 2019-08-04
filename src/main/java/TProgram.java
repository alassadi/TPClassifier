import com.opencsv.CSVReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Created by Abood on 29-Jul-19.
 */
public class TProgram {
    public static void main(String[] args) {
        Instant start = Instant.now();

        ArrayList <String> results = new ArrayList();
        int acc = 0;
        int acc1 = 0;
            try {

                CSVReader reader = new CSVReader(new FileReader("src/data/heart.csv"));
                String [] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    // cp = 2,  restecg 6, oldpeak 9  ..slope  10 ..  ca   11 ..  thal  12
                    HeartData heartData = new HeartData(nextLine[0],nextLine[2],nextLine[6],nextLine[9], nextLine[10],
                            nextLine[11], nextLine[12], nextLine[8], nextLine[1]);
                    results.add(heartData.detect());
                    if(nextLine[13].equals(heartData.detect())) {
                        acc++;

                    }
                    if(heartData.detect().equals("3")) {
                        acc1++;

                    }
                }

                int total =( acc * 100 )/1508940;
                System.out.println(total);
                Instant end = Instant.now();
                System.out.println(Duration.between(start, end));
                System.out.println(acc1);

            }
            catch (Exception e) {
                e.printStackTrace();
            }


        }

}
