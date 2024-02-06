import java.util.Scanner;
import java.util.Random;

public class LottoReale {
    public static void main(String[] args) {
        // Oggetto Scanner per la lettura dell'input
        Scanner tastiera = new Scanner(System.in);

        // Array di opzioni per il menu
        String[] opzioni = {"Gioco Del Lotto", "[1] Scelta Ruote", "[2] Inserimento Giocate", "[3] Puntate", "[4] Estrai e Visualizza Vincite", "[5] Exit"};

        // Flag per controllare la fine del programma o di una sua porzione
        boolean fine = false, exitRuote = false;

        // Flag per verificare se sono stati effettuati i passaggi
        boolean ruote = false, giocate = false, puntate = false;

        // Flag per verificare quali ruote sono state scelte dall'utente
        boolean bari = false, cagliari = false, firenze = false, genova = false, milano = false, napoli = false, palermo = false, roma = false, torino = false, venezia = false, nazionale = false;

        // Variabile che contiene la quantità di soldi dell'utente
        double soldi=0;

        // Array per memorizzare i numeri estratti
        int[] estrattiBari = new int[5], estrattiCagliari = new int[5], estrattiFirenze = new int[5], estrattiGenova = new int[5], estrattiMilano = new int[5], estrattiNapoli = new int[5], estrattiPalermo = new int[5], estrattiRoma = new int[5], estrattiTorino = new int[5], estrattiVenezia = new int[5], estrattiNazionale = new int[5];

        // Contatore che conta quante ruote sono state scelte (se si arriva ad 11, il numero massimo di ruote, si esce dalla scelta)
        int contaRuote=0;
        int ruoteTrue=0;

        // Dichiarazione dell'array numeriGiocati
        int[] numeriGiocati = null;
        do {
            // Switch-case per gestire le opzioni del menu
            switch (menu(opzioni, tastiera)) {
                // Case 1: Scelta Ruote.
                case 1:
                    SceltaRuote(ruote, exitRuote, contaRuote, ruoteTrue, tastiera, bari, cagliari, firenze, genova, milano, napoli, palermo, roma, torino, venezia, nazionale );
                    ruote = true;
                    break;
                // Case 2: Inserimento dei numeri giocati dall'utente
                case 2:
                    numeriGiocati = NumeriUtente(giocate, tastiera);
                    giocate = true;
                    break;
                case 3:
                    if (!giocate){
                        System.out.println("Devi prima inserire la tua giocata (Opzione 2).");
                    }else {
                        SceltaPuntate(puntate, tastiera, soldi, numeriGiocati);
                        puntate = true;
                    }
                    break;
                case 4:
                    if (!ruote) {
                        System.out.println("Devi prima scegliere le ruote (Opzione 1).");
                        Wait(2000);
                    } else if (!giocate) {
                        System.out.println("Devi prima inserire la tua giocata (Opzione 2).");
                        Wait(2000);
                    } else if (!puntate){
                        System.out.println("Devi prima puntare (Opzione 3).");
                        Wait(2000);
                    }else{
                        System.out.println("Estrazioni");
                        Wait(2000);
                        Estrazioni(estrattiBari, estrattiCagliari, estrattiFirenze, estrattiGenova, estrattiMilano, estrattiNapoli, estrattiPalermo, estrattiRoma, estrattiTorino, estrattiVenezia, estrattiNazionale, bari, cagliari, firenze, genova, milano, napoli, palermo, roma, torino, venezia, nazionale);
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    // Imposta il flag per terminare il programma
                    fine = true;
                    break;
            }
        } while (!fine);
    }

    // Metodo per gestire il menu e restituire la scelta dell'utente
    private static int menu(String[] opzioni, Scanner tastiera) {
        int scelta;
        do {
            ClrScr();
            System.out.println("----" + opzioni[0] + "----");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            System.out.println("------------");
            // Legge la scelta dell'utente
            scelta = tastiera.nextInt();
            // Controlla se la scelta è valida, altrimenti richiede l'input
            if (!(scelta >= 1 && scelta <= opzioni.length)) {
                System.out.println("Scelta errata");
            }
            Wait(2000);
        } while (!(scelta >= 1 && scelta <= opzioni.length));
        return scelta;
    }

    // Metodo per scegliere le ruote
    private static void SceltaRuote(boolean ruote, boolean exitRuote, int contaRuote, int ruoteTrue, Scanner tastiera, boolean bari, boolean cagliari, boolean firenze, boolean genova, boolean milano, boolean napoli, boolean palermo, boolean roma, boolean torino, boolean venezia, boolean nazionale ){
        if (ruote){
            System.out.println("Hai già scelto su quali ruote puntare!");
            Wait(2000);
            ClrScr();
        }else {
            while (!exitRuote && contaRuote<11){
                ClrScr();
                System.out.println("Su quali ruote vuoi puntare?\n Inserire il nome delle ruote,\n''TUTTE'' per selezionare tutte le ruote tranne la nazionale,\n poi digitare ''exit'' per uscire\n Puoi scegliere fra:");
                VisualizzaRuote( bari, cagliari, firenze, genova, milano, napoli, palermo, roma, torino, venezia, nazionale);
                String sceltaRuote = tastiera.nextLine();
                switch (sceltaRuote){
                    case "Bari":
                        if (bari){
                            System.out.println("Hai già scelto la ruota Bari!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            bari = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Bari");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Cagliari":
                        if (cagliari){
                            System.out.println("Hai già scelto la ruota Cagliari!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            cagliari = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Cagliari");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Firenze":
                        if (firenze){
                            System.out.println("Hai già scelto la ruota Firenze!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            firenze = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Firenze");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Genova":
                        if (genova){
                            System.out.println("Hai già scelto la ruota Genova!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            genova = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Genova");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Milano":
                        if (milano){
                            System.out.println("Hai già scelto la ruota Milano!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            milano = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Milano");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Napoli":
                        if (napoli){
                            System.out.println("Hai già scelto la ruota Napoli!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            napoli = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Napoli");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Palermo":
                        if (palermo){
                            System.out.println("Hai già scelto la ruota Palermo!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            palermo = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Palermo");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Roma":
                        if (roma){
                            System.out.println("Hai già scelto la ruota Roma!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            roma = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Roma");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Torino":
                        if (torino){
                            System.out.println("Hai già scelto la ruota Torino!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            torino = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Torino");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Venezia":
                        if (venezia){
                            System.out.println("Hai già scelto la ruota Venezia!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            venezia = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Venezia");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "Nazionale":
                        if (nazionale){
                            System.out.println("Hai già scelto la ruota Nazionale!");
                            Wait(2000);
                            ClrScr();
                        }else {
                            nazionale = true;
                            contaRuote++;
                            ruoteTrue++;
                            System.out.println("Hai scelto la ruota Nazionale");
                            Wait(2000);
                            ClrScr();
                        }
                        break;
                    case "TUTTE":
                        if (bari || cagliari || firenze || genova || milano || napoli || palermo || roma || torino || venezia || nazionale){
                            System.out.println("Non puoi selezionare TUTTE in quanto hai già selezionato una ruota");
                        }else{
                            bari = true;
                            cagliari = true;
                            firenze = true;
                            genova = true;
                            milano = true;
                            napoli = true;
                            palermo = true;
                            roma = true;
                            torino = true;
                            venezia = true;
                            nazionale = false;
                            contaRuote=11;
                            ruoteTrue=10;
                            System.out.println("Hai scelto TUTTE");
                        }
                        Wait(2000);
                        ClrScr();
                        break;
                    case "exit":
                        if (contaRuote==0){
                            System.out.println("Devi selezionare almeno una ruota su cui puntare!");
                        }else {
                            exitRuote = true;
                        }
                        break;
                    default:
                        System.out.println("Hai inserito un nome invalido.");
                }
            }
            if (contaRuote==11) {
                System.out.println("Hai selezionato tutte le ruote.\nUscita dalla selezione");
                Wait(2000);
                ClrScr();
            }else if (contaRuote==1){
                System.out.println("Uscita dalla selezione. Hai selezionato la seguente ruota:");
                VisualizzaRuote(!bari, !cagliari, !firenze, !genova, !milano, !napoli, !palermo, !roma, !torino, !venezia, !nazionale);
                Wait(2000);
                ClrScr();
            }else{
                System.out.println("Uscita dalla selezione. Hai selezionato le seguenti ruote:");
                VisualizzaRuote(!bari, !cagliari, !firenze, !genova, !milano, !napoli, !palermo, !roma, !torino, !venezia, !nazionale);
                Wait(2000);
                ClrScr();
            }
        }
    }

    // Metodo per stampare quali ruote non sono ancora state selezionate/quali ruote sono state selezionate
    private static void VisualizzaRuote(boolean bari, boolean cagliari, boolean firenze, boolean genova, boolean milano, boolean napoli, boolean palermo, boolean roma, boolean torino, boolean venezia, boolean nazionale){
        if (!bari)
            System.out.println("Bari");
        if (!cagliari)
            System.out.println("Cagliari");
        if (!firenze)
            System.out.println("Firenze");
        if (!genova)
            System.out.println("Genova");
        if (!milano)
            System.out.println("Milano");
        if (!napoli)
            System.out.println("Napoli");
        if (!palermo)
            System.out.println("Palermo");
        if (!roma)
            System.out.println("Roma");
        if (!torino)
            System.out.println("Torino");
        if (!venezia)
            System.out.println("Venezia");
        if (!nazionale)
            System.out.println("Nazionale");
    }

    // Metodo per l'inserimento dei numeri da giocare da parte dell'utente
    private static int[] NumeriUtente(boolean giocate, Scanner tastiera){
        int[] numeriGiocati= new int[0];
        if (giocate) {
            System.out.println("Hai già scelto quali numeri puntare!");
            Wait(2000);
            ClrScr();
        }else{
            int nNumeri;
            boolean controllo;
            do {
                ClrScr();
                System.out.println("Quanti numeri vuoi puntare?\n Inserisici un numero da 1 a 5:");
                controllo = false;
                nNumeri = tastiera.nextInt();
                if (nNumeri <=0 || nNumeri >=6) {
                    System.out.println("Inserisci un numero valido!");
                    controllo = true;
                    Wait(2000);
                    ClrScr();
                }
            }while (nNumeri==0 || controllo);
            // Assegnazione grandezza array numeri giocati dall'utente
            numeriGiocati = new int[nNumeri];
            for (int i=0; i<nNumeri; i++){
                ClrScr();
                do {
                    System.out.println("Inserisci il "+(i+1)+"° numero da 1 a 90 da puntare");
                    numeriGiocati[i] = tastiera.nextInt();
                    controllo = false;
                    if (numeriGiocati[i]<1 || numeriGiocati[i]>90) {
                        System.out.println("Inserisci un numero valido!");
                        Wait(2000);
                    }
                    for (int j = 0; j < i; j++) {
                        if (numeriGiocati[i] == numeriGiocati[j]) {
                            System.out.println("Hai già inserito questo numero!");
                            j = 0;
                            i = 0;
                            controllo = true;
                        }
                    }
                }while (numeriGiocati[i]<1 || numeriGiocati[i]>90 || controllo);
            }
            ClrScr();
            System.out.println("Hai giocato i seguenti numeri:");
            for (int i : numeriGiocati) {
                System.out.println(i);
            }
        }
        return numeriGiocati;
    }

    // Metodo che permette di scegliere su cose puntare e quanto puntare
    private static void SceltaPuntate(boolean puntate, Scanner tastiera, double soldi, int[] numeriGiocati) {
        double puntata, estratto = 0, ambo = 0, terna = 0, quaterna = 0, cinquina = 0;
        int numeri = numeriGiocati.length;
        boolean ripuntare = false, estrattoB = false, amboB = false, ternaB = false, quaternaB = false, cinquinaB = false;
        String siNo, scelta;
        if (puntate) {
            System.out.println("Hai già scelto su cosa puntare!");
            Wait(2000);
            ClrScr();
        } else {
            do {
                if (numeri == 1) {
                    if (!estrattoB) {
                        System.out.println("Puoi puntare solo su Estratto. Quanto vuoi puntare?\n");
                        puntata = tastiera.nextDouble();
                        estratto = puntata;
                        numeri--;
                        estrattoB = true;
                    }
                } else if (numeri == 2) {
                    System.out.println("Puoi puntare su Estratto ed Ambo. Su cosa vuoi puntare?\n");
                    scelta = tastiera.nextLine();
                    if (scelta.equals("Estratto")) {
                        if (!estrattoB) {
                            System.out.println("Stai puntando su Estratto. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            estratto = puntata;
                            numeri--;
                            estrattoB = true;
                        } else {
                            System.out.println("Hai già puntato su Estratto!\n");
                        }
                    } else if (scelta.equals("Ambo")) {
                        if (!amboB) {
                            System.out.println("Stai puntando su Ambo. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            ambo = puntata;
                            numeri--;
                            amboB = true;
                        } else {
                            System.out.println("Hai già puntato su Ambo!\n");
                        }
                    }
                } else if (numeri == 3) {
                    System.out.println("Puoi puntare su Estratto, Ambo e Terna. Su cosa vuoi puntare?\n");
                    scelta = tastiera.nextLine();
                    if (scelta.equals("Estratto")) {
                        if (!estrattoB) {
                            System.out.println("Stai puntando su Estratto. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            estratto = puntata;
                            numeri--;
                            estrattoB = true;
                        } else {
                            System.out.println("Hai già puntato su Estratto!\n");
                        }
                    } else if (scelta.equals("Ambo")) {
                        if (!amboB) {
                            System.out.println("Stai puntando su Ambo. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            ambo = puntata;
                            numeri--;
                            amboB = true;
                        } else {
                            System.out.println("Hai già puntato su Ambo!\n");
                        }
                    } else if (scelta.equals("Terna")) {
                        if (!ternaB) {
                            System.out.println("Stai puntando su Terna. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            terna = puntata;
                            numeri--;
                            ternaB = true;
                        } else {
                            System.out.println("Hai già puntato su Terna!\n");
                        }
                    }
                } else if (numeri == 4) {
                    System.out.println("Puoi puntare su Estratto, Ambo, Terna e Quaterna. Su cosa vuoi puntare?\n");
                    scelta = tastiera.nextLine();
                    if (scelta.equals("Estratto")) {
                        if (!estrattoB) {
                            System.out.println("Stai puntando su Estratto. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            estratto = puntata;
                            numeri--;
                            estrattoB = true;
                        } else {
                            System.out.println("Hai già puntato su Estratto!\n");
                        }
                    } else if (scelta.equals("Ambo")) {
                        if (!amboB) {
                            System.out.println("Stai puntando su Ambo. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            ambo = puntata;
                            numeri--;
                            amboB = true;
                        } else {
                            System.out.println("Hai già puntato su Ambo!\n");
                        }
                    } else if (scelta.equals("Terna")) {
                        if (!ternaB) {
                            System.out.println("Stai puntando su Terna. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            terna = puntata;
                            numeri--;
                            ternaB = true;
                        } else {
                            System.out.println("Hai già puntato su Terna!\n");
                        }
                    } else if (scelta.equals("Quaterna")) {
                        if (!quaternaB) {
                            System.out.println("Stai puntando su Quaterna. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            quaterna = puntata;
                            numeri--;
                            quaternaB = true;
                        } else {
                            System.out.println("Hai già puntato su Quaterna!\n");
                        }
                    }
                } else if (numeri == 5) {
                    System.out.println("Puoi puntare su Estratto, Ambo, Terna, Quaterna e Cinquina. Su cosa vuoi puntare?\n");
                    scelta = tastiera.nextLine();
                    if (scelta.equals("Estratto")) {
                        if (!estrattoB) {
                            System.out.println("Stai puntando su Estratto. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            estratto = puntata;
                            numeri--;
                            estrattoB = true;
                        } else {
                            System.out.println("Hai già puntato su Estratto!\n");
                        }
                    } else if (scelta.equals("Ambo")) {
                        if (!amboB) {
                            System.out.println("Stai puntando su Ambo. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            ambo = puntata;
                            numeri--;
                            amboB = true;
                        } else {
                            System.out.println("Hai già puntato su Ambo!\n");
                        }
                    } else if (scelta.equals("Terna")) {
                        if (!ternaB) {
                            System.out.println("Stai puntando su Terna. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            terna = puntata;
                            numeri--;
                            ternaB = true;
                        } else {
                            System.out.println("Hai già puntato su Terna!\n");
                        }
                    } else if (scelta.equals("Quaterna")) {
                        if (!quaternaB) {
                            System.out.println("Stai puntando su Quaterna. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            quaterna = puntata;
                            numeri--;
                            quaternaB = true;
                        } else {
                            System.out.println("Hai già puntato su Quaterna!\n");
                        }
                    } else if (scelta.equals("Cinquina")) {
                        if (!cinquinaB) {
                            System.out.println("Stai puntando su Cinquina. Quanto vuoi puntare?\n");
                            puntata = tastiera.nextDouble();
                            cinquina = puntata;
                            numeri--;
                            cinquinaB = true;
                        } else {
                            System.out.println("Hai già puntato su Cinquina!\n");
                        }
                    }
                }
                if (numeri > 1) {
                    tastiera.nextLine(); // Pulizia del buffer di input
                    System.out.println("Vuoi puntare su qualcos'altro? S/N\n");
                    siNo = tastiera.nextLine();
                    if (siNo.equalsIgnoreCase("S")) { // Utilizziamo equalsIgnoreCase per ignorare la distinzione tra maiuscole e minuscole
                        ripuntare = true;
                    } else {
                        ripuntare = false;
                    }
                }
            } while (numeri > 0 || ripuntare);
            soldi = soldi - (estratto + ambo + terna + quaterna + cinquina);
        }
    }

    private static void Estrazioni(int[] estrattiBari,int[] estrattiCagliari,int[] estrattiFirenze,int[] estrattiGenova,int[] estrattiMilano,int[] estrattiNapoli,int[] estrattiPalermo,int[] estrattiRoma,int[] estrattiTorino,int[] estrattiVenezia,int[] estrattiNazionale, boolean bari, boolean cagliari, boolean firenze, boolean genova, boolean milano, boolean napoli, boolean palermo, boolean roma, boolean torino, boolean venezia, boolean nazionale){
        // Esegui l'estrazione dei numeri per ogni ruota selezionata
        if (bari){
            estrattiBari = estraiNumeri();
            System.out.println("Visualizzazione Ruota Bari");
            VisualizzaNumeri(estrattiBari);
            Wait(2000);
        }
        if (cagliari) {
            estrattiCagliari = estraiNumeri();
            System.out.println("Visualizzazione Ruota Cagliari");
            VisualizzaNumeri(estrattiCagliari);
            Wait(2000);
        }
        if (firenze) {
            estrattiFirenze = estraiNumeri();
            System.out.println("Visualizzazione Ruota Firenze");
            VisualizzaNumeri(estrattiFirenze);
            Wait(2000);
        }
        if (genova) {
            estrattiGenova = estraiNumeri();
            System.out.println("Visualizzazione Ruota Genova");
            VisualizzaNumeri(estrattiGenova);
            Wait(2000);
        }
        if (milano) {
            estrattiMilano = estraiNumeri();
            System.out.println("Visualizzazione Ruota Milano");
            VisualizzaNumeri(estrattiMilano);
            Wait(2000);
        }
        if (napoli) {
            estrattiNapoli = estraiNumeri();
            System.out.println("Visualizzazione Ruota Napoli");
            VisualizzaNumeri(estrattiNapoli);
            Wait(2000);
        }
        if (palermo) {
            estrattiPalermo = estraiNumeri();
            System.out.println("Visualizzazione Ruota Palermo");
            VisualizzaNumeri(estrattiPalermo);
            Wait(2000);
        }
        if (roma) {
            estrattiRoma = estraiNumeri();
            System.out.println("Visualizzazione Ruota Roma");
            VisualizzaNumeri(estrattiRoma);
            Wait(2000);
        }
        if (torino) {
            estrattiTorino = estraiNumeri();
            System.out.println("Visualizzazione Ruota Torino");
            VisualizzaNumeri(estrattiTorino);
            Wait(2000);
        }
        if (venezia) {
            estrattiVenezia = estraiNumeri();
            System.out.println("Visualizzazione Ruota Venezia");
            VisualizzaNumeri(estrattiVenezia);
            Wait(2000);
        }
        if (nazionale) {
            estrattiNazionale = estraiNumeri();
            System.out.println("Visualizzazione Ruota Nazionale");
            VisualizzaNumeri(estrattiNazionale);
            Wait(2000);
        }

    }

    // Metodo per estrarre 5 numeri casuali tra 1 e 90 senza ripetizioni
    private static int[] estraiNumeri() {
        Random casuale = new Random();
        int[] nEstratti = new int[5];

        for (int i = 0; i < nEstratti.length; i++) {
            nEstratti[i] = casuale.nextInt(90) + 1;

            // Verifica che il numero estratto non sia già presente nell'array
            for (int j = 0; j < i; j++) {
                while (nEstratti[i] == nEstratti[j]) {
                    nEstratti[i] = casuale.nextInt(90) + 1;
                    j = 0;
                }
            }
        }
        return nEstratti;
    }

    // Metodo per visualizzare i numeri estratti
    private static void VisualizzaNumeri(int[] nEstratti) {
        for (int numero : nEstratti) {
            System.out.println(numero + "\n");
        }
    }

    // Metodo per pulire lo schermo della console
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo per attendere per un periodo specificato in millisecondi
    private static void Wait(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
