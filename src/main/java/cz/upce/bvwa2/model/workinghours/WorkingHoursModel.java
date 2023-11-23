package cz.upce.bvwa2.model.workinghours;

import cz.upce.bvwa2.db.entity.WorkingHours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursModel {
    private String uuid;
    private String doctorUuid;
    private String doctorName;
    private String dayOfWeek;
    private Integer hourFrom;
    private Integer hoursCount;

    public WorkingHoursModel(WorkingHours workingHours) {
        this.uuid = workingHours.getUuid();
        this.doctorUuid = workingHours.getDoctor().getUuid();
        this.doctorName = workingHours.getDoctor().getFirstName() + " " + workingHours.getDoctor().getLastName();
        this.dayOfWeek = workingHours.getDayOfWeek();
        this.hourFrom = workingHours.getHourFrom();
        this.hoursCount = workingHours.getHoursCount();
    }
}
