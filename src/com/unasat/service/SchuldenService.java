package com.unasat.service;

import com.unasat.dao.KookCursusDao;
import com.unasat.dao.SchuldenDao;
import com.unasat.entity.KookCursus;
import com.unasat.utility.Messages;

import java.sql.SQLException;
import java.util.Scanner;

import static com.unasat.utility.UtilityMethods.isInputNotCorrect;

public class SchuldenService {


    public void perform(Scanner scanner) throws SQLException {
        boolean cannotProceed = true;

        while (cannotProceed) {
            Messages.subMenuOpenstaandeRekening();
            String input = scanner.nextLine();

            if(isInputNotCorrect(input)){
                Messages.error1();
            } else {
                if (input.trim().equalsIgnoreCase("1")) {
                    break;
                } else if (input.trim().equalsIgnoreCase("2")) {
                    Messages.openStaandeRekeningBekijken();
                    Scanner scanner1 = new Scanner(System.in);
                    String parameters = scanner1.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    }else if(parameters.trim().equalsIgnoreCase("1")){
                        SchuldenDao schuldenDao = new SchuldenDao();
                        schuldenDao.bekijkAlleSchulden();
                    } else {
                        Messages.error1();
                        continue;
                    }
                } else if (input.trim().equalsIgnoreCase("3")) {
                    Messages.openStaandeRekeningPerPersoon();
                    Scanner scanner2 = new Scanner(System.in);
                    String parameters = scanner2.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")){
                            String[] split = parameters.split("-");
                            if(split.length == 3){
                                String naam = split[0].trim();
                                String voornaam = split[1].trim();
                                String kookcursus_code = split[2].trim();

                                SchuldenDao schuldenDao = new SchuldenDao();
                                schuldenDao.schuldenbekijkenPersoonCursus(naam,voornaam,kookcursus_code);
                            }else{
                                Messages.error1();
                            }
                        }else{
                            Messages.error1();
                        }
                        continue;
                    }
                } else if (input.trim().equalsIgnoreCase("4")) {
                    Messages.openStaandeRekeningPerCursus();
                    Scanner scanner3 = new Scanner(System.in);
                    String parameters = scanner3.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")){
                            String[] split = parameters.split("-");
                            if(split.length == 1){
                                String kookcursus_code = split[0].trim();

                                SchuldenDao schuldenDao = new SchuldenDao();
                                schuldenDao.bekijkSchuldPerCursus(kookcursus_code);
                            }else{
                                Messages.error1();
                            }
                        }else{
                            Messages.error1();
                        }
                        continue;
                    }
                } else if (input.trim().equalsIgnoreCase("5")) {
                    Messages.openStaandeRekeningUpdate();
                    Scanner scanner4 = new Scanner(System.in);
                    String parameters = scanner4.nextLine();
                    if (parameters.trim().equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (parameters.trim().contains("-")){
                            String[] split = parameters.split("-");
                            if(split.length == 3){
                                String deelnemerID = split[0].trim();
                                String cursusID = split[1].trim();
                                String restBedrag = split[2].trim();

                                SchuldenDao schuldenDao = new SchuldenDao();
                                schuldenDao.updateCursusDeelnemerSchuldById(deelnemerID, cursusID, restBedrag);
                            }else{
                                Messages.error1();
                            }
                        }else{
                            Messages.error1();
                        }
                        continue;
                    }
                }
            }
        }
    }
}
