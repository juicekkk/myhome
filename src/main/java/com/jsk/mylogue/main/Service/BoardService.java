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

}