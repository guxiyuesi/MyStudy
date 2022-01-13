package indi.guxiyuesi.HospitalManage.entity.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName MedicalRecordAndDrug
 * @Description TODO
 * @createTime 2021年12月19日  23:59:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordAndDrug {
    private Long drugId;
    private Long medicalRecordId;
    private Integer drugNum;
}
