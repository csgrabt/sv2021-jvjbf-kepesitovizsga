package training360.guinessapp;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.validation.Valid;
import java.net.URI;
import java.util.Map;

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