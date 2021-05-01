package com.jsk.mylogue.main.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public class MemberDao extends BaseDao {

    public Integer dupliChk(String userId) {
        return (Integer) this.select("dupliChk", userId);
    }

}