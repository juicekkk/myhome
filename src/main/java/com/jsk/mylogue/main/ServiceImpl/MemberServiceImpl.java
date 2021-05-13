package com.jsk.mylogue.main.ServiceImpl;

import com.jsk.mylogue.main.Dao.MemberDao;
import com.jsk.mylogue.main.Service.MemberService;
import com.jsk.mylogue.main.vo.memberVo;
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

    @Override
    public void memberReg(memberVo param) {
        dao.memberReg(param);
    }

    @Override
    public void memberMod(memberVo param) {
        dao.memberMod(param);
    }

    @Override
    public void memberPwdMod(memberVo param) {
        dao.memberPwdMod(param);
    }

    @Override
    public void memberDel(memberVo param) {
        dao.memberDel(param);
    }

    @Override
    public String memberIdFind(memberVo param) {
        return dao.memberIdFind(param);
    }

    @Override
    public memberVo memberLoginInfo(memberVo param) {
        return dao.memberLoginInfo(param);
    }




}