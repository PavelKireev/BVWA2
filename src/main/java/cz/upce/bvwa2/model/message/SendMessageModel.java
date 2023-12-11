package cz.upce.bvwa2.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMessageModel {

    private String userUuidFrom;
    private String userEmailFrom;
    private String userUuidTo;
    private String userEmailTo;
    private String content;

}
