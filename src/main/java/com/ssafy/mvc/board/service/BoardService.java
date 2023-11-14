package com.ssafy.mvc.board.service;



import com.ssafy.mvc.board.dto.BoardDto;
import com.ssafy.mvc.board.dto.BoardListDto;
import com.ssafy.mvc.board.dto.ReplyDto;
import com.ssafy.mvc.util.PageNavigation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;





public interface BoardService {

	void writeArticle(BoardDto boardDto) throws Exception;
	BoardListDto listArticle(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	void updateHit(int articleNo) throws Exception;
	
	void modifyArticle(BoardDto boardDto) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
	void addReply(ReplyDto replyDto) throws SQLException;
	
}
