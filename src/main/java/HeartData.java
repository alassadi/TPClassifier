
/**
 * Created by Abood on 02-Aug-19.
 */
public class HeartData {
    //  age sex cp trestbps chol fbs restecg thalach exang oldpeak slope ca thal
    String age, sex, cp, trestbps, chol, fbs, restecg, thalach, exang, oldpeak, slope, ca, thal;

    public HeartData(String age, String sex, String cp, String trestbps, String chol, String fbs, String restecg, String thalach, String exang, String oldpeak, String slope, String ca, String thal) {
        this.age = age;
        this.sex = sex;
        this.cp = cp;
        this.trestbps = trestbps;
        this.chol = chol;
        this.fbs = fbs;
        this.restecg = restecg;
        this.thalach = thalach;
        this.exang = exang;
        this.oldpeak = oldpeak;
        this.slope = slope;
        this.ca = ca;
        this.thal = thal;
    }

    public String classify() {

        if (sex.equals("1") && cp.equals("0") && (Integer.parseInt(age.trim()) < 60)) {

            return "0";
        } else if (cp.equals("0") && (exang.equals("1")) && (Double.parseDouble(oldpeak.trim()) > 0) && (Integer.parseInt(age.trim()) > 60)) {

            return "0";
        } else if ((cp.equals("0") || cp.equals("1")) && (thal.equals("3"))) {

            return "0";
        } else if ((cp.equals("0")) && Integer.parseInt(ca) > 1) {

            return "0";
        } else if ((cp.equals("2")) && (exang.equals("0"))) {

            return "1";
        } else if ((thal.equals("2")) && (restecg.equals("0"))) {

            return "1";
        } else if (ca.equals("0")) {

            return "1";
        } else if ((Integer.parseInt(trestbps.trim()) > 140) && (Integer.parseInt(chol.trim()) > 200)) {

            return "0";
        } else return "1";
    }
}
