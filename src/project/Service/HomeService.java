package project.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import project.DBUtil;
import project.Enums.HistoryStatus;
import project.Enums.LoanStatus;

import java.sql.ResultSet;
import java.time.LocalDate;

public class HomeService {

    /**
     * <h1>Home graph-d medeelel oruulah XYChart Series uusgne</h1>
     *
     * @return 7 honogiin zeel olgolm, garaltiig hadaglah graph series uugne
     * @throws Exception SQL query bolon History status deer ajilah ued aldaa garah magdlaltai
     */
    public static ObservableList<XYChart.Series<String, Number>> chartInfo() throws Exception {
        ObservableList<XYChart.Series<String, Number>> series = FXCollections.observableArrayList();
        XYChart.Series<String, Number> lend = new XYChart.Series<>();
        XYChart.Series<String, Number> paid = new XYChart.Series<>();

        lend.setName("Олголт");
        paid.setName("Хаалт");

        LocalDate today = LocalDate.now();
        for (int i = 6; i >= 0; i--) {
            LocalDate searchDate = today.minusDays(i);

            int countLend = countHistoryByStatusAndDate(HistoryStatus.LEND, searchDate.toString());
            int countPaid = countHistoryByStatusAndDate(HistoryStatus.PAID, searchDate.toString());

            lend.getData().add(new XYChart.Data<>(searchDate.toString(), countLend));
            paid.getData().add(new XYChart.Data<>(searchDate.toString(), countPaid));
        }

        series.add(lend);
        series.add(paid);
        return series;
    }

    /**
     * History Status bolon date iig awaad tuund hargalzah History hed baigaag toolno
     *
     * @param status ymar turuliin history status ve gedgiig zaana
     * @param date   ali udur haihiig zaana
     * @return Tuhuin history typ-tei bichileg tuhain date-d hed baigaagiin too
     */
    public static int countHistoryByStatusAndDate(HistoryStatus status, String date) throws Exception {
        String query = "" +
                "SELECT COUNT(*) as `count` FROM history " +
                "WHERE `status`=" + "'" + HistoryStatus.convertStatusToInt(status) + "'" +
                "AND" +
                "`date`=" + "'" + date + "';";
        ResultSet rs = DBUtil.dbExecuteQuery(query);
        rs.next();
        return rs.getInt("count");
    }

    /**
     * LEND ecvel PAID -iin ene 7 honog magiin ehdee hed baigaag olno
     *
     * @return LEND or PAID iin hagiin ih too
     */
    public static int getMaxCountHistoryThisWeek() throws Exception {
        LocalDate today = LocalDate.now();
        String sixDayAgo = today.minusDays(6).toString();
        String query = "" +
                "SELECT COUNT(*) as `count` " +
                "FROM history " +
                "WHERE (status = '" + HistoryStatus.LEND.status + "' OR status = '" + HistoryStatus.PAID.status + "')" +
                "AND (`date` BETWEEN '" + sixDayAgo + "' AND '" + today.toString() + "') " +
                "GROUP BY `date`, `status` " +
                "ORDER BY `count` DESC " +
                " LIMIT 1;";
        ResultSet rs = DBUtil.dbExecuteQuery(query);
        rs.next();
        return rs.getInt("count");
    }

    public static int countLoansByByStatusAndDate(LoanStatus status) throws Exception {
        String query = "" +
                "SELECT COUNT(*) as `count` FROM loans " +
                "WHERE `status`=" + "'" + LoanStatus.convertStatusToInt(status) + "'";
        ResultSet rs = DBUtil.dbExecuteQuery(query);
        rs.next();
        return rs.getInt("count");
    }
}
