import java.util.Scanner;

public class UtenteMacchinetta {
    public static void main(String[] args) {
        //apro scanner
        Scanner scanner = new Scanner(System.in);
        // variabili
        double soldiUtente = 0, resto = 0, bilancioMacchinetta = 100;
        int[] quantitaProd = {3, 7, 10, 2, 5};
        String[] codiceProd = {"111", "222", "333", "444", "555"};
        double[] prezziProd = {2, 2.5, 1.50, 3.50, 1};
        String codiceInserito;
        boolean indiceProd = false;
        int i;
        // inizio loop
        do {
            // input selezione prodotto utente
            System.out.print("Selezionare codice prodotto (o C per uscire): ");
            codiceInserito = scanner.nextLine();
            // per uscire
            if (codiceInserito.equalsIgnoreCase("c")) {
                System.out.println("Arrivederci!");
                break ;
            }
            // cicla attraverso l'array di codice prodotto per vedere se c'è una corrispondenza
            for (i = 0; i < codiceProd.length; i++) {
                // in caso positivo
                if (codiceProd[i].equalsIgnoreCase(codiceInserito)) {
                    indiceProd = true;
                    // controlla se c'è il prodotto
                    if (quantitaProd[i] >= 1) {
                        System.out.println("Il prezzo del prodotto è " + prezziProd[i] + "€.");
                        System.out.print("Inserire l'importo richiesto: ");
                        // ciclo inserimento monete
                        do {
                            // importo inserito dall'utente
                            soldiUtente += scanner.nextDouble();
                            scanner.nextLine();
                            // se soldi sufficienti
                            if (soldiUtente >= prezziProd[i]) {
                                quantitaProd[i] -= 1;
                                resto = soldiUtente - prezziProd[i];
                                bilancioMacchinetta += prezziProd[i];
                                System.out.println("Resto: " + resto + "€.");
                                resto = 0;
                                soldiUtente = 0;
                            } else { // se soldi non sufficienti
                                System.out.println("Importo insufficiente. Insirerire denaro.");
                            }
                            // chiede di inserire più soldi fino ad arrivare all'importo necessario
                        } while (soldiUtente < prezziProd[i]);
                    } else { // in caso non ci sia la quantità disponibile
                        System.out.println("Quantità non disponibile.");
                    }
                }
            } // in caso negativo
            if (!indiceProd) {
                System.out.println("Prodotto non trovato.");
            }
            System.out.println("Arrivederci!");
        } while (true);
    }
}
