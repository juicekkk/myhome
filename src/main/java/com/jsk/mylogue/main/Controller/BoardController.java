package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.BoardService;
import com.jsk.mylogue.main.vo.boardVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;


/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@RequestMapping("/write/{categoryCode}.do")
	public ModelAndView boardWrite(@PathVariable String categoryCode) throws Exception {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("board/write.page");

		mnv.addObject("categoryCode", categoryCode);
		return mnv;
	}

	@RequestMapping(value = "boardReg.do", method = RequestMethod.POST)
	public Object boardReg(boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		param.getThumbnail();
		//memberVo memberInfo = memberService.memberLoginInfo(param);

		map.put("result", 2);
		return map;
	}

	@RequestMapping(value = "getList.do", method = RequestMethod.GET)
	public Object getList(boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		if("".equals(param.getPageStart())){
			param.setPageStart(0);
		}
		param.setPageEnd(param.getPageStart()+10);

		List<boardVo> list = (List<boardVo>) boardService.getList(param);
		return list;
	}

}
