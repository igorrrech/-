package classes;
import classes.other.MyFraction;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Complex {
    private MyFraction real;
    private MyFraction imaginary;
    private final Pattern complexPattern = Pattern.compile("\\-?\\d+/-?\\d+[\\-\\+]?\\d+/\\-?\\d+\\s?i");
    public Complex(){
        real = new MyFraction();
        imaginary = new MyFraction();
    }
    public Complex(int am, int an, int bm, int bn){
        this.real = new MyFraction(am, an);
        this.imaginary = new MyFraction(bm, bn);
    }
    public Complex(MyFraction real, MyFraction imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex(String complex){
        Matcher matcher = complexPattern.matcher(complex);
        if(matcher.find()){
            String trueComplex = complex.substring(matcher.start(), matcher.end());
            Matcher fractionMatcher = Pattern.compile("\\-?\\d+/\\-?\\d+").matcher(trueComplex);
            fractionMatcher.find();
            this.real = new MyFraction(trueComplex.substring(fractionMatcher.start(), fractionMatcher.end()));
            fractionMatcher.find();
            this.imaginary = new MyFraction(trueComplex.substring(fractionMatcher.start(), fractionMatcher.end()));
        }
    }

    public void setReal(MyFraction real) {
        this.real = real;
    }
    public void setImaginary(MyFraction imaginary) {
        this.imaginary = imaginary;
    }
    public MyFraction getImaginary() {
        return imaginary;
    }
    public MyFraction getReal() {
        return real;
    }

    public Complex add(Complex b){
        return new Complex(this.real.add(b.real), this.imaginary.add(b.imaginary));
    }
    public Complex mul(Complex b){
        return new Complex(this.real.mul(b.real), this.imaginary.mul(b.imaginary));
    }
    public void print(){
        System.out.print(real.toString() +"+"+ imaginary.toString() + "i");
    }
    public void println(){
        print();
        System.out.println();
    }
}
