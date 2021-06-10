package com.jsk.mylogue.main.Controller;

import com.jsk.mylogue.main.Service.BoardService;
import com.jsk.mylogue.main.Service.FileUploadService;
import com.jsk.mylogue.main.vo.boardVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
	public Object boardReg(@RequestParam(value = "thumbNail", required = false) MultipartFile thumbnail
			, @RequestBody boardVo params
			, HttpServletRequest req) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		boardVo param = new boardVo();

		param.setTitle(new String(params.getTitle().getBytes("8859_1"),"utf-8"));
		param.setSubTitle(new String(params.getSubTitle().getBytes("8859_1"),"utf-8"));
		String categoryNum = boardService.categoryNum(params.getCategoryNum());
		param.setCategoryNum(categoryNum);
		param.setContents(new String(params.getContents().getBytes("8859_1"),"utf-8"));
		param.setShare(params.getShare());

		//이미지업로드
		String url = "";
		if(thumbnail != null){
			//파일명
			String originalFile = thumbnail.getOriginalFilename();
			//파일명 중 확장자만 추출                                                //lastIndexOf(".") - 뒤에 있는 . 의 index번호
			String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			String storedFileName = originalFile;

			//파일을 저장하기 위한 파일 객체 생성
			long currentDate = System.currentTimeMillis();
			String fileName = new String(storedFileName.getBytes("8859_1"),"utf-8");
			String filePath = req.getSession().getServletContext().getRealPath("/")+"resources/images/contents/";
			File file = new File(filePath + currentDate + "-" + fileName);
			//파일 저장
			thumbnail.transferTo(file);

			param.setThumbNailSrc("http://hproj.cafe24.com/resources/images/contents/" + currentDate + "-" + fileName);
		} else {
			param.setThumbNailSrc("http://hproj.cafe24.com/resources/images/no_Image.png");
		}

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
			map.put("result", 3);
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
			map.put("result", 3);
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
			map.put("result", 3);
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
			map.put("result", 3);
		}

		return map;
	}

	@RequestMapping(value = "upload.do", method = RequestMethod.POST)
	@ResponseBody
	public Object upload(@RequestParam(value = "thumbNail", required = false) MultipartFile thumbnail
			, @RequestParam String title
			, @RequestParam String subTitle
			, @RequestParam String categoryCode
			, @RequestParam String contents
			, @RequestParam String share
			, @RequestParam String mbrNum
			, HttpServletRequest req) throws Exception {

		logger.error("start");

		logger.error("title : " + title);
		logger.error("subTitle : " + subTitle);
		logger.error("categoryCode : " + categoryCode);
		logger.error("contents : " + contents);
		logger.error("share : " + share);
		logger.error("mbrNum : " + mbrNum);
		logger.error("thumbnail : " + thumbnail);


		HashMap<String, Object> map = new HashMap<String, Object>();
		boardVo param = new boardVo();

		param.setTitle(new String(title.getBytes("8859_1"),"utf-8"));
		param.setSubTitle(new String(subTitle.getBytes("8859_1"),"utf-8"));
		param.setCategoryNum(categoryCode);
		param.setContents(new String(contents.getBytes("8859_1"),"utf-8"));
		param.setShare(share);
		param.setMbrNum(Integer.parseInt(mbrNum));

		logger.error("start 111 param setting");

		//이미지업로드
		String url = "";
		if(thumbnail != null){
			logger.error("start 222 upload");
			//파일명
			String originalFile = thumbnail.getOriginalFilename();
			//파일명 중 확장자만 추출                                                //lastIndexOf(".") - 뒤에 있는 . 의 index번호
			String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			String storedFileName = originalFile;

			//파일을 저장하기 위한 파일 객체 생성
			long currentDate = System.currentTimeMillis();
			String fileName = new String(storedFileName.getBytes("8859_1"),"utf-8");
			String filePath = req.getSession().getServletContext().getRealPath("/")+"resources/images/contents/";
			File file = new File(filePath + currentDate + "-" + fileName);
			//파일 저장
			thumbnail.transferTo(file);

			param.setThumbNailSrc("http://hproj.cafe24.com/resources/images/contents/" + currentDate + "-" + fileName);
		} else {
			logger.error("start 333 not image");
			param.setThumbNailSrc("http://hproj.cafe24.com/resources/images/no_Image.png");
		}

		logger.error("start 444 end");
		map.put("code", 200);
		if(boardService.boardReg(param) == 1){
			map.put("result", 1);
		} else {
			map.put("result", 2);
		}

		return map;
	}
}

