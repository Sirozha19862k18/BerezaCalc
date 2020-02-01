
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Convert {
    public static ArrayList<Long> getDateReportBeginAndAnd(ArrayList<Integer> dataInt){
        ArrayList<Integer> data = dataInt;
        Long dateReportsBegin= Convert.convertData(data.get(0), data.get(1)-1, data.get(2), data.get(3), data.get(4)); //дата начала формирования отчета
        Long dateReportsEnd= Convert.convertData(data.get(5), data.get(6)-1, data.get(7), data.get(8), data.get(9)); //дата конца формирования отчета
        ArrayList<Long> dateReportBeginAndEnd = new ArrayList<Long>();
        dateReportBeginAndEnd.add(dateReportsBegin);
        dateReportBeginAndEnd.add(dateReportsEnd);
        return dateReportBeginAndEnd;
    }
    public static Long convertData(int date, int month, int year, int hourOfDay, int minute){
        int dateIn=date;
        int monthIn=month;
        int yearIn=year;
        int hourOfDayIn=hourOfDay;
        int minuteIn=minute;
       // System.out.println(dateIn +""+ monthIn+ ""+yearIn+""+hourOfDayIn +""+minuteIn);
        Calendar virtualCalendar= Calendar.getInstance(TimeZone.getTimeZone("UTC"));  //calendarstart
        virtualCalendar.clear();
        virtualCalendar.set(Calendar.DATE, dateIn);
        virtualCalendar.set(Calendar.MONTH, monthIn);
        virtualCalendar.set(Calendar.YEAR, yearIn);
        virtualCalendar.set(Calendar.HOUR_OF_DAY, hourOfDayIn);
        virtualCalendar.set(Calendar.MINUTE, minuteIn);
        Date getInputDate = virtualCalendar.getTime();
        long dateInTimestamp=getInputDate.getTime()/1000;  //возврат в формате unix Timestamp
        return dateInTimestamp;
    }
}
