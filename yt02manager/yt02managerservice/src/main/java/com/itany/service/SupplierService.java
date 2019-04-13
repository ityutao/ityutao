package com.itany.service;

import com.itany.pojo.Supplier;

import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 上午11:48
 * description:
 * version:1.0
 */
public interface SupplierService {


    /**
     * 查找所有供应商
     * @return
     */
    public List<Supplier> findAllSupplier();
}
