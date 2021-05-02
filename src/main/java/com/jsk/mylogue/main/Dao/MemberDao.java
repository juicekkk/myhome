package com.jsk.mylogue.main.Dao;

import com.jsk.mylogue.main.vo.memberVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public class MemberDao extends BaseDao {

    public Integer dupliChk(String userId) {
        return (Integer) this.select("dupliChk", userId);
    }

    public void memberReg(memberVo param) {
        this.insert("memberReg", param);
    }

}