package com.itany.mapper;

import com.itany.pojo.Supplier;

import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 上午11:42
 * description:
 * version:1.0
 */
public interface SupplierMapper {


    /**
     * 查询所有供应商
     * @return
     */
    List<Supplier> selectAllSupplier();
}
