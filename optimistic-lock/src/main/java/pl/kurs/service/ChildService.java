package pl.kurs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kurs.model.Child;
import pl.kurs.model.Mother;
import pl.kurs.model.command.CreateChildCommand;
import pl.kurs.model.command.UpdateChildCommand;
import pl.kurs.model.dto.ChildDto;
import pl.kurs.repository.ChildRepository;
import pl.kurs.repository.MotherRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChildService {

    private final ChildRepository childRepository;
    private final MotherRepository motherRepository;

    @Transactional(readOnly = true)
    public ChildDto getChildById(int id) {
        return ChildDto.from(childRepository.findById(id).orElseThrow());
    }

    @Transactional
    public ChildDto createChild (CreateChildCommand command) {
        Mother mother = motherRepository.findById(command.getMotherId()).orElseThrow();
        Child child = new Child(command.getName(),command.getWeight(),command.getHeight(), mother);
        return ChildDto.from(childRepository.saveAndFlush(child));
    }

    @Transactional
    public ChildDto updateChild (int id, UpdateChildCommand command) {
        Child child = childRepository.findById(id).orElseThrow(() -> new RuntimeException("Child not found"));
        Child copy = new Child(child);
        copy.setName(command.getName());
        copy.setWeight(command.getWeight());
        copy.setHeight(command.getHeight());
        copy.setVersion(command.getVersion());
        return ChildDto.from(childRepository.saveAndFlush(copy));

    }
}
