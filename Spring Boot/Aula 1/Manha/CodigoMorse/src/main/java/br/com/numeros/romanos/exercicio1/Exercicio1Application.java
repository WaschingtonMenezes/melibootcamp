package br.com.numeros.romanos.exercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@SpringBootApplication
@RestController
public class Exercicio1Application {

    private static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }
    public static void main(String[] args) {
        SpringApplication.run(Exercicio1Application.class, args);
    }
    @GetMapping("/romanNumeral")
    public String romanNumeral(@RequestParam(value = "digit", defaultValue = "1") int number) {
        String numeral = toRomanNumeral(number);
        return String.format("%d - %s", number, numeral);
    }
    private String toRomanNumeral(Integer number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRomanNumeral(number-l);
    }
}


