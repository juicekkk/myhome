package com.jsk.mylogue.main.Service;

import com.jsk.mylogue.main.vo.boardVo;
import java.util.List;

public interface BoardService {

    public List<boardVo> getList(boardVo param);

    public Integer getListCnt(boardVo param);

    public int boardDel(boardVo param);

}