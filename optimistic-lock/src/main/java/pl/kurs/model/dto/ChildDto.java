package pl.kurs.model.dto;

import pl.kurs.model.Child;

public record ChildDto(int id, String name, int weight, int height, int motherId) {

    public static ChildDto from(Child child) {
        return new ChildDto(child.getId(), child.getName(), child.getWeight(), child.getHeight(), child.getMother().getId());
    }
}
