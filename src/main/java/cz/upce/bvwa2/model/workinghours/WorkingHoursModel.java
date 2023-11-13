package cz.upce.bvwa2.model.workinghours;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkingHoursModel {
    private String uuid;
    private String doctorUuid;
    private String doctorName;
    private String dayOfWeek;
    private Integer hourFrom;
    private Integer hoursCount;
}
