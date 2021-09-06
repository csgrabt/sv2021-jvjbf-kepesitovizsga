package training360.guinessapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import training360.guinessapp.dto.*;
import training360.guinessapp.sevice.WordRecordService;

import javax.validation.Valid;
import java.net.URI;

@RequestMapping("/api/worldrecords")
@RestController
@AllArgsConstructor
public class WordRecordController {
    private WordRecordService wordRecordService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto createEmployee(@Valid @RequestBody WorldRecordCreateCommand command) {
        return wordRecordService.createWordRecord(command);
    }


    @PutMapping("/{id}/beatrecords")
    @ResponseStatus(HttpStatus.CREATED)
    public BeatWorldRecordDto beatWorldRecord(@PathVariable("id") Long id, @Valid @RequestBody BeatWorldRecordCommand command) {
        return wordRecordService.beatWordRecord(id, command);
    }





    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException enf) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("/api/worldrecords"))
                        .withTitle("Recorder not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(enf.getMessage())
                        .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);

    }
}