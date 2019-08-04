
/**
 * Created by Abood on 02-Aug-19.
 */
public class HeartData
{
    public HeartData(String age, String cp, String restecg, String oldpeak, String slope, String ca, String thal, String exang, String sex) {
        this.restecg = restecg;
        this.oldpeak = oldpeak;
        this.slope = slope;
        this.ca = ca;
        this.thal = thal;
        this.cp = cp;
        this.exang = exang;
        this.sex = sex;
        this.age = age;
    }

    //      6       9      10      11     12        8   1
    String cp ,restecg, oldpeak, slope, ca, thal, exang, sex, age;

    public String detect () {

        if(sex.equals("1") && (restecg.equals("1") || restecg.equals("2")) && (slope.equals("1") || slope.equals("2")) && ( thal.equals("2") )&& (Integer.parseInt (age.trim()) < 60) ){

            return "1";
        }
        else if( ( cp.equals("1") ) && (restecg.equals("1") || restecg.equals("2")) && (Integer.parseInt (age.trim()) > 60) ){

            return "1";
        }

        else if((slope.equals("2") || slope.equals("3")) && ( cp.equals("0") ) && (exang.equals("1"))){

            return "1";
        }

        else if((restecg.equals("1") || restecg.equals("2")) && (slope.equals("2") || slope.equals("0"))&& ( Double.parseDouble(oldpeak.trim()) > 0) ){

            return "1";
        }
        else if((ca.equals("2") || ca.equals("3")) && ( thal.equals("3") || thal.equals("1"))){

            return "0";
        }

        else if(thal.equals("1")   || thal.equals("3") ){

            return "0";
        }
        else if(thal.equals("2")   && (ca.equals("2") || ca.equals("3") ) ){

            return "0";
        }
        else if(thal.equals("2")){

            return "1";
        }
        else return "3";
    }
}
