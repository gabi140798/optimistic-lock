package pl.kurs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // napisz apikacje w ktorej bedziemy mieli dwie klasy
        // Mother(id, name, age)
        // Kid(id,name,  weight, height, mother)

        // chcemy miec dwa endpointy na dodawanie i edytowanie dziecka
        // podczas edycji maja wykonywac sie 2 zapytania
        // nie chcemy miec problemu lost update
    }
}
