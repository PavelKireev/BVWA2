package cz.upce.bvwa2.model.workinghours;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursCreateModel {
    private String doctorUuid;
    private String dayOfWeek;
    private Integer hourFrom;
    private Integer hoursCount;


}
