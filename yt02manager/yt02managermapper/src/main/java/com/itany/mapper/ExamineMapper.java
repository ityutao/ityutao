package com.itany.mapper;

import com.itany.pojo.Examine;
import com.itany.pojo.User;

import java.util.List;

/**
 * Author:yutao@itany.com
 * Date:19-3-29 上午11:12
 * description:
 * version:1.0
 */
public interface ExamineMapper {


    /**
     * 添加审核
     * @param examine
     */
    public void insertExamine(Examine examine);

    /**
     * 查询该供应商下的所有
     * @param examine
     * @return
     */
    List<Examine> findAllExamine(Examine examine);


    /**
     * 更改审核状态
     * @param examine
     */
    public  void updateFlag(Examine examine);
}
