package com.jsk.mylogue.main.Service;

import com.jsk.mylogue.main.vo.boardVo;
import java.util.List;

public interface BoardService {

    public List<boardVo> getList(boardVo param);

}