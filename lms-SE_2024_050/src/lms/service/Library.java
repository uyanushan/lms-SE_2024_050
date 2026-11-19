
package lms.service;

import lms.model.*;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();


    public void addItem(LibraryItem item) {
        items.add(item);
    }


    public void addItem(Book book) {
        items.add(book);
    }


    public void addItem(DVD dvd) {
        items.add(dvd);
    }


    public void addMember(Member member) {
        members.add(member);
    }


    public void listItems() {
        System.out.println("--- Library Items ---");

        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void listMembers() {
        System.out.println("--- Library Members ---");

        for (Member member : members) {
            System.out.println(member);
        }
    }


    public List<LibraryItem> getItems() {
        return items;
    }


    public List<Member> getMembers() {
        return members;
    }


    public void streamIfPossible(LibraryItem item) {

        if (item instanceof DVD dvd) {

            System.out.println(
                    "Streaming " + dvd.getTitle() +
                            " (" + dvd.getDurationMinutes() + " min)"
            );

        } else {

            System.out.println(
                    item.getTitle() +
                            " cannot be streamed - it isn't a DVD."
            );
        }
    }
}
