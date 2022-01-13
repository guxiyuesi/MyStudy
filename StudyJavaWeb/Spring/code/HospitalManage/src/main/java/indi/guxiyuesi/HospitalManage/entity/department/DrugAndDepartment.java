package indi.guxiyuesi.HospitalManage.entity.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName DrugAndDepartment
 * @Description TODO
 * @createTime 2021年12月16日  04:09:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugAndDepartment {
    private Integer departmentId;
    private Long drugId;
}
