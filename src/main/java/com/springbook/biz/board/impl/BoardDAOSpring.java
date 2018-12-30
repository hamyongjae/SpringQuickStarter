package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository("boardDAOSpring")
public class BoardDAOSpring {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	// SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
			+ "values((select nvl(max(seq),0)+1 from board ALIAS_FOR_SUBQUERY),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from board where seq=?";	
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제

	public void deleteBoard(BoardVO vo) {
		int temp = vo.getSeq();
		System.out.println("ㅇㅇ");
		System.out.println(temp);
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

//
//class BoardRowMapper implements RowMapper<BoardVO> {
//
//	@Override
//	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//		BoardVO board = new BoardVO();
//		board.setSeq(rs.getInt("SEQ"));
//		board.setTitle(rs.getString("TITLE"));
//		board.setWriter(rs.getString("WRITER"));
//		board.setContent(rs.getString("CONTENT"));
//		board.setRegDate(rs.getDate("REGDATE"));
//		board.setCnt(rs.getInt("CNT"));
//		return board;
//	}
//}
