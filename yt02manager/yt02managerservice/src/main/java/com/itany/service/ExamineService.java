package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.exception.ExamineException;
import com.itany.pojo.Examine;
import com.itany.pojo.User;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 下午3:34
 * description:
 * version:1.0
 */
public interface ExamineService {

    /**
     * 分页查询,查询所有审核信息
     * @param page
     * @param rows
     * @param examine
     * @return
     */
    public PageInfo<Examine> findAllExamine(Integer page, Integer rows,Examine examine);

    /**
     * 修改审核信息的状态
     * @param examine
     */
    public void modifyFlag(Examine examine) throws ExamineException;
}
