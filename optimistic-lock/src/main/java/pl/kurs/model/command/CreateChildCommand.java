package pl.kurs.model.command;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateChildCommand {

    private String name;
    private int weight;
    private int height;
    private Integer motherId;

}
