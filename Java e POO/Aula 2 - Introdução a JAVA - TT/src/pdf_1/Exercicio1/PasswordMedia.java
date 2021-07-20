package pdf_1.Exercicio1;

public class PasswordMedia extends Senha{
    public PasswordMedia() {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public static class main {
        public static void main (String args[]) throws InvalidPasswordException {
            PasswordFraca fraca = new PasswordFraca();
            PasswordMedia media = new PasswordMedia();
            PasswordForte forte = new PasswordForte();
        }
    }
}
