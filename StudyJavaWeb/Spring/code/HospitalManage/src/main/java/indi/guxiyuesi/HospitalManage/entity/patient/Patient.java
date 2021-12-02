package indi.guxiyuesi.HospitalManage.entity.patient;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 叶意
 * @ClassName Patient
 * @Description 病人实体类
 * @createTime 2021年11月23日  17:33:00
 */
@Data
@AllArgsConstructor
public class Patient {
    private String patientAccount;
    private String patientPassword;
    private String patientName;
    private String patientPhoneNumber;
    private String Gender;
    private String patientIDNumber;
    private Long patientId;
    private Integer patientAge;
    private String address;
}