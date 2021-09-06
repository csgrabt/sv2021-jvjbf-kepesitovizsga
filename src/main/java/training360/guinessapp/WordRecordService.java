package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import java.util.Map;

@Service
@AllArgsConstructor
public class WordRecordService {
    private WordRecordRepository repository;
    private RecorderRepository recorderRepository;
    private ModelMapper modelMapper;

    public WorldRecordDto createWordRecord(WorldRecordCreateCommand command) {
        Recorder recorder = recorderRepository.findById(command.getRecorderId()).orElseThrow(() -> new IllegalArgumentException("Cannot find recorder by id"));
        WorldRecord worldRecord = new WorldRecord(
                command.getDescription(),
                command.getValue(),
                command.getUnitOfMeasure(),
                command.getDate(),
                command.getRecorderId()
        );
        repository.save(worldRecord);

        return new WorldRecordDto(worldRecord.getId(),
                worldRecord.getDescription(),
                worldRecord.getValue(),
                worldRecord.getUnitOfMeasure(),
                worldRecord.getDateOfRecord(),
                recorder.getName());


    }
}
