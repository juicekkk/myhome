package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping("join.do")
	public String join() {
		return "main/join.page";
	}

	@RequestMapping("mypage.do")
	public String myPage() {
		return "main/mypage.page";
	}

	@RequestMapping("setting.do")
	public String setting() { return "main/setting.page"; }

	@RequestMapping("modify/pwd.do")
	public String modifyPwd() { return "main/modifyPwd.page"; }

	@RequestMapping("find.do")
	public String find() { return "main/find.page"; }

	@RequestMapping(value = "dupliChk.do", method = RequestMethod.POST)
	@ResponseBody
	public Object dupliChk(String userId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Integer userChkVal = memberService.dupliChk(userId);
		map.put("code", 200);
		map.put("result", userChkVal);
		return map;
	}


}
