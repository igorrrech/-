import classes.Book;
import classes.Interval;
import classes.Complex;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        //task2();
        //task3();
    }
    public static void task1(){
        int n = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите кол-во книг: ");
        n=in.nextInt();
        Book[] books = new Book[n];
        for(int i=0; i < books.length; i++){books[i]=new Book();}
        for(Book book : books){
            String buff;

            System.out.print("Введите id: ");
            buff = in.next();
            book.setBookId(Integer.parseInt(buff));

            System.out.print("Введите название: ");
            buff = in.next();
            book.setBookName(buff);

            System.out.print("Введите авторов книги: ");
            buff = in.next();
            book.setBookAuthors(buff.split(","));

            System.out.print("Введите издательство: ");
            buff = in.next();
            book.setBookPublishingHouse(buff);

            System.out.print("Введите год: ");
            buff = in.next();
            book.setBookYear(Short.valueOf(buff));
        }

        for(Book book: books){
            book.print();
        }

        System.out.print("Введите автора книг: ");
        String author = in.next();
        for(Book book:books){
            if(author.equals(book.getAuthors()[0])){
                book.print();
            }
        }

        System.out.print("Введите издательство: ");
        String publisher = in.next();
        for(Book book:books){
            if(publisher.equals(book.getPublishingHouse())){
                book.print();
            }
        }

        System.out.print("Введите год: ");
        String year = in.next();
        for(Book book:books){
            if(Integer.parseInt(year) == book.getYear()){
                book.print();
            }
        }
    }
    public static void task2(){
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите кол-во интервалов: ");
        n=in.nextInt();
        Interval[] intervalsArray = new Interval[n];
        for(int i=0; i < intervalsArray.length; i++){
            System.out.print("Введите интервал в виде [1,2): ");
            intervalsArray[i] = new Interval(in.next());
        }
        Interval sum = new Interval(intervalsArray[intervalsArray.length-1]);
        for(int i=0; i < intervalsArray.length-1; i++){
            sum.join(intervalsArray[i]);
        }
        System.out.println("Рассотяние: "+(sum.getIntervalEnd()-sum.getIntervalBegin()));
    }
    public static void task3(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите кол-во координат: ");
        int n = in.nextInt();
        Complex[] complexArray = new Complex[n];
        for (int i = 0; i < complexArray.length; i++) {
            System.out.print("Введите комплексное число в виде m/n+m/ni: ");
            complexArray[i] = new Complex(in.next());
        }
        for (Complex c:
             complexArray) {
            c.println();
        }
        System.out.println();
        sum(complexArray);
        mul(complexArray);
    }
    public static void sum(Complex[] complexes){
        Complex sum = new Complex();
        for (Complex c: complexes) {
            sum=sum.add(c);
        }
        System.out.print("Сумма: ");
        sum.println();
    }
    public static void mul(Complex[] complexes){
        Complex mul = new Complex(1,1,1,1);
        for (Complex c: complexes) {
            mul=mul.mul(c);
        }
        System.out.print("Умножение: ");
        mul.println();
    }

}