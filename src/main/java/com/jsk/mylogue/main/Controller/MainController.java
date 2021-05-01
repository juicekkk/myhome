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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		return "main/index.page";
	}

	@RequestMapping("/{categoryCode}.do")
	public ModelAndView logues(@PathVariable String categoryCode){
		ModelAndView mnv = new ModelAndView();
		if(categoryCode.equals("hobby") || categoryCode.equals("eat") || categoryCode.equals("travel") || categoryCode.equals("daily") || categoryCode.equals("stranger")) {
			mnv.setViewName("logue/" + categoryCode + ".page");
		} else {
			mnv.setViewName("logue/dev.page");
		}
		mnv.addObject("categoryCode", categoryCode);
		return mnv;
	}

	@RequestMapping("main.do")
	public String main() {
		return "main/index.page";
	}

	@RequestMapping("test.do")
	public String testLogue(Model model) {
		List<testVo> testpage = mainService.getList();
		model.addAttribute("testpage",testpage);

		return "logue/test.page";
	}

}
