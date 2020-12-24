package com.shepherd.sqlbuilder;

import lombok.Data;

/**
 * @author fjZheng
 * @version 1.0
 * @date 2020/12/24 11:42
 */
@Data
public class DataSource {
    private String ip;
    private String port;
    private String databaseName;
    private String userName;
    private String password;
    private Integer type;
}
