package pdf_1.Exercicio1;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException() {
    }

    @Override
    public String getMessage(){
        return "Senha Inválida";
    }
}
