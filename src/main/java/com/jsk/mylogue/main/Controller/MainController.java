package com.jsk.mylogue.main.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.jsk.mylogue.main.vo.testVo;
import com.jsk.mylogue.main.Service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MainService mainService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "main/index.page";
	}

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

	@RequestMapping("main.do")
	public String main() {
		return "main/index.page";
	}

	@RequestMapping("eat.do")
	public String eatLogue() {
		return "logue/eat.page";
	}

	@RequestMapping("hobby.do")
	public String hobbyLogue() {
		return "logue/hobby.page";
	}

	@RequestMapping("travel.do")
	public String travelLogue() {
		return "logue/travel.page";
	}

	@RequestMapping("daily.do")
	public String dailyLogue() {
		return "logue/daily.page";
	}

	@RequestMapping("stranger.do")
	public String strangerLogue() {
		return "logue/stranger.page";
	}

	@RequestMapping("test.do")
	public String testLogue(Model model) {

		//<> 안에 DTO or VO 이름
		List<testVo> testpage = mainService.getList();
		//model을 통해 View로 전달
		model.addAttribute("testpage",testpage);

		return "logue/test.page";
	}

}
