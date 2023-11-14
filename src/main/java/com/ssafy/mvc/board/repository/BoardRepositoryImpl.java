package com.ssafy.mvc.board.repository;

import com.ssafy.mvc.board.dto.BoardDto;
import com.ssafy.mvc.board.dto.ReplyDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private final SqlSession session;

    @Autowired
    public BoardRepositoryImpl(SqlSession session){
        this.session = session;
    }

    String ns = "com.ssafy.mvc.board.repository.BoardRepository.";

    @Override
    public void writeArticle(BoardDto boardDto) throws SQLException {
        session.insert(ns + "boardWrite", boardDto);
    }

    @Override
    public List<BoardDto> listArticle(Map<String, Object> param) throws SQLException {
        return session.selectList(ns + "boardList", param);
    }

    @Override
    public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
        return session.selectOne(ns + "boardCount", param);
    }

    @Override
    public BoardDto getArticle(int articleNo) throws SQLException {
        return session.selectOne(ns + "getArticle", articleNo);
    }

    @Override
    public void updateHit(int articleNo) throws SQLException {
        session.update(ns + "updateHit", articleNo);
    }

    @Override
    public void modifyArticle(BoardDto boardDto) throws SQLException {
        session.update(ns + "modifyArticle", boardDto);
    }

    @Override
    public void deleteArticle(int articleNo) throws SQLException {
        session.delete(ns + "deleteArticle", articleNo);
    }

    @Override
    public void addReply(ReplyDto replyDto) throws SQLException {
        session.insert(ns + "addReply", replyDto);
    }

	@Override
	public List<ReplyDto> listReply(int articleNo) throws SQLException {
		return session.selectList(ns+"listReply", articleNo);
	}
}
