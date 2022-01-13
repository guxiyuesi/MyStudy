package indi.guxiyuesi.HospitalManage.entity.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName Patient
 * @Description 病人实体类
 * @createTime 2021年11月23日  17:33:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private String patientAccount;
    private String patientPassword;
    private String patientName;
    private String patientPhoneNumber;
    private String patientGender;
    private String patientIDNumber;
    private Long patientId;
    private Integer patientAge;
}