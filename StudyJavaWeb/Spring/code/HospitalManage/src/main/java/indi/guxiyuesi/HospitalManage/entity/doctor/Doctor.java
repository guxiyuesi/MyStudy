package indi.guxiyuesi.HospitalManage.entity.doctor;

import lombok.Data;

/**
 * @author 叶意
 * @ClassName Doctor
 * @Description 医生实体类
 * @createTime 2021年11月21日  14:12:00
 */
@Data
public class Doctor {
    private String doctorId;
    private String doctorName;
    private String doctorGender;
    private String doctorPhoneNumber;
    private Integer doctorAge;
    private String departmentName;
    private Integer doctorDefaultAllNumber;
    private String doctorPassword;
    private Integer isDoctor;
    private Integer departmentId;
}
