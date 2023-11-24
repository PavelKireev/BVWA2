package cz.upce.bvwa2.model.appointment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import cz.upce.bvwa2.db.entity.Appointment;
import lombok.Data;

import java.util.Date;

@Data
public class AppointmentModel {

    private String uuid;
    private String patientUuid;
    private String patientName;
    private String doctorUuid;
    private String doctorName;
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Date time;

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
                                     .getUser()
                                     .getUuid();
        this.doctorName = appointment.getDoctor()
                                     .getUser()
                                     .getFirstName() + " " + appointment.getDoctor()
                                                                        .getUser()
                                                                        .getLastName();
        this.time = appointment.getTime();
    }
}
