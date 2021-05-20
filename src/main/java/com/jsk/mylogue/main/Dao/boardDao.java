package com.jsk.mylogue.main.Dao;

import com.jsk.mylogue.main.vo.boardVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public class boardDao extends BaseDao {

    public List<boardVo> getList(boardVo param) {
        return (List<boardVo>) this.list("getList", param);
    }

}