package com.jsk.mylogue.main.Service;

import com.jsk.mylogue.main.vo.memberVo;

public interface MemberService {

    public Integer dupliChk(String userId);

    public void memberReg(memberVo param);

    public void memberMod(memberVo param);

    public void memberPwdMod(memberVo param);

    public void memberDel(memberVo param);

    public memberVo memberLoginInfo(memberVo param);

}