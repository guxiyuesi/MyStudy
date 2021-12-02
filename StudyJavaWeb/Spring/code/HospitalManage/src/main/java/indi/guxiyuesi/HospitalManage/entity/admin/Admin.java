package indi.guxiyuesi.HospitalManage.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 叶意
 * @ClassName Admin
 * @Description 管理员实体类
 * @createTime 2021年11月23日  18:44:00
 */
@Data
@AllArgsConstructor
public class Admin {
    private String administratorId;
    private String administratorPassword;
    private String administratorName;
    private String administratorGender;
    private String administratorPhoneNumber;
    private String administratorAccount;
}
