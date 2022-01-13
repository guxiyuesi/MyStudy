package indi.guxiyuesi.HospitalManage.entity.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 叶意
 * @ClassName Registration
 * @Description TODO
 * @createTime 2021年12月20日  07:51:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    private String doctorId;
    private Long patientId;
    private Integer patientCurrentNum;
}
