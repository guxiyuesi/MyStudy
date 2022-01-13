package indi.guxiyuesi.HospitalManage.entity.doctorAndPatient;

import lombok.Data;

/**
 * @author 叶意
 * @ClassName DoctorAndPatient
 * @Description TODO
 * @createTime 2021年12月16日  13:10:00
 */
@Data
public class DoctorAndPatient {
    private String doctorId;
    private Long patientId;
    private String doctorName;
    private String doctorGender;
    private Integer doctorAge;
    private Integer doctorCurrentNum;
    private Integer departmentId;
    private String departmentName;
    private String patientName;
    private String patientGender;
    private Integer patientAge;
    private Integer patientCurrentNum;
}
