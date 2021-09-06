package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeatWorldRecordDto {

    private String description;
    private String unitOfMeasure;
    private String oldRecorderName;
    private String newRecorderName;
    private double newRecordValue;
    private double recordDifference;

}
