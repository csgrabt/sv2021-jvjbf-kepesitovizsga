package training360.guinessapp;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import javax.validation.Valid;

@RequestMapping("/api/recorders")
@RestController
@AllArgsConstructor
public class RecorderController {

  private RecorderService recorderService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto createEmployee(@Valid @RequestBody RecorderCreateCommand command) {
        return recorderService.createRecorder(command);
    }
}
