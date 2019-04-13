package com.itany.pojo;

import java.io.Serializable;

/**
 * Author:yutao@itany.com
 * Date:19-3-27 下午2:16
 * description:
 * version:1.0
 */
public class ManagerUser  implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private Integer supplierid;

    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ManagerUser(Integer id, String username, String password, Integer supplierid, Supplier supplier) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.supplierid = supplierid;
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public ManagerUser() {
    }


}
