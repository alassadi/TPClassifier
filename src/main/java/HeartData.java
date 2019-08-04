
/**
 * Created by Abood on 02-Aug-19.
 */
public class HeartData
{
    public HeartData(String cp, String restecg, String oldpeak, String slope, String ca, String thal) {
        this.restecg = restecg;
        this.oldpeak = oldpeak;
        this.slope = slope;
        this.ca = ca;
        this.thal = thal;
        this.cp = cp;
    }

    //      6       9      10      11     12
    String cp ,restecg, oldpeak, slope, ca, thal;

    public String detect () {

        if((restecg.equals("1") || restecg.equals("2")) && (slope.equals("1") || slope.equals("2")) && ( thal.equals("6") || thal.equals("7"))){

            return "1";
        }
        else if((slope.equals("2") || slope.equals("3")) && ( cp.equals("0") )){

            return "1";
        }
        else if((restecg.equals("2") || restecg.equals("3")) && (slope.equals("2") || slope.equals("3") &&( oldpeak.equals("0") || oldpeak.equals("1")) )){

            return "0";
        }
        else if((ca.equals("2") || ca.equals("3") || ca.equals("4")) && ( thal.equals("7") || thal.equals("3"))){

            return "0";
        }

        else if(thal.equals("3")   || thal.equals("7") ){

            return "0";
        }
        else if(thal.equals("6")   && (ca.equals("2") || ca.equals("3") ) ){

            return "0";
        }
        else if(thal.equals("6")){

            return "1";
        }
        else return "0";
    }
}
