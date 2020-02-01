
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        FirstRun.welcomeScreen();
        Runner calc = new Runner();   //В планах добавить подсчет еще одного вида сырья
        calc.run();
    }

    public static class FirstRun {
        public static void welcomeScreen() {
            System.out.println("==Программа учета статистики веса перерабатываемого сырья для цеха переработки семян масличных культур.==");
        }
    }

    public static  class Runner {
        public void run ()  {
        String directoryWithFileReport = FindDir.dirSearch();
        ArrayList<Integer> resultUserInputDate = InputUserParser.dateInputStart();
        ArrayList<Long> dateReportBeginAndEnd = Convert.getDateReportBeginAndAnd(resultUserInputDate);
        ResultCalculator itogReport = new ResultCalculator();
            try {
                itogReport.calc(directoryWithFileReport, dateReportBeginAndEnd);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}