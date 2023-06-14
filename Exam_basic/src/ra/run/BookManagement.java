package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {
    static Book[] arrBook = new Book[100];
    static int index = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    create(sc);
                    break;
                case 2:
                    finAll();
                    break;
                case 3:
                    sortInterestASC();
                    break;
                case 4:
                    deleteById(sc);
                    break;
                case 5:
                    searchBookName(sc);
                    break;
                case 6:
                    update(sc);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }
        } while (true);
    }

    public static void create(Scanner sc) {
        System.out.print("Mời bạn nhập số lượng sách bạn cần thêm mới: ");
        int number = Integer.parseInt(sc.nextLine());
        if (number > arrBook.length) {
            System.err.println("Số lượng sách tối đa là 100 cuốn: Vui lòng nhập lại số sách cần thêm mới");
            number = Integer.parseInt(sc.nextLine());
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Mời bạn nhập thông tin sách: " + (index + 1));
            Book book = new Book();
            book.setBookId(index + 1);
            book.inputData();
            book.setBookStatus(true);
            arrBook[index] = book;
            index++;
        }
    }

    public static void finAll() {
        System.out.printf("%-5s %-15s %-15s %-50s %-15s %-15s %-15s %-10s \n", "Id", "Name", "Author", "descriptions", "importPrice", "exportPrice", "interest", "Status");
        for (int i = 0; i < index; i++) {
            arrBook[i].displayData();
        }
    }

    public static void sortInterestASC() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                    Book book = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = book;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp theo lợi nhuận tăng dần:");
        for (int i = 0; i < index; i++) {
            System.out.println(arrBook[i]);
        }
    }

    public static void deleteById(Scanner sc) {
        System.out.print("Mời bạn nhập Id sách cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        int indexBook = -1;
        for (int i = 0; i < index; i++) {
            if (arrBook[i].getBookId() == id) {
                indexBook = i;
                break;
            }
        }
        if (indexBook != -1) {
            for (int i = 0; i < index - 1; i++) {
                arrBook[i] = arrBook[i + 1];
            }
            arrBook[index - 1] = null;
            index--;
            System.out.println("Sách đã được xóa: ");
        } else {
            System.out.println("id sách không hợp lệ: ");
        }
    }

    public static void searchBookName(Scanner sc) {
        System.out.print("Vui lòng nhập tên sách bạn cần tìm: ");
        String searchBookName = sc.nextLine();
        System.out.printf("%-5s %-15s %-15s %-50s %-15s %-15s %-15s %-10s \n", "Id", "Name", "Author", "descriptions", "importPrice", "exportPrice", "interest", "Status");
        for (int i = 0; i < index; i++) {
            if (arrBook[i].getBookName().startsWith(searchBookName)) {
                arrBook[i].displayData();
            }
        }
    }

    public static void update(Scanner sc) {
        System.out.println(" Mời bạn nhập id mà bạn muốn sửa");
        int id = Integer.parseInt(sc.nextLine());
        int indexBook = -1;
        for (int i = 0; i < index; i++) {
            if (arrBook[i].getBookId() == id) {
                indexBook = i;
                break;
            }
        }
        if (indexBook != -1) {
            System.out.print("Mời bạn cập nhật tên sách: ");
            String bookName = sc.nextLine();
            if (!bookName.isEmpty()) {
                arrBook[indexBook].setBookName(bookName);
            }
            System.out.println("Mời bạn cập nhật tác giả: ");
            String author = sc.nextLine();
            if (!author.isEmpty()) {
                arrBook[indexBook].setAuthor(author);
            }
            System.out.println("Mời bạn cập nhật mô tả: ");
            String decription = sc.nextLine();
            if (!decription.isEmpty()) {
                arrBook[indexBook].setDescriptions(decription);
            }
            System.out.println("Mời bạn cập nhật giá nhập: ");
            String importPrice = sc.nextLine();
            if (!importPrice.isEmpty()) {
                double importPriceValue = Double.parseDouble(importPrice);
                arrBook[indexBook].setImportPrice(importPriceValue);

                System.out.println("Mời bạn cập nhật giá xuất: ");
                String exportPrice = sc.nextLine();
                if (!exportPrice.isEmpty()) {
                    double exportPriceValue = Double.parseDouble(exportPrice);
                    if (exportPriceValue > importPriceValue * 1.2) {
                        arrBook[indexBook].setExportPrice(exportPriceValue);
                    } else {
                        System.out.println("Giá xuất phải lớn hơn giá nhập 1.2 lần.");
                    }
                }
            }
            System.out.println("Mời bạn cập nhật mô tả: ");
            String status = sc.nextLine();
            if (!status.isEmpty()) {
                arrBook[indexBook].setBookStatus(Boolean.parseBoolean(status));
            }
        }
    }
}