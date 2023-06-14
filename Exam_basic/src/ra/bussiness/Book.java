package ra.bussiness;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên sách: ");
        bookName = sc.nextLine();
        while (bookName.isEmpty()) {
            System.out.println("Tên sách không được để trống. Mời bạn nhập lại: ");
            bookName = sc.nextLine();
        }
        System.out.println("Mời bạn nhập tác giả: ");
        author = sc.nextLine();
        while (author.isEmpty()) {
            System.err.println("Tên tác giả không được để trống. Mời bạn nhập lại: ");
            author = sc.nextLine();
        }
        System.out.println("Mời bạn nhập mô tả về sách: ");
        descriptions = sc.nextLine();
        while (descriptions.length() < 10) {
            System.err.println("Mô tả phải có ít nhất 10 ký tự. Mời bạn nhập lại: ");
            descriptions = sc.nextLine();
        }
        System.out.println("Mời bạn nhập giá nhập của sách: ");
        importPrice = Double.parseDouble(sc.nextLine());
        while (importPrice <= 0) {
            System.err.println("Giá nhập phải lớn hơn 0. Mời bạn nhập lại: ");
            importPrice = Double.parseDouble(sc.nextLine());
        }
        System.out.println("Mời bạn nhập giá xuất: ");
        exportPrice = Double.parseDouble(sc.nextLine());
        while (exportPrice <= importPrice * 1.2) {
            System.err.println("Giá xuất phải lớn hơn giá nhập nhân 1.2. Mời bạn nhập lại: ");
            exportPrice = Double.parseDouble(sc.nextLine());
        }
    }

    public void displayData() {
        double interest = exportPrice - importPrice;
        System.out.printf("%-5d %-15s %-15s %-50s %-15f %-15f %-15f %-10b \n", bookId, bookName, author, descriptions, importPrice, exportPrice, interest, bookStatus);
    }
}