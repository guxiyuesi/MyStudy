package indi.guxiyuesi.HospitalManage.entity.verification;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 叶意
 * @ClassName Verification
 * @Description 登录时的账号密码信息
 * @createTime 2021年11月23日  17:41:00
 */
@Data
@AllArgsConstructor
public class Verification {
    private String account;
    private String password;
    private String radio;
}
