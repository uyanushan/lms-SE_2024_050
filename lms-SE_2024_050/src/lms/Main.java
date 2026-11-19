
package lms;

import lms.model.*;
import lms.service.Library;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();


        Book book1 = new Book(
                "B001", "Clean Code", "Robert C. Martin"
        );

        Book book2 = new Book(
                "B002", "Effective Java", "Joshua Bloch"
        );


        DVD dvd1 = new DVD(
                "D001", "Java Tutorial", 120
        );


        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd1);


        Student student = new Student(
                "S001", "Nadeesha Perera"
        );

        Staff staff = new Staff(
                "ST001", "Kasun Silva"
        );

        library.addMember(student);
        library.addMember(staff);


        library.listItems();


        library.listMembers();

        System.out.println("--- Late Fees ---");

        for (LibraryItem item : library.getItems()) {

            System.out.println(
                    item.getTitle() + ": Rs. " +
                            item.calculateLateFee(3)
            );
        }


        System.out.println("--- Streaming Test ---");

        library.streamIfPossible(book1);
        library.streamIfPossible(dvd1);
    }
}
