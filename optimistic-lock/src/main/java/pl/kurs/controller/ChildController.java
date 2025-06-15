package pl.kurs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.model.command.CreateChildCommand;
import pl.kurs.model.command.UpdateChildCommand;
import pl.kurs.model.dto.ChildDto;
import pl.kurs.service.ChildService;

@RestController
@RequestMapping("/api/v1/child")
@Slf4j
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    @PutMapping("/{id}")
    public ResponseEntity<ChildDto> updateStudent(@PathVariable int id, @RequestBody UpdateChildCommand command) {
        ChildDto updatedChild = childService.updateChild(id, command);
        return ResponseEntity.status(HttpStatus.OK).body(updatedChild);
    }

    @PostMapping
    public ResponseEntity<ChildDto> createChild(@RequestBody CreateChildCommand command) {
        ChildDto newChild = childService.createChild(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(newChild);
    }

}
