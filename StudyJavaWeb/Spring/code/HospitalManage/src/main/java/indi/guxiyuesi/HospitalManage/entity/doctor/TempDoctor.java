package indi.guxiyuesi.HospitalManage.entity.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName TempDoctor
 * @Description TODO
 * @createTime 2021年12月20日  04:27:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempDoctor {
    private String doctorId;
    private Integer doctorCurrentNumber;
    private Integer doctorCurrentAllNumber;
}
