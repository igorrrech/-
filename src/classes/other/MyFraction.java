package classes.other;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MyFraction{
    private Fraction fraction;
    private final Pattern fractionPattern = Pattern.compile("\\-?\\d+/\\-?\\d+");
    public MyFraction(){
        fraction = new Fraction();
    }
    public MyFraction(int m, int n){
        fraction = new Fraction(m,n);
    }
    public MyFraction(String fraction){
        Matcher matcher = fractionPattern.matcher(fraction);
        if(matcher.find()) {
            String trueFraction = fraction.substring(matcher.start(), matcher.end());
            Matcher digitFraction = Pattern.compile("\\-?\\d+").matcher(trueFraction);
            digitFraction.find();
            int m = Integer.parseInt(trueFraction.substring(digitFraction.start(), digitFraction.end()));
            digitFraction.find();
            int n = Integer.parseInt(trueFraction.substring(digitFraction.start(), digitFraction.end()));
            this.fraction = new Fraction(m,n);
        }
    }
    public int getM(){
        return fraction.getM();
    }
    public int getN(){
        return fraction.getN();
    }
    public MyFraction add(MyFraction b){
        return new MyFraction(this.getM()+b.getM(),this.getN()+b.getN());
    }
    public MyFraction mul(MyFraction b){
        return new MyFraction(this.getM()*b.getM(), this.getN()*b.getN());
    }

    @Override
    public String toString() {
        return fraction.toString();
    }
}
