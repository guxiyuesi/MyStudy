package indi.guxiyuesi.HospitalManage.entity.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 叶意
 * @ClassName MedicalRecord
 * @Description TODO
 * @createTime 2021年12月19日  23:29:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
    private Long medicalRecordId;
    private String doctorId;
    private Integer patientId;
    private String illnessDescription;
}
