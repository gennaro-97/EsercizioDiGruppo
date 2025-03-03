import java.util.ArrayList;

public class App_final {
    public static void main(String[] args) {

        // creo un menu login e registrazione
        //
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