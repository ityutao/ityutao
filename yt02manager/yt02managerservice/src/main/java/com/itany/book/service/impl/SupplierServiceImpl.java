package com.itany.book.service.impl;

import com.itany.mapper.SupplierMapper;
import com.itany.pojo.Supplier;
import com.itany.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-4-3 上午11:49
 * description:
 * version:1.0
 */
@Service
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;


    public List<Supplier> findAllSupplier() {
        List<Supplier> suppliers = supplierMapper.selectAllSupplier();

        return suppliers;
    }
}
