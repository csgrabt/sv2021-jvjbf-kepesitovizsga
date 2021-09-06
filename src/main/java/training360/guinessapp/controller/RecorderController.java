package training360.guinessapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.sevice.RecorderService;

import javax.validation.Valid;
import java.util.List;

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

  @GetMapping
  @ResponseStatus(HttpStatus.CREATED)
  public List<RecorderDto> listRecorder() {
    return recorderService.listRecorders();
  }

}
