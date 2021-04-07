package com.jsk.mylogue.main.ServiceImpl;

import java.util.List;

import com.jsk.mylogue.main.Dao.testDao;
import com.jsk.mylogue.main.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsk.mylogue.main.vo.testVo;


@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private testDao dao;

    @Override
    public List<testVo> getList() {
        return dao.getList();
    }




}