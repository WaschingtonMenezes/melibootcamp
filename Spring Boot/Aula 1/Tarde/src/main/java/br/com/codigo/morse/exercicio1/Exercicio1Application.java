package br.com.codigo.morse.exercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exercicio1Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercicio1Application.class, args);
    }

    @GetMapping("/translate")
    public String translateMorseCode(@RequestParam String message){
        StringBuilder decoded = new StringBuilder();
        for (String wordMorse : message.split("   ")){
            for (String letterMorse : wordMorse.split(" ")){
                decoded.append(alphabetMorse(letterMorse));
            }
            decoded.append(' ');
        }
        return decoded.toString();
    }

    private char alphabetMorse(String letter){
           switch(letter){
               case (".-") : return'A';
               case ("-...") : return'B';
               case ("-.-.") : return'C';
               case ("-..") : return'D';
               case (".") : return'E';
               case ("..-.") : return'F';
               case ("--.") : return'G';
               case ("....") : return'H';
               case ("..") : return'I';
               case (".---") : return'J';
               case ("-.-") : return'K';
               case (".-..") : return'L';
               case ("--"): return'M';
               case ("-."): return'N';
               case ("---"): return'O';
               case (".--."): return'P';
               case ("--.-"): return'Q';
               case (".-."): return'R';
               case ("..."): return'S';
               case ("-"): return'T';
               case ("..-"): return'U';
               case ("...-"): return'V';
               case (".--"): return'W';
               case ("-..-"): return'X';
               case ("-.--"): return'Y';
               case ("--.."): return'Z';
               default: return ' ';
           }
    };
}
