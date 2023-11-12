package cz.upce.bvwa2.model.appointment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentCreateModel {

    private String doctorUuid;
    private String patientUuid;
    private LocalDateTime time;

}
