package lms.model;

public class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        setIssueNumber(issueNumber);
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException(
                    "Issue number must be positive"
            );
        }

        this.issueNumber = issueNumber;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 5.0;
    }

    @Override
    public String toString() {
        return "Magazine{id='" + getId() +
                "', title='" + getTitle() +
                "', issueNumber=" + issueNumber + "}";
    }
}