package pl.kurs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kurs.service.ChildService;

@RestController
@RequestMapping("/api/v1/child")
@Slf4j
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;
}
