package training360.guinessapp.sevice;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.Entity.Recorder;
import training360.guinessapp.repository.RecorderRepository;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {
    private RecorderRepository repository;
    private ModelMapper modelMapper;

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(
                command.getName(),
                command.getDateOfBirth()
        );
        repository.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public List<RecorderDto> listRecorders() {
        return repository.listRecordes();
    }


}
