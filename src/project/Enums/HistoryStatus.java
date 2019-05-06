package project.Enums;

public enum HistoryStatus {
    LEND(1),
    PAYMENT(2),
    LATE_PAYMENT(3),
    PAID(4),
    SOLD(5);

    public final int status;

    HistoryStatus(int status) {
        this.status = status;
    }

    public int getStatusAsInt() {
        return status;
    }

    public static HistoryStatus IntToHistoryStatus(int iStatus) throws Exception {
        for (HistoryStatus type : values()) {
            if (type.getStatusAsInt() == iStatus) {
                return type;
            }
        }
        throw new Exception("History Status Oldsongui");
    }

    public static int convertStatusToInt(HistoryStatus sStatus) throws Exception {
        for (HistoryStatus color : HistoryStatus.values()) {
            if (color.getStatusAsInt() == sStatus.getStatusAsInt()) {
                return color.getStatusAsInt();
            }
        }
        throw new Exception("History Status Oldsongui");
    }
}
