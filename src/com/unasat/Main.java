package com.unasat;

import com.unasat.service.*;
import com.unasat.utility.Messages;

import java.sql.SQLException;
import java.util.Scanner;

import static com.unasat.utility.UtilityMethods.isInputNotCorrect;
import static com.unasat.utility.UtilityMethods.isOptionCorrect;

public class Main {

    /**
     * @Developer: Akhsaykumar Bhoendie
     * @Project: Mildred's Kookschool
     * @Description: De applicatie is gebouwd voor registratie van dagelijkse activiteiten voor de kookschool.
     * Verschillende zaken worden bijgehouden nl.:
     * - Inschrijvingen
     * - Kook cursussen
     * - prestaties
     * - Klantenbestand
     * - Openstaande rekeningen
     * @Instructies: Om gebruik te kunnen maken van de applicatie moeten de volgende zaken eerst in orde gemaakt worden:
     * - Maak een database connectie met een database genoemd "kookschool"
     * - Navigeer naar de DatabaseConnection class en geef de credentials mee
     * - Navigeer naar de SQL folder in de root directory en draai de sql script in Heidi of ander database management system
     * - De mysql Java Connector zit in de applicatie structuur en kan gebruikt worden voor configuratie in geval nodig
     * - Run de main app
     * <p>
     * #@ENJOY!
     */

    public static void main(String[] args) throws SQLException {

        Messages.startApplication();
        boolean cannotProceed = true;
        Scanner scanner = new Scanner(System.in);
        String input;

        while (cannotProceed) {
            Messages.hoofdMenu();
            input = scanner.nextLine();

            if (isInputNotCorrect(input) || !isOptionCorrect(input)) {
                Messages.error1();
            } else {
                if (input.trim().equalsIgnoreCase("1")) {
                    cannotProceed = false;
                    Messages.goodbye();
                    break;
                } else if (input.trim().equalsIgnoreCase("2")) {
                    //kookcursus
                    KookCursusService kookCursusService = new KookCursusService();
                    kookCursusService.perform(scanner);
                } else if (input.trim().equalsIgnoreCase("3")) {
                    //inschrijven
                    DeelnemersService deelnemersService = new DeelnemersService();
                    deelnemersService.perform(scanner);
                } else if (input.trim().equalsIgnoreCase("4")) {
                    //klanten bestand
                    KlantenBestandService klantenBestandService = new KlantenBestandService();
                    klantenBestandService.perform(scanner);
                } else if (input.trim().equalsIgnoreCase("5")) {
                    //prestaties
                    PrestatieService prestatieService = new PrestatieService();
                    prestatieService.perform(scanner);
                } else if (input.trim().equalsIgnoreCase("6")) {
                    //schulden
                    SchuldenService schuldenService = new SchuldenService();
                    schuldenService.perform(scanner);
                }
            }
        }

        scanner.reset();
        scanner.close();
        Messages.finished();

    }
}
