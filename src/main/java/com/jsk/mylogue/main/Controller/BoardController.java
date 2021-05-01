package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.BoardService;
import com.jsk.mylogue.main.vo.testVo;
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
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@RequestMapping("/write/{categoryCode}.do")
	public ModelAndView testLogue(@PathVariable String categoryCode) throws Exception {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("board/write.page");

		mnv.addObject("categoryCode", categoryCode);
		return mnv;
	}

}
