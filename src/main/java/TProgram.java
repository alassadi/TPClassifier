import com.opencsv.CSVReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Created by Abood on 29-Jul-19.
 */
public class TProgram {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ArrayList<String> results = new ArrayList();
        double acc = 0;
        double tp = 0, tn = 0, fp = 0, fn = 0;
        int nono = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader("src/data/heart-original.csv"));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                HeartData heartData = new HeartData(nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4],
                        nextLine[5], nextLine[6], nextLine[7], nextLine[8], nextLine[9],
                        nextLine[10], nextLine[11], nextLine[12]);
                results.add(heartData.classify());
                if (nextLine[13].equals(heartData.classify())) {
                    acc++;
                    if (nextLine[13].equals("0")) {
                        tn++;
                    } else tp++;
                } else if (nextLine[13].equals("0")) {
                    fp++;
                } else {
                    fn++;
                }
                if (heartData.classify().equals("3")) {
                    nono++;
                }
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            double accuracy = (acc * 100) / 303;
            System.out.println("The classification accuracy is: " + Double.valueOf(decimalFormat.format(accuracy)) + "%");
            double precision = tp / (tp + fp);
            double recall = tp / (tp + fn);
            System.out.println("The classification precision for class 0 is: " + Double.valueOf(decimalFormat.format(100 * precision)) + "%");
            System.out.println("The classification recall for class 0 is: " + Double.valueOf(decimalFormat.format(100 * recall)) + "%");
            precision = tn / (tn + fn);
            recall = tn / (tn + fp);
            System.out.println("The classification precision for class 1: " + Double.valueOf(decimalFormat.format(100 * precision)) + "%");
            System.out.println("The classification recall for class 1: " + Double.valueOf(decimalFormat.format(100 * recall)) + "%");
            Instant end = Instant.now();
            System.out.println("The execution time: " + Duration.between(start, end));
            System.out.println(nono);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
