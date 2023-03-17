package classes;

public class Book {
    private int bookId;
    private String bookName;
    private String[] bookAuthors;
    private String bookPublishingHouse;
    private short bookYear;
    private short bookPageCount;
    private long bookPrice;
    private String bindingType;
    public Book(){
        bookId=0;
        bookName=" ";
        bookYear=0;
        bookPageCount=0;
        bookPrice=0;
        bindingType="Береста";
    }

    public long getBookId(){return bookId;}
    public String[] getAuthors(){return bookAuthors;}
    public String getPublishingHouse(){return bookPublishingHouse;}
    public int getYear(){return bookYear;}

    public void setBookId(int bookId) {this.bookId = bookId;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public void setBookAuthors(String[] bookAuthors) {this.bookAuthors = bookAuthors;}
    public void setBookPublishingHouse(String bookPublishingHouse) {this.bookPublishingHouse = bookPublishingHouse;}
    public void setBookPrice(long bookPrice) {this.bookPrice = bookPrice;}
    public void setBindingType(String bindingType) {this.bindingType = bindingType;}
    public void setBookYear(short bookYear) {this.bookYear = bookYear;}
    public void setBookPageCount(short bookPageCount) {this.bookPageCount = bookPageCount;}

    public String toString() {
        String result = "id: "+String.valueOf(bookId);
        for (String author:bookAuthors) {result+=", "+author ;}
        result+=" " + bookName+"/ "+bookAuthors[0]+". - "+bookPublishingHouse+", "+String.valueOf(bookYear)+". - "
                                                                                  +String.valueOf(bookPageCount)+"c. ";
        result +=String.valueOf(bookPrice)+"$ "+ "type: "+bindingType;
        return result;
    }

    public void print(){
        System.out.println(this.toString());
    }
}
