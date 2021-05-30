package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.MemberService;
import com.jsk.mylogue.main.vo.memberVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.HttpSession;
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
	public ModelAndView myPage(HttpSession session) {
		ModelAndView mnv = new ModelAndView();

		memberVo param = new memberVo();
		param.setUserId((String) session.getAttribute("userId"));
		memberVo memberInfo = memberService.memberLoginInfo(param);

		mnv.setViewName("main/mypage.page");
		mnv.addObject("memberInfo", memberInfo);

		return mnv;
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

	@RequestMapping(value = "memberReg.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberReg(memberVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		AES256Util encryption = new AES256Util();
		String encryptPwd = encryption.encrypt(param.getUserPwd());
		param.setUserPwd(encryptPwd);

		memberService.memberReg(param);
		map.put("code", 200);
		return map;
	}

	@RequestMapping(value = "memberMod.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberMod(memberVo param, HttpSession session) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		param.setMbrNum((String) session.getAttribute("mbrNum"));
		memberService.memberMod(param);
		map.put("code", 200);
		return map;
	}

	@RequestMapping(value = "memberPwdMod.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberPwdMod(memberVo param, HttpSession session) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		param.setMbrNum((String) session.getAttribute("mbrNum"));
		param.setUserId((String) session.getAttribute("userId"));

		// 현재 비밀번호 맞는지 체크
		memberVo memberInfo = memberService.memberLoginInfo(param);

		AES256Util encryption = new AES256Util();
		String decryptPwd = encryption.decrypt(memberInfo.getUserPwd());
		if(param.getUserPwd().equals(decryptPwd)){
			// 비밀번호 수정
			param.setNewUserPwd(encryption.encrypt(param.getNewUserPwd()));
			memberService.memberPwdMod(param);
			session.invalidate();
			map.put("result", 1);
		} else {
			map.put("result", 2);
		}

		map.put("code", 200);
		return map;
	}

	@RequestMapping(value = "memberDel.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberDel(memberVo param, HttpSession session) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		param.setMbrNum((String) session.getAttribute("mbrNum"));
		memberService.memberDel(param);
		session.invalidate();
		map.put("code", 200);
		return map;
	}

	@RequestMapping(value = "memberFind.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberFind(memberVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		String memberId = memberService.memberIdFind(param);
		if(memberId != null && !"".equals(memberId)) {
			map.put("result", memberId);
		}
		map.put("code", 200);

		return map;
	}

	@RequestMapping(value = "memberLogin.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberLogin(memberVo param, HttpSession session) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		memberVo memberInfo = memberService.memberLoginInfo(param);

		if(memberInfo != null){
			AES256Util encryption = new AES256Util();
			String decryptPwd = encryption.decrypt(memberInfo.getUserPwd());
			if(param.getUserPwd().equals(decryptPwd) || param.getIsKakao().equals("Y")){
				session.setAttribute("mbrNum", memberInfo.getMbrNum());
				session.setAttribute("userId", memberInfo.getUserId());
				session.setAttribute("nickName", memberInfo.getNickName());
				map.put("result", 1);
			} else {
				map.put("result", 2);
			}
		} else {
			map.put("result", 2);
		}

		map.put("code", 200);
		return map;
	}

	@RequestMapping(value = "memberLogout.do", method = RequestMethod.POST)
	@ResponseBody
	public Object memberLogout(memberVo param, HttpSession session) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		session.invalidate();
		map.put("result", 1);
		map.put("code", 200);

		return map;
	}


}
