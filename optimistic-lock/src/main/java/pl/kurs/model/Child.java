package pl.kurs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int weight;
    private int height;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Mother mother;

    @Version
    private int version;

    public Child(String name, int weight, int height, Mother mother) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.mother = mother;
    }

    public Child(Child child) {
        this.id = child.id;
        this.name = child.name;
        this.weight = child.weight;
        this.height = child.height;
        this.mother = child.mother;
        this.version = child.version;
    }
}
