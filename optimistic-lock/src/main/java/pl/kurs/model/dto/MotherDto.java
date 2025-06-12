package pl.kurs.model.dto;

import pl.kurs.model.Mother;

public record MotherDto(int id, String name, int age, int amountOfChildren) {

    public static MotherDto from (Mother mother) {
        return new MotherDto(mother.getId(), mother.getName(), mother.getAge(),mother.getChildren().size());
    }

}
