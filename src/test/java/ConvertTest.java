
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {
       @Test
   public void convertData () throws Exception{
       assertEquals(1551513600, Convert.convertData(02, 02, 2019, 8, 0));
    }
    @Test
    public void  getDateReportBeginAndAnd () throws Exception{
        ArrayList<Long> expexted= new ArrayList<Long>(Arrays.asList(new Long[]{1549094400L, 1580630400L}));
        ArrayList<Integer> actual= new ArrayList<Integer>(Arrays.asList(new Integer[] {02, 02, 2019, 8, 0,02,02,2020, 8, 0}));
       assertEquals(expexted, Convert.getDateReportBeginAndAnd(actual));
    }

}