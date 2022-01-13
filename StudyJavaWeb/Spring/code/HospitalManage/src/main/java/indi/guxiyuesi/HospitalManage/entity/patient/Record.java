package indi.guxiyuesi.HospitalManage.entity.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName Record
 * @Description TODO
 * @createTime 2021年12月20日  13:16:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private String doctorName;
    private String patientName;
    private String illnessDescription;
    private Long medicalRecordId;
}
