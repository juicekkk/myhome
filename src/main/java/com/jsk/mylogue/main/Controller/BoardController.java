package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.BoardService;
import com.jsk.mylogue.main.vo.boardVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
	@ResponseBody
	public Object boardReg(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		//param.getThumbnail();
		//이미지업로드

		map.put("result", boardService.boardReg(param));
		return map;
	}

	@RequestMapping(value = "boardMod.do", method = RequestMethod.POST)
	@ResponseBody
	public Object boardMod(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		//param.getThumbnail();
		//이미지업로드

		map.put("result", boardService.boardMod(param));
		return map;
	}

	@RequestMapping(value = "getList.do", method = RequestMethod.POST)
	@ResponseBody
	public Object getList(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		if("".equals(param.getPageCnt()) || param.getPageCnt() == null){
			param.setPageCnt(10);
		}

		if("".equals(param.getPageStart()) || param.getPageStart() < 1){
			param.setPageStart(0);
		} else {
			param.setPageStart((param.getPageStart()-1) * param.getPageCnt());
		}

		List<boardVo> list = boardService.getList(param);
		Integer cnt = boardService.getListCnt(param);
		map.put("list", list);
		map.put("cnt", cnt);
		return map;
	}

	@RequestMapping(value = "boardDel.do", method = RequestMethod.POST)
	@ResponseBody
	public Object boardDel(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("result", boardService.boardDel(param));
		return map;
	}

}
