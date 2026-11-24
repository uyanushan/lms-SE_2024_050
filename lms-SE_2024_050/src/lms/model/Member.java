package lms.model;

public class Member implements Comparable<Member> {

    private String memberId;
    private String name;
    private int borrowedCount;
    private final int borrowLimit;

    public Member(String memberId, String name, int borrowLimit) {
        setMemberId(memberId);
        setName(name);

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }

        this.borrowLimit = borrowLimit;
        setBorrowedCount(0);
    }


    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }


    public void setMemberId(String memberId) {
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException(
                    "Member ID cannot be blank"
            );
        }
        this.memberId = memberId;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be blank"
            );
        }
        this.name = name;
    }

    public void setBorrowedCount(int borrowedCount) {
        if (borrowedCount < 0) {
            throw new IllegalArgumentException(
                    "Borrowed count cannot be negative"
            );
        }
        this.borrowedCount = borrowedCount;
    }

    public void incrementBorrowedCount() {
        setBorrowedCount(borrowedCount + 1);
    }

    public boolean canBorrow() {
        return borrowedCount < borrowLimit;
    }


    @Override
    public int compareTo(Member other) {
        return Integer.compare(
                other.borrowedCount,
                this.borrowedCount
        );
    }

    @Override
    public String toString() {
        return "Member{id='" + memberId +
                "', name='" + name +
                "', borrowedCount=" + borrowedCount + "}";
    }
}