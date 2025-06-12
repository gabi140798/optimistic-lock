package pl.kurs.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateChildCommand {

    private String name;
    private int weight;
    private int height;
    private int version;
}
