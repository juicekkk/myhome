package com.jsk.mylogue.main.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@RequestMapping("etc.do")
	public String etcLogue() {
		return "logue/etc.page";
	}

}
