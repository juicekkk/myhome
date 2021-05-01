package com.jsk.mylogue.main.ServiceImpl;

import com.jsk.mylogue.main.Dao.MemberDao;
import com.jsk.mylogue.main.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao dao;

    @Override
    public Integer dupliChk(String userId) {
        return dao.dupliChk(userId);
    }




}