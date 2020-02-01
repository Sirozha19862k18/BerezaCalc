import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ResultCalculator {
    private String directoryResult;
    private ArrayList<Long> date;
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    public void calc(String directoryResult, ArrayList<Long> date) throws SQLException, ClassNotFoundException {
        this.directoryResult = directoryResult;
        this.date=date;
        connectToDB(directoryResult);
        readDB(date);
        calcMassaProdukta(resSet);
        closeDB();
    }

    public static void connectToDB(String directoryResult) throws ClassNotFoundException    {
        conn = null;
        String url = "jdbc:sqlite:"+directoryResult+"/log_Syriya.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet readDB(ArrayList<Long> data ) throws SQLException
    {
        statmt = conn.createStatement();
        String sqlReportPeriodStart = String.valueOf(data.get(0));
        String sqlReportPeriodEnd = String.valueOf(data.get(1));
        String sqlQueryString="Select * from data where (\"time@timestamp\" between "+sqlReportPeriodStart+" and "+sqlReportPeriodEnd+ " ) and data_format_0>=50";
        // System.out.println(sqlString);
        resSet = statmt.executeQuery(sqlQueryString);
        return resSet;


    }
    // --------Закрытие--------
    public static void closeDB() throws SQLException
    {
        conn.close();
        //System.out.println("Соединения закрыты");
    }

    public void calcMassaProdukta(ResultSet resSet) throws SQLException {
        this.resSet=resSet;
        float massaProdukta =0;
        while(resSet.next()) {
            float massaOtvesa = resSet.getFloat("data_format_0");
            massaProdukta+=massaOtvesa;
        }

        /* -------Вывод суммы сырья------------ */

        System.out.println("\nЗа выбранный промежуто времени переработано " +  massaProdukta + " кг сырья");

    }
}
