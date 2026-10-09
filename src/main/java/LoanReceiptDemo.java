final class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        // defensive copy on the way in
        this.bookIds = bookIds == null ? new String[0] : bookIds.clone();
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        // defensive copy on the way out
        return bookIds.clone();
    }

    // wither method – returns a brand-new object
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] copy = bookIds.clone();
        if (index >= 0 && index < copy.length) {
            copy[index] = newId;
        }
        return new LoanReceipt(this.memberId, copy);
    }
}

final class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {
    static String branchCode;

    static {
        branchCode = "MAIN-BRANCH";
        // one-time class-level setup
    }

    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | "
             + referenceOnly + " reference-only | " + regular + " regular";
    }
}

public class LoanReceiptDemo {
    public static void main(String[] args) {
        // Immutability test
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);          // still BK-100

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(java.util.Arrays.toString(r.getBookIds()));          // original unchanged
        System.out.println(java.util.Arrays.toString(corrected.getBookIds()));  // corrected

        // Nightly processor
        LoanReceipt[] batch = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(batch));
    }
}