package classes;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Interval {
    private int x1, x2;
    private boolean state1, state2;
    private final Pattern pattern = Pattern.compile("[\\[\\(]\\-?\\d+\\D\\s?\\-?\\d+[\\]\\)]");
    {
        x1=0;
        x2=0;
        state1 = false;
        state2 = false;
    }
    public Interval(int x1, int x2){
        if(x1 > x2){
            this.x1 = x2;
            this.x2 = x1;
        }else {
            this.x1=x1;
            this.x2=x2;
        }
    }
    public Interval(int x1, int x2, boolean state1, boolean state2){
        this(x1, x2);
        this.state1=state1;
        this.state2=state2;
    }
    public Interval(Interval interval){
        this(interval.getIntervalBegin(), interval.getIntervalEnd(),
                interval.isBeginState(), interval.isEndState());
    }
    public Interval(String interval){
        Matcher matcher = pattern.matcher(interval);
        if(matcher.find()){
            String trueInterval = interval.substring(matcher.start(),matcher.end());
            Matcher digitMatcher = Pattern.compile("\\-?\\d+").matcher(trueInterval);
            digitMatcher.find();
            int x1 = Integer.parseInt(trueInterval.substring(digitMatcher.start(), digitMatcher.end()));
            digitMatcher.find();
            int x2 = Integer.parseInt(trueInterval.substring(digitMatcher.start(), digitMatcher.end()));
            if(x1 > x2){
                this.x1 = x2;
                this.x2 = x1;
            }else {
                this.x1=x1;
                this.x2=x2;
            }
            state1 = trueInterval.contains("[");
            state2 = trueInterval.contains("]");
        }
    }

    public void setBeginState(boolean state1) {
        this.state1 = state1;
    }
    public void setEndState(boolean state2) {
        this.state2 = state2;
    }
    public void setIntervalBegin(int x1) {
        this.x1 = x1;
    }
    public void setIntervalEnd(int x2) {
        this.x2 = x2;
    }

    public int getIntervalBegin() {
        return x1;
    }
    public int getIntervalEnd() {
        return x2;
    }
    public boolean isBeginState() {
        return state1;
    }
    public boolean isEndState() {
        return state2;
    }

    public boolean isIntersect(Interval interval){
        if(this.x1 > interval.getIntervalBegin() && this.x1 < interval.getIntervalEnd()){return  true;}
        if(this.x1 < interval.getIntervalBegin() && this.x1 > interval.getIntervalEnd()){return  true;}
        if(this.x2 > interval.getIntervalBegin() && this.x2 < interval.getIntervalEnd()){return true;}
        if(this.x2 < interval.getIntervalBegin() && this.x2 > interval.getIntervalEnd()){return true;}

        if(this.state1 && interval.isBeginState() &&((this.x1 == interval.getIntervalBegin())||
                (this.x2==interval.getIntervalBegin()&&this.state2))){return true;}
        if(this.state2 && interval.isEndState() &&((this.x2 == interval.getIntervalEnd())||
                (this.x1==interval.getIntervalEnd()&&this.state1))){return true;}
        return false;
    }
    public boolean isContaints(int num){
        boolean flag = false;
        if(this.state1){
            if(num >= this.x1){
                flag = true;
            }
        }else{
            if(num > this.x1){
                flag = true;
            }
        }
        if(flag){
            if(this.state2){
                if(num <= this.x2){
                    return true;
                }
            }else{
                if(num < this.x2){
                    return true;
                }
            }
        }
        return  false;
    }
    public boolean join(Interval interval){
        Interval beta = new Interval(this);
        if(!isIntersect(interval)){
            return false;
        }
        if(this.x1 > interval.getIntervalBegin()){
            this.x1 = interval.getIntervalBegin();
        }
        if(this.x2 < interval.getIntervalEnd()){
            this.x2 = interval.getIntervalEnd();
        }
        this.state1 = interval.isContaints(this.x1)||beta.isContaints(this.x1);
        this.state2 = interval.isContaints(this.x2)||beta.isContaints(this.x2);
        return true;
    }
    public void print(){
        if(state1){
            System.out.print("[");
        }else{
            System.out.print("(");
        }
        System.out.print(this.x1+", "+this.x2);
        if(state2){
            System.out.print("]");
        }else{
            System.out.print(")");
        }
    }
    public void println(){
        this.print();
        System.out.println();
    }
}
