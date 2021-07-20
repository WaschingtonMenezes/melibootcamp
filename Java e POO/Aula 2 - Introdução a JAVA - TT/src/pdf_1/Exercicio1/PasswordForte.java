package pdf_1.Exercicio1;

public class PasswordForte extends Senha {
    public PasswordForte() {
        super("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}
