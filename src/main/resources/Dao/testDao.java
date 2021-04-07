package com.jsk.mylogue.main.Dao;

import com.jsk.mylogue.main.vo.testVo;

import java.util.List;

public class testDao extends BaseDao {

    public List<testVo> getList() {
        return (List<testVo>) this.list("getList");
    }

}