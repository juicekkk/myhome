package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.BoardService;
import com.jsk.mylogue.main.Service.FileUploadService;
import com.jsk.mylogue.main.vo.boardVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping("/write/{categoryCode}.do")
	public ModelAndView boardWrite(@PathVariable String categoryCode) throws Exception {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("board/write.page");

		mnv.addObject("categoryCode", categoryCode);
		return mnv;
	}

	@RequestMapping(value = "boardReg.do", method = RequestMethod.POST)
	@ResponseBody
	public Object boardReg(@RequestParam("thumbnail") MultipartFile thumbnail
			, @RequestParam String title
			, @RequestParam String subTitle
			, @RequestParam String categoryCode
			, @RequestParam String contents
			, @RequestParam String share
			, HttpServletRequest req) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		boardVo param = new boardVo();
		param.setTitle(title);
		param.setSubTitle(subTitle);
		String categoryNum = boardService.categoryNum(categoryCode);
		param.setCategoryNum(categoryNum);
		param.setContents(contents);
		param.setShare(share);
		param.setThumbNail("thumbnail.jpg");

		//param.getThumbnail();
		//이미지업로드
		/*String url = fileUploadService.restore(thumbnail);
		System.out.println(":::::::: " + url);*/


		/*if (!thumbnail.getOriginalFilename().isEmpty()) {
			thumbnail.transferTo(new File("/tomcat/webapps/ROOT/resources/images/contents/board1", thumbnail.getOriginalFilename()));
		}*/

		map.put("code", 200);
		if(boardService.boardReg(param) == 1){
			map.put("result", 1);
		} else {
			map.put("result", 2);
		}

		return map;
	}

	@RequestMapping(value = "boardMod.do", method = RequestMethod.POST)
	@ResponseBody
	public Object boardMod(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		//param.getThumbnail();
		//이미지업로드

		map.put("code", 200);
		if(boardService.boardMod(param) == 1){
			map.put("result", boardService.boardMod(param));
		} else {
			map.put("result", 2);
		}
		return map;
	}

	@RequestMapping(value = "getList.do", method = RequestMethod.POST)
	@ResponseBody
	public Object getList(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		if("".equals(param.getPageCnt()) || param.getPageCnt() == null){
			param.setPageCnt(10);
		}

		if(param.getPageCnt() != null ||  "".equals(param.getPageStart()) || param.getPageStart() < 1){
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

		map.put("code", 200);
		if(boardService.boardDel(param) == 1){
			map.put("result", boardService.boardDel(param));
		} else {
			map.put("result", 2);
		}
		return map;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(2000000000);
		return multipartResolver;
	}

	@RequestMapping(value = "likeReg.do", method = RequestMethod.POST)
	@ResponseBody
	public Object likeReg(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", 200);
		int likeCnt = boardService.likeCnt(param);
		if(likeCnt < 1){
			if(boardService.likeReg(param) == 1){
				map.put("result", 1);
			} else {
				map.put("result", 2);
			}
		} else {
			map.put("result", "이미 좋아요를 누르셨습니다.");
		}

		return map;
	}

	@RequestMapping(value = "likeDel.do", method = RequestMethod.POST)
	@ResponseBody
	public Object likeDel(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", 200);
		int likeCnt = boardService.likeCnt(param);
		if(likeCnt > 0){
			if(boardService.likeDel(param) == 1){
				map.put("result", 1);
			} else {
				map.put("result", 2);
			}
		} else {
			map.put("result", "삭제할 정보가 없습니다.");
		}

		return map;
	}

	@RequestMapping(value = "scrapReg.do", method = RequestMethod.POST)
	@ResponseBody
	public Object scrapReg(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", 200);
		int scrapCnt = boardService.scrapCnt(param);
		if(scrapCnt < 1){
			if(boardService.scrapReg(param) == 1){
				map.put("result", 1);
			} else {
				map.put("result", 2);
			}
		} else {
			map.put("result", "이미 스크랩한 게시물 입니다.");
		}

		return map;
	}

	@RequestMapping(value = "scrapDel.do", method = RequestMethod.POST)
	@ResponseBody
	public Object scrapDel(@RequestBody boardVo param) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", 200);
		int scrapCnt = boardService.scrapCnt(param);
		if(scrapCnt > 0){
			if(boardService.scrapDel(param) == 1){
				map.put("result", 1);
			} else {
				map.put("result", 2);
			}
		} else {
			map.put("result", "삭제할 정보가 없습니다.");
		}

		return map;
	}

}

