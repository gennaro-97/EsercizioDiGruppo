import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App_final {
    public static void main(String[] args) {

        // creo un menu login e registrazione
        //
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

    public boolean login(String nome, String password) {
        for (Utente u : utenti) {
            if (u.nome.equals(nome) && u.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void changePassword(String nome, String password, String newPassword) {
        for (Utente u : utenti) {
            if (u.nome.equals(nome) && u.password.equals(password)) {
                u.password = newPassword;
                System.out.println("Password cambiata");
                return;
            }
        }
        System.out.println("Utente non trovato");
    }

    public void changeUsername(String nome, String password, String newNome) {
        for (Utente u : utenti) {
            if (u.nome.equals(nome) && u.password.equals(password)) {
                u.nome = newNome;
                System.out.println("Username cambiato");
                return;
            }
        }
        System.out.println("Utente non trovato");
    }
}

class GiocoMatematica{
    public void gioco(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num1 = random.nextInt(1000);
        int num2 = random.nextInt(1000);
        int risposta = num1 + num2;
        System.out.println("Quanto fa " + num1 + " + " + num2 + " ?");
        // controllo risposta
        int risposta_utente = scanner.nextInt();
        if(risposta == risposta_utente){
            System.out.println("Risposta corretta");
        }else{
            System.out.println("Risposta sbagliata");
            return;
        }

        
    }
}