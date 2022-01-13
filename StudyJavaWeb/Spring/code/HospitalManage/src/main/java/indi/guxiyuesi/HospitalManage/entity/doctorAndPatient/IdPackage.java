package indi.guxiyuesi.HospitalManage.entity.doctorAndPatient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName IdPackage
 * @Description TODO
 * @createTime 2021年12月16日  13:39:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdPackage {
    private String doctorId;
    private Integer patientId;
}
