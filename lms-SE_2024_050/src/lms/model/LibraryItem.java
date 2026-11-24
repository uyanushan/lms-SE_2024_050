package lms.model;

public abstract class LibraryItem implements Loanable {

    private String id;
    private String title;
    private boolean isBorrowed;

    public LibraryItem(String id, String title) {
        setId(id);
        setTitle(title);
        this.isBorrowed = false;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Setters
    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be blank");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        this.title = title;
    }


    @Override
    public void loan(Member member) {

        if (isBorrowed) {
            System.out.println(getTitle() + " is already on loan.");
        }
        else if (!member.canBorrow()) {
            System.out.println(
                    member.getName() + " has reached the borrowing limit."
            );
        }
        else {
            isBorrowed = true;
            member.incrementBorrowedCount();

            System.out.println(
                    getTitle() + " loaned to " + member.getName()
            );
        }
    }


    @Override
    public void returnItem() {
        isBorrowed = false;
        System.out.println(getTitle() + " returned.");
    }


    public abstract double calculateLateFee(int daysLate);
}