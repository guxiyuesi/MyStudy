package indi.guxiyuesi.HospitalManage.entity.drug;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 叶意
 * @ClassName Drugs
 * @Description TODO
 * @createTime 2021年12月19日  22:25:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drugs {
    private TempDrug[] drugs;
}
