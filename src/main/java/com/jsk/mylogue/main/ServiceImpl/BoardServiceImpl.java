package com.jsk.mylogue.main.ServiceImpl;

import com.jsk.mylogue.main.Dao.boardDao;
import com.jsk.mylogue.main.Service.BoardService;
import com.jsk.mylogue.main.vo.boardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private boardDao dao;

    @Override
    public List<boardVo> getList(boardVo param) {
        return dao.getList(param);
    }

    @Override
    public Integer getListCnt(boardVo param) {
        return dao.getListCnt(param);
    }

    @Override
    public int boardDel(boardVo param) {
        return dao.boardDel(param);
    }

}