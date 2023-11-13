package cz.upce.bvwa2.model.appointment;

import cz.upce.bvwa2.db.entity.Appointment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentModel {

    private String uuid;
    private String patientUuid;
    private String patientName;
    private String doctorUuid;
    private String doctorName;
    private LocalDateTime time;

    public AppointmentModel(Appointment appointment) {
        this.uuid = appointment.getUuid();
        this.patientUuid = appointment.getPatient()
                                      .getUuid();
        this.patientName = appointment.getPatient()
                                      .getUser()
                                      .getFirstName() + " " + appointment.getPatient()
                                                                         .getUser()
                                                                         .getLastName();
        this.doctorUuid = appointment.getDoctor()
                                     .getUuid();
        this.doctorName = appointment.getDoctor()
                                     .getUser()
                                     .getFirstName() + " " + appointment.getDoctor()
                                                                        .getUser()
                                                                        .getLastName();
        this.time = appointment.getTime();
    }
}
