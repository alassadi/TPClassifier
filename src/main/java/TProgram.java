import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Abood on 29-Jul-19.
 */
public class TProgram {
    public static void main(String[] args) {
        ArrayList <String> results = new ArrayList();
        int acc = 0;
            try {

                CSVReader reader = new CSVReader(new FileReader("src/data/heart.dat.arff.csv"));
                String [] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    // cp = 2,  restecg 6, oldpeak 9  ..slope  10 ..  ca   11 ..  thal  12
                    HeartData heartData = new HeartData(nextLine[2],nextLine[6],nextLine[9], nextLine[10],
                            nextLine[11], nextLine[12]);
                    results.add(heartData.detect());
                    if(nextLine[13].equals(heartData.detect())) {
                        acc++;

                    }
                }

                int total =( acc * 100 )/3965760;
                System.out.println(total);


            }
            catch (Exception e) {
                e.printStackTrace();
            }


        }

}
