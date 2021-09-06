package training360.guinessapp.sevice;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.Entity.Recorder;
import training360.guinessapp.repository.RecorderRepository;
import training360.guinessapp.repository.WordRecordRepository;
import training360.guinessapp.Entity.WorldRecord;
import training360.guinessapp.dto.*;

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
                command.getDateOfRecord(),
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

  //  @Transactional
    public BeatWorldRecordDto beatWordRecord(Long id, BeatWorldRecordCommand command) {
        WorldRecord worldRecord = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find WorldRecorder by id"));

        Double oldValue = worldRecord.getValue();

        Recorder oldRecorder = recorderRepository.findById(worldRecord.getId()).orElseThrow(() -> new IllegalArgumentException("Cannot find recorder by id"));

        Recorder newRecorder = recorderRepository.findById(command.getNewRecorderId()).orElseThrow(() -> new IllegalArgumentException("Cannot find recorder by id"));

        //    if (command.getNewValue() < oldValue) {
        //        throw new IllegalArgumentException("Is it not a record");
        //     }
        double different = oldValue - command.getNewValue();
//
      //  worldRecord.setDateOfRecord(LocalDate.now());
      //  worldRecord.setId(command.getNewRecorderId());
      //  worldRecord.setValue(command.getNewValue());
//
      //  repository.save(worldRecord);
//
      //  System.out.println(worldRecord.getDateOfRecord());

        return new BeatWorldRecordDto(
                worldRecord.getDescription(),
                worldRecord.getUnitOfMeasure(),
                oldRecorder.getName(),
                newRecorder.getName(),
                command.getNewValue(),
                different
        );
    }
}
