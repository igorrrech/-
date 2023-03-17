package classes.other;

public class Fraction {
    private int m;
    private int n;

    public Fraction(){
        this.m=0;
        this.n=0;
    }
    public Fraction(int m, int n){
        this.m = m;
        this.n = n;
    }
    public float add(Fraction fraction) {return (this.m / this.n) + (fraction.m / fraction.n);}
    public float sub(Fraction fraction) {return (this.m / this.n) - (fraction.m / fraction.n);}
    public float mult(Fraction fraction) {return this.m * fraction.m / (this.n * fraction.n);}
    public float div(Fraction fraction) {return this.m * fraction.n / (this.n * fraction.m);}

    public static Fraction[] generate(int n){
        Fraction[] fractions = new Fraction[n];
        for(int i =0; i < n; i++){
            fractions[i] = new Fraction((int) (Math.random()*10), ((int) ((Math.random()*10)+1)));
        }
        return fractions;
    }

    public  int getM(){
        return m;
    }
    public int getN(){
        return n;
    }

    public static Fraction[] oddIndexChange(Fraction[] fraction){
        for (int i = 0; i < fraction.length-1; i++) {
            if (i % 2 == 0) {
                fraction[i].m += fraction[i+1].m;
                fraction[i].n += fraction[i+1].n;
            }
        }
        return fraction;
    }

    @Override
    public String toString() {
        return " {"
                + m + "/"
                + n +
                "} ";
    }
}