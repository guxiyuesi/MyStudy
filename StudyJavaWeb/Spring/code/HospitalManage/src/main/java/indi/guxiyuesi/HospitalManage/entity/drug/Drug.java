package indi.guxiyuesi.HospitalManage.entity.drug;

import lombok.Data;

/**
 * @author 叶意
 * @ClassName Drug
 * @Description TODO
 * @createTime 2021年11月29日  18:49:00
 */
@Data
public class Drug {
    private Long drugId;
    private String drugName;
    private String drugDescription;
    private Integer drugNumber;
}
