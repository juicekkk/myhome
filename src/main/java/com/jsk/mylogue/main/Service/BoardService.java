package com.jsk.mylogue.main.Service;

import com.jsk.mylogue.main.vo.boardVo;
import java.util.List;

public interface BoardService {

    public List<boardVo> getList(boardVo param);

    public int getListCnt(boardVo param);

    public int boardDel(boardVo param);

    public int boardReg(boardVo param);

    public int boardMod(boardVo param);

    public String categoryNum(String param);

    public int scrapCnt(boardVo param);

    public int likeCnt(boardVo param);

    public int likeReg(boardVo param);

    public int likeDel(boardVo param);

    public int scrapReg(boardVo param);

    public int scrapDel(boardVo param);

}