package com.guxiyuesi.springIoC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叶意
 * @ClassName GetDataBase
 * @Description TODO
 * @createTime 2021年10月18日  22:52:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDataBase {
    private String user;
    private String password;
    private String url;
    private String driverName;
}
