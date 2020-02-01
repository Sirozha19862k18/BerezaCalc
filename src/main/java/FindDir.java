
import java.io.File;

public class FindDir {

    public static String dirSearch(){
        System.out.println("Производится поиск файла с данными статистики");
        char diskLetter='C';
        boolean findedFileFlag=false;
        String pathToReportFile;
        String datalogFolder=null;
        for (int i = 0; i < 20; i++) {
            datalogFolder = diskLetter + ":/datalog/";
            pathToReportFile = datalogFolder+"log_Syriya.db";
            diskLetter++;
            File directoryWithReportFullPath = new File(pathToReportFile);
            if (directoryWithReportFullPath.isFile())
            {
                findedFileFlag=true;
                break;
            }
            else {
                findedFileFlag=false;
                 }
                                   }

        if (findedFileFlag){
          System.out.println("Файлы статистики расположены в директории " + datalogFolder + "\n"); }
         else {
            System.out.println("На дисках не обнаружено файла с данными. Возможно, контроллер не записал файл статистики на вашу флешку. \nПопробуйте снова вставить флешку в USB контроллера и повторите попытку считывания, затем запустите программу снова. ");
            System.exit(1);
                   }
        return datalogFolder;
    }



}

