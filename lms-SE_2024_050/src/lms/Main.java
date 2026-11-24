package lms;

import lms.model.*;
import lms.service.Library;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();


        Book book = new Book(
                "B001",
                "Clean Code",
                "Robert C. Martin"
        );

        DVD dvd = new DVD(
                "D001",
                "Introduction to Algorithms",
                120
        );

        Magazine magazine = new Magazine(
                "M001",
                "Software Weekly",
                25
        );


        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);

        Student student = new Student(
                "S001",
                "Nadeesha Perera"
        );

        Staff staff = new Staff(
                "ST001",
                "Mr. Kasun Silva"
        );


        library.addMember(student);
        library.addMember(staff);

        System.out.println(
                "--- Late fees if 3 day(s) late ---"
        );

        for (LibraryItem item : library.getItems()) {

            System.out.println(
                    item.getTitle() + ": " +
                            item.calculateLateFee(3)
            );
        }


        System.out.println("--- Loans ---");

        library.lend(book, student);

        library.lend(book, staff);

        library.lend(dvd, staff);

        library.lend(magazine, staff);

        System.out.println("--- Reservations ---");

        library.reserveIfPossible(book, staff);

        library.reserveIfPossible(dvd, staff);


        library.printMembersByActivity();
    }
}