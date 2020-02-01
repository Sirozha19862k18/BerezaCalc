

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class InputUserParser {
    public static ArrayList<Integer> dateInputStart() {
        final String DELIMITER="." + " " + "-" + ":" + "," + "  " + "/" + ";" +"'"+ " - "+ "-";
        System.out.println("Введите диапазон дат для каторых нужна выборка по статистике. Для примера диапазон с 1 января 2019 года 8 часоа 00 минут по 2 января 2019 года 8 часов 00 минут записывается так: 01.01.2019 8:00 - 02.01.2019 8:00\n");
        Scanner in = new Scanner(System.in);
        String userInputValue = in.nextLine();
        System.out.println("Вы ввели диапазон "+ userInputValue);
        StringTokenizer tempUserInputToken = new StringTokenizer(userInputValue,DELIMITER); //разбивка с учетом разделителей
       ArrayList<Integer> userDateInputResult =userDateInputResult(tempUserInputToken);
        return userDateInputResult;
    }

    public static ArrayList<Integer> userDateInputResult(StringTokenizer tempUserInputToken){
        ArrayList<Integer> tempUserDateInputResult = new ArrayList<Integer>();
        if(tempUserInputToken.countTokens()!=10){ // Проверка на неверный ввод даты
            System.out.println("Вы неправильно ввели диапазон выборки.");
            System.exit(1);
        }
        else {
            while (tempUserInputToken.hasMoreTokens()) {
                String inputToken = tempUserInputToken.nextToken();
                //System.out.println(inputToken);
                try {
                    int resultInt = Integer.parseInt(inputToken);
                    tempUserDateInputResult.add(resultInt);
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe);
                }
            }
        }
        return tempUserDateInputResult;
    }

}
