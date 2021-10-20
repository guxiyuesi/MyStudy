package com.guxiyuesi.springIoC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author 叶意
 * @ClassName TheClass
 * @Description TODO
 * @createTime 2021年10月18日  22:01:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheClass {
    private int classId;
    private String className;
    private Map<Integer, Student> studentMap;
}
