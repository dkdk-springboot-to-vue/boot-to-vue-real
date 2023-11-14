package com.ssafy.mvc.board.service;

import com.ssafy.mvc.board.dto.BoardDto;
import com.ssafy.mvc.board.dto.BoardListDto;
import com.ssafy.mvc.board.dto.ReplyDto;
import com.ssafy.mvc.board.repository.BoardRepository;
import com.ssafy.mvc.util.PageNavigation;
import com.ssafy.mvc.util.SizeConstant;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BoardServiceImpl implements BoardService {
	private final BoardRepository boardRepository;
	
	private BoardServiceImpl( BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public void writeArticle(BoardDto boardDto) throws Exception {
		boardRepository.writeArticle(boardDto);
	}

	@Override
	public BoardListDto listArticle(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		System.out.println(map);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);
		
		
		String key = map.get("key");
//		if("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
//		int pgno = Integer.parseInt(map.get("pgno"));
//		int start = pgno * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;

		List<BoardDto> list = boardRepository.listArticle(param);
		int totalArticleCount = boardRepository.getTotalArticleCount(param);
		int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;
		
		BoardListDto boardListDto = new BoardListDto();
		boardListDto.setArticles(list);
		boardListDto.setCurrentPage(currentPage);
		boardListDto.setTotalPageCount(totalPageCount);
		return boardListDto;
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
//		if ("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
		int totalCount = boardRepository.getTotalArticleCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		BoardDto boardDto = boardRepository.getArticle(articleNo);
		List<ReplyDto> replyList = boardRepository.listReply(articleNo);
		boardDto.setReplies(replyList);
		return boardDto;
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		boardRepository.updateHit(articleNo);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		// TODO : BoardDaoImpl의 modifyArticle 호출
		boardRepository.modifyArticle(boardDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		// TODO : BoardDaoImpl의 deleteArticle 호출
		boardRepository.deleteArticle(articleNo);
	}

	@Override
	public void addReply(ReplyDto replyDto) throws SQLException {
		// TODO Auto-generated method stub
		boardRepository.addReply(replyDto);
	}
	
	

}
