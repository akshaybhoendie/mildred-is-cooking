package com.unasat.service;

import com.unasat.dao.SchuldenDao;
import com.unasat.utility.Messages;

import java.sql.SQLException;
import java.util.Scanner;

import static com.unasat.utility.UtilityMethods.isInputNotCorrect;

public class PrestatieService {

    public void perform(Scanner scanner) throws SQLException {
        boolean cannotProceed = true;

        while (cannotProceed) {
            Messages.subMenuPrestatie();
            String input = scanner.nextLine();

            if(isInputNotCorrect(input)){
                Messages.error1();
            } else {
                if (input.trim().equalsIgnoreCase("1")) {
                    break;
                } else if (input.trim().equalsIgnoreCase("2")) {
                    Messages.prestatieBekijken();
                    Scanner scanner1 = new Scanner(System.in);
                    String parameters = scanner1.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    }else if(parameters.trim().equalsIgnoreCase("1")){
                        SchuldenDao schuldenDao = new SchuldenDao();
                        schuldenDao.bekijkPrestatie();
                    } else {
                        Messages.error1();
                        continue;
                    }
                }
            }
        }
    }
}
