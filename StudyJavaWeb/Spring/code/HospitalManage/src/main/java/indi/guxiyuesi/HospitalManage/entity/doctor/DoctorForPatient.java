package indi.guxiyuesi.HospitalManage.entity.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 叶意
 * @ClassName DoctorForPatient
 * @Description TODO
 * @createTime 2021年12月20日  05:29:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorForPatient {
    private String doctorId;
    private String doctorName;
    private String doctorGender;
    private Integer doctorAge;
    private Integer departmentId;
    private String departmentName;
    private Integer doctorCurrentNumber;
    private Integer doctorCurrentAllNumber;
    private Byte Monday;
    private Byte Tuesday;
    private Byte Wednesday;
    private Byte Thursday;
    private Byte Friday;
    private Byte Saturday;
    private Byte Sunday;
    private Integer registrationNumber;
}
