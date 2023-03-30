package com.unasat.utility;

public class Messages {

    public static void startApplication(){
        System.out.println("############ Mildred's Kookschool ##############");
    }

    public static void next(){
        System.out.println("#################################################");
    }

    public static void goodbye(){
        System.out.println("############ Fijne Dag! #########################");
    }

    public static void finished() {
        System.out.println("######################## FINISHED #########################");
    }

    public static void hoofdMenu(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Sluiten");
        System.out.println("2. Kook Cursus");
        System.out.println("3. Inschrijven");
        System.out.println("4. Klanten bestand");
        System.out.println("5. Prestaties");
        System.out.println("6. Openstaande Rekeningen");
    }

    public static void subMenuKookCursus(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Terug");
        System.out.println("2. Toevoegen");
        System.out.println("3. Bewerken");
        System.out.println("4. Verwijderen");
        System.out.println("5. Overzicht Kook cursus");
    }

    public static void toevoegenKookCursus() {
        System.out.println("-- Type 'exit' om terug te gaan naar de kookcursus submenu --");
        System.out.println("Vul in: cursus naam, cursus code, looptijd, start datum (Date format = 'yyyy/MM/dd'), bedrag (vb. 25.00)");
        System.out.println("vb: cursusNaam-cursusCode-looptijd-startDatum-bedrag");
    }

    public static void bewerkenKookCursus() {
        System.out.println("-- Type 'exit' om terug te gaan naar de kookcursus submenu --");
        System.out.println("Vul in: id, cursus naam, cursus code, looptijd, start datum (Date format = 'yyyy/MM/dd'), verlopen (0=nee, 1=ja), bedrag (vb. 25.00)");
        System.out.println("vb: id-cursusNaam-cursusCode-looptijd-startDatum-verlopen-bedrag");
    }

    public static void verwijderenKookCursus() {
        System.out.println("-- Type 'exit' om terug te gaan naar de kookcursus submenu --");
        System.out.println("Vul in: id of the kookcursus");
        System.out.println("vb: id-");
    }

    public static void subMenuInschrijvingen(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Terug");
        System.out.println("2. Toevoegen");
    }

    public static void deelnemerInschrijven(){
        System.out.println("-- Type 'exit' om terug te gaan naar de inschrijf submenu --");
        System.out.println("Vul in: naam, voornaam, geboorte datum (vb. yyyy/MM/dd), gender (M=Man, V=Vrouw), betaald bedrag (vb. 25.00), KookcursusCode");
        System.out.println("vb: naam-voornaam-geboorteDatum-gender-betaaldBedrag-KookcursusCode");
    }

    public static void verwijderenDeelnemer() {
        System.out.println("-- Type 'exit' om terug te gaan naar de kookcursus submenu --");
        System.out.println("Vul in: id of the kookcursus");
        System.out.println("vb: id-");
    }

    public static void subMenuKlantenBestand(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Terug");
        System.out.println("2. Bewerken");
        System.out.println("3. Verwijderen");
    }

    public static void bewerkenKlantenBestand(){
        System.out.println("-- Type 'exit' om terug te gaan naar het klantenbestand submenu --");
        System.out.println("Vul in: naam, voornaam, geboorte datum (vb. yyyy/MM/dd), gender (M=Man, V=Vrouw), betaald bedrag (vb. 25.00), id");
        System.out.println("vb: naam-voornaam-geboorteDatum-gender-betaaldBedrag-id");
    }

    public static void subMenuPrestaties(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Terug");
        System.out.println("2. Prestatie per persoon");
        System.out.println("3. Prestatie per cursus");
    }

    public static void subMenuOpenstaandeRekening(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Terug");
        System.out.println("2. Openstaande rekeningen bekijken");
        System.out.println("3. Openstaande rekeningen per persoon");
        System.out.println("4. Openstaande rekeningen per cursus");
        System.out.println("5. Openstaande rekeningen updaten");
    }

    public static void subMenuPrestatie(){
        System.out.println("Kies een actie door de nummer in te voeren: ");
        System.out.println("1. Terug");
        System.out.println("2. Prestatie bekijken");
    }

    public static void error1() {
        System.out.println("Vul aub de juiste input in.");
    }

    public static void error2(String message) {
        System.out.println("Fout: " +  message);
    }

    public static void header() {
        System.out.println("====================================================================================================");
        System.out.println("ID" + " - " + "Naam" + " - " + "Voornaam" + " - " + "Cursus Naam" + " - " + "Cursus Code" + " - " + "Prijs" + " - " + "Betaald Bedrag" + " - " + "Rest Bedrag" + " - " + "Resultaat");
        System.out.println("====================================================================================================");
    }

    public static void headerPrestaties() {
        System.out.println("====================================================================================================");
        System.out.println("Naam" + " - " + "Voornaam" + " - " + "Cursus Naam" + " - " + "Cursus Code" + " - " + "Resultaat");
        System.out.println("====================================================================================================");
    }

    public static void headerKookcursus() {
        System.out.println("====================================================================================================");
        System.out.println("ID" + " - " + "Naam" + " - " + "Code" + " - " + "Looptijd" + " - " + "Startdatum" + " - " + "Bedrag");
        System.out.println("====================================================================================================");
    }

    public static void openStaandeRekeningPerPersoon() {
        System.out.println("-- Type 'exit' om terug te gaan naar de openstaande rekeningen submenu --");
        System.out.println("Vul in: naam, voornaam, kookcursus code");
        System.out.println("vb: naam-voornaam-kookcursus code");
    }

    public static void openStaandeRekeningBekijken() {
        System.out.println("-- Type 'exit' om terug te gaan naar de openstaande rekeningen submenu --");
        System.out.println("1. Overzicht openstaande rekeningen ");
    }

    public static void prestatieBekijken() {
        System.out.println("-- Type 'exit' om terug te gaan naar de prestatie submenu --");
        System.out.println("1. Overzicht prestatie");
    }

    public static void kookCursusBekijken() {
        System.out.println("-- Type 'exit' om terug te gaan naar de kook cursus submenu --");
        System.out.println("1. Overzicht kook cursus ");
    }

    public static void openStaandeRekeningPerCursus() {
        System.out.println("-- Type 'exit' om terug te gaan naar de openstaande rekeningen submenu --");
        System.out.println("Vul in: kookcursus code");
        System.out.println("vb: kookcursus code-");
    }

    public static void openStaandeRekeningUpdate() {
        System.out.println("-- Type 'exit' om terug te gaan naar de openstaande rekeningen submenu --");
        System.out.println("Vul in: deelnemer ID, cursus ID, restbedrag (vb. 2345.00");
        System.out.println("vb: deelnemerID-cursusID-restbedrag");
    }
}
