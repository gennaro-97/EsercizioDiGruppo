import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App_final {
    public static void main(String[] args) {

        Registro_Utenti registro = new Registro_Utenti();


        int scelta = 0;
        do{
            scelta = printMenuIniziale();
            switch (scelta) {
                case 1:
                Utente utente = login(registro);
                    if(utente != null){
                        secondomenu(utente);
                    }
                    else{
                        System.out.println("Login fallito");
                    }
                    break;
                case 2:
                    registrazione(registro);
                    break;
                case 3:
                    registro.print();
                    break;
                case 4:
                    System.out.println("Arrivederci");
                    return;
                default:
                    System.out.println("Scelta non valida");
            }
        }while (scelta != 4); 

    }

    // print del menu iniziale return scelta utente (int)
    public static int printMenuIniziale() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu iniziale");
        System.out.println("1. Login");
        System.out.println("2. Registrazione");
        System.out.println("3. Stampa registro utenti");
        System.out.println("4. Esci");
        int scelta = scanner.nextInt();

        scanner.close();
        return scelta;
    }

    public static Utente login(Registro_Utenti registro) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci nome utente");
        String nome = scanner.nextLine();
        System.out.println("Inserisci password");
        String password = scanner.nextLine();
        return registro.login(nome, password);
    }

    public static void registrazione(Registro_Utenti registro){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci nome utente");
        String nome = scanner.nextLine();
        System.out.println("Inserisci password");
        String password = scanner.nextLine();
        registro.registrazione(nome, password);
        scanner.close();
    }

    public static void stampaRegistro(Registro_Utenti registro){
        registro.stampa();
    }

    public static void secondomenu(Utente utente){
        int scelta = 0;
        do{
        System.out.println("1. Modifica profilo");
        System.out.println("2. Gioca");
        System.out.println("4. Esci");
        Scanner scanner = new Scanner(System.in);
        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                modificaProfilo(utente);
                break;
            case 2:
                gioca();
                break;
            case 4:
                System.out.println("Arrivederci");
                return;
            default:
                System.out.println("Scelta non valida");
        }
    }while(scelta != 4);
    }

    public static void modificaProfilo(Utente utente){
        int scelta = 0;
        do{
            System.out.println("1. Cambia password");
            System.out.println("2. Cambia username");
            System.out.println("3. Esci");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    utente.cambiaPassword();
                    break;
                case 2:
                    utente.cambiaUsername();
                    break;
                case 3:
                    System.out.println("Arrivederci");
                    return;
                default:
                    System.out.println("Scelta non valida");
            }
        }while(scelta != 3);
    }


}

// classe Utente
class Utente {
    String nome;
    String password;

    public Utente(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " Password: " + password;
    }

    public void cambiaPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci nuova password");
        String newPassword = scanner.nextLine();
        this.password = newPassword;
    }

    public void cambiaUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci nuovo username");
        String newNome = scanner.nextLine();
        this.nome = newNome;
    }

}

class Registro_Utenti {
    ArrayList<Utente> utenti = new ArrayList<Utente>();

    public void stampa() {
        for (Utente u : utenti) {
            System.out.println(u);
        }
    }

    public void registrazione(String nome, String password) {
        // controllo se l'utente è già registrato
        for (Utente u : utenti) {
            if (u.nome.equals(nome)) {
                System.out.println("Utente già registrato");
                return;
            }
        }
        Utente u = new Utente(nome, password);
        utenti.add(u);
        System.out.println("Utente registrato");
    }

    public Utente login(String nome, String password) {
        for (Utente u : utenti) {
            if (u.nome.equals(nome) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }

}

class GiocoMatematica {

    int livello = 1; // 1 facile 2 medio 3 difficile
    int punteggio = 0; // punteggio del giocatore

    public void start() {
        do {
            switch (livello) {
                case 1:
                    livelloFacile();
                    break;
                case 2:
                    livelloMedio();
                    break;
                case 3:
                    livelloDifficile();
                    break;
                case 4:
                    System.out.println("Punteggio finale: " + punteggio);
                    System.out.println("WIN!");
                    break;
                case -1:
                    System.out.println("Punteggio finale: " + punteggio);
                    System.out.println("GAME OVER!");
                    break;
                default:
                    System.out.println("Livello non valido");
            }
        } while (livello != -1 || livello != 4);
    }
        

        
    

    public void livelloFacile() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num1 = random.nextInt(1000);
        int num2 = random.nextInt(1000);
        int risposta = num1 + num2;
        System.out.println("Quanto fa " + num1 + " + " + num2 + " ?");
        // controllo risposta
        int risposta_utente = scanner.nextInt();
        if (risposta == risposta_utente) {
            System.out.println("Risposta corretta");
            punteggio += 10;
            livello++;
        } else {
            System.out.println("Risposta sbagliata");
            punteggio -= 5;
            livello = -1;
            return;
        }
    }

    public void livelloMedio() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num1 = random.nextInt(1000);
        int num2 = random.nextInt(1000);
        int risposta = num1 * num2;
        System.out.println("Quanto fa " + num1 + " - " + num2 + " ?");
        // controllo risposta
        int risposta_utente = scanner.nextInt();
        if (risposta == risposta_utente) {
            System.out.println("Risposta corretta");
            punteggio += 20;
            livello++;
        } else {
            System.out.println("Risposta sbagliata");
            punteggio -= 10;
            livello = -1;
            return;
        }
    }

    public void livelloDifficile() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num1 = random.nextInt(1000);
        int num2 = random.nextInt(1000);
        int risposta = num1 / num2;
        System.out.println("Quanto fa " + num1 + " / " + num2 + " ?");
        // controllo risposta
        int risposta_utente = scanner.nextInt();
        if (risposta == risposta_utente) {
            System.out.println("Risposta corretta");
            punteggio += 30;
            livello++;
        } else {
            System.out.println("Risposta sbagliata");
            punteggio -= 15;
            livello = -1;
            return;
        }
    }
}