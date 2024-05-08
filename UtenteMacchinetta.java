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
        do {
            System.out.print("Selezionare codice prodotto (o C per uscire): ");
            codiceInserito = scanner.nextLine();
            if (codiceInserito.equalsIgnoreCase("c")) {
                System.out.println("Arrivederci!");
                break ;
            }
            for (i = 0; i < codiceProd.length; i++) {
                if (codiceProd[i].equalsIgnoreCase(codiceInserito)) {
                    indiceProd = true;
                    if (quantitaProd[i] >= 1) {
                        System.out.println("Il prezzo del prodotto è " + prezziProd[i] + "€.");
                        System.out.print("Inserire l'importo richiesto: ");
                        do {
                            soldiUtente += scanner.nextDouble();
                            scanner.nextLine();
                            if (soldiUtente > prezziProd[i]) {
                                quantitaProd[i] -= 1;
                                resto = soldiUtente - prezziProd[i];
                                bilancioMacchinetta += prezziProd[i];
                                System.out.println("Resto: " + resto + "€.");
                                resto = 0;
                                soldiUtente = 0;
                            } else {
                                System.out.println("Importo insufficiente. Insirerire denaro.");
                            }
                        } while (soldiUtente < prezziProd[i]);
                    } else {
                        System.out.println("Quantità non disponibile.");
                    }
                }
            }
            if (!indiceProd) {
                System.out.println("Prodotto non trovato.");
            }
            System.out.println("Arrivederci!");
        } while (true);
    }
}
