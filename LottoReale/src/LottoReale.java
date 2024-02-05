import java.util.Scanner;
import java.util.Random;

public class LottoReale {
    public static void main(String[] args) {
        // Oggetto Scanner per la lettura dell'input
        Scanner tastiera = new Scanner(System.in);

        // Array di opzioni per il menu
        String[] opzioni = {"Gioco Del Lotto", "[1] Scelta Ruote", "[2] Inserimento Giocate", "[3] Puntate", "[4] Estrai e Visualizza Risultati", "[5] Exit"};

        // Flag per controllare la fine del programma o di una sua porzione
        boolean fine = false, exitRuote = false;

        // Flag per verificare se sono stati effettuati i passaggi
        boolean ruote = false, giocate = false, puntate = false;

        // Flag per verificare quali ruote sono state scelte dall'utente
        boolean bari = false, cagliari = false, firenze = false, genova = false, milano = false, napoli = false, palermo = false, roma = false, torino = false, venezia = false, nazionale = false;

        // Variabile che contiene la quantità di soldi dell'utente
        double soldi=0;

        // Array per memorizzare i numeri estratti
        int[] estrattiBari, estrattiCagliari, estrattiFirenze, estrattiGenova, estrattiMilano, estrattiNapoli, estrattiPalermo, estrattiRoma, estrattiTorino, estrattiVenezia, estrattiNazionale;

        // Contatore che conta quante ruote sono state scelte (se si arriva ad 11, il numero massimo di ruote, si esce dalla scelta)
        int contaRuote=0;

        // Dichiarazione dell'array numeriGiocati
        int[] numeriGiocati = null;
        do {
            // Switch-case per gestire le opzioni del menu
            switch (menu(opzioni, tastiera)) {
                // Case 1: Scelta Ruote.
                case 1:
                    SceltaRuote(ruote, exitRuote, contaRuote, tastiera, bari, cagliari, firenze, genova, milano, napoli, palermo, roma, torino, venezia, nazionale );
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
                        // Esegui l'estrazione dei numeri
                        estrattiBari = estraiNumeri();

                        System.out.println("Visualizzazione Ruota Venezia");
                        // Visualizza i numeri estratti
                        VisualizzaNumeri(estrattiBari);
                        Wait(2000);
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
    private static void SceltaRuote(boolean ruote, boolean exitRuote, int contaRuote, Scanner tastiera, boolean bari, boolean cagliari, boolean firenze, boolean genova, boolean milano, boolean napoli, boolean palermo, boolean roma, boolean torino, boolean venezia, boolean nazionale ){
        if (ruote){
            System.out.println("Hai già scelto su quali ruote puntare!");
            Wait(2000);
            ClrScr();
        }else {
            while (!exitRuote && contaRuote<11){
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
    private static void SceltaPuntate(boolean puntate, Scanner tastiera, double soldi, int[] numeriGiocati){
        double puntata, estratto;
        if (puntate) {
            System.out.println("Hai già scelto su cosa puntare!");
            Wait(2000);
            ClrScr();
        }else{
            if (numeriGiocati.length==1){
                System.out.println("Puoi puntare solo su Estratto. Quanto vuoi puntare?\n");
                puntata = tastiera.nextDouble();
                estratto = puntata;
            }else if (numeriGiocati.length==2){
                //uaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcvuaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcvuaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcvuaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcvuaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcvuaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcvuaduidwubyfawfWBUFAVYFAGYUVFAYUVFAGFVAWUVuytxcvbhgvcxcvbvcxcv
            }
            System.out.println("Quanto vuoi puntare?\n");
            puntata = tastiera.nextDouble();

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


