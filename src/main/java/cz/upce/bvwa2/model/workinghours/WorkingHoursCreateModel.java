package cz.upce.bvwa2.model.workinghours;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkingHoursCreateModel {
    private String doctorUuid;
    private String dayOfWeek;
    private Integer hourFrom;
    private Integer hoursCount;
}
