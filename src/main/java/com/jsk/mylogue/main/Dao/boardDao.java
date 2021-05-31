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

    public int getListCnt(boardVo param) {
        return (Integer) this.select("getListCnt", param);
    }

    public int boardDel(boardVo param) {
        return this.update("boardDel", param);
    }

    public int boardReg(boardVo param) {
        return (Integer) this.insert("boardReg", param);
    }

    public int boardMod(boardVo param) {
        return this.update("boardMod", param);
    }

    public String categoryNum(String param) {
        return (String) this.select("categoryNum", param);
    }

    public int scrapCnt(boardVo param) {
        return (Integer) this.select("scrapCnt", param);
    }

    public int likeCnt(boardVo param) {
        return (Integer) this.select("likeCnt", param);
    }

    public int likeReg(boardVo param) {
        return (Integer) this.insert("likeReg", param);
    }

    public int likeDel(boardVo param) {
        return (Integer) this.delete("likeDel", param);
    }

    public int scrapReg(boardVo param) {
        return (Integer) this.insert("scrapReg", param);
    }

    public int scrapDel(boardVo param) {
        return (Integer) this.delete("scrapDel", param);
    }

}