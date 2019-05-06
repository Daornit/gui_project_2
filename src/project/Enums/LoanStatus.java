package project.Enums;

public enum LoanStatus {
    ACTIVE(1),
    LATE(2),
    PAID(3);

    public final int status;

    LoanStatus(int status) {
        this.status = status;
    }

    public static LoanStatus IntToLoanStatus(int iStatus) throws Exception {
        for (LoanStatus type : values()) {
            if (type.getStatusAsInt() == iStatus) {
                return type;
            }
        }
        throw new Exception("Loan Status Oldsongui");
    }

    public static int convertStatusToInt(LoanStatus sStatus) throws Exception {
        for (LoanStatus color : LoanStatus.values()) {
            if (color.getStatusAsInt() == sStatus.getStatusAsInt()) {
                return color.getStatusAsInt();
            }
        }
        throw new Exception("History Status Oldsongui");
    }

    public int getStatusAsInt() {
        return status;
    }
}
