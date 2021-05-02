package com.jsk.mylogue.main.Service;

import com.jsk.mylogue.main.vo.memberVo;

public interface MemberService {

    public Integer dupliChk(String userId);

    public void memberReg(memberVo param);

}