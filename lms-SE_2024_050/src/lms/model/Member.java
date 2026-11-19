package lms.model;

public class Member {

    private String memberId;
    private String name;
    private int borrowedCount;
    private int borrowLimit;

    public Member(String memberId, String name) {
        this(memberId, name, 5);
    }

    public Member(String memberId, String name, int borrowLimit) {
        setMemberId(memberId);
        setName(name);
        setBorrowLimit(borrowLimit);
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
            throw new IllegalArgumentException("Member ID cannot be blank");
        }
        this.memberId = memberId;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }

    public void setBorrowedCount(int borrowedCount) {
        if (borrowedCount < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        this.borrowedCount = borrowedCount;
    }

    public void setBorrowLimit(int borrowLimit) {
        if (borrowLimit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative");
        }
        this.borrowLimit = borrowLimit;
    }

    public void incrementBorrowedCount() {
        setBorrowedCount(borrowedCount + 1);
    }
}