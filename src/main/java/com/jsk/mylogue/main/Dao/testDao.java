package com.jsk.mylogue.main.Dao;

import com.jsk.mylogue.main.vo.testVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public class testDao extends BaseDao {

    public List<testVo> getList() {
        return (List<testVo>) this.list("getList");
    }

}