package pdf_1.Exercicio1;

public class Senha {
    private String regex;
    private String password;

    public Senha(String regex) {
        this.regex = regex;
    }

    public void setValue (String pwd) throws InvalidPasswordException {
        boolean match = pwd.matches(this.regex);

        if (match) {
            password = pwd;
        } else {
            throw new InvalidPasswordException();
        }
    }
}
