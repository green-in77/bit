package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Reply;

//JSP가 요청하는 객체(Singleton)
public class BoardService {
	private static BoardService instance = new BoardService();
	
	private BoardService() {}
	
	public static BoardService getinstance() {
		return instance;
	}
	
	//서비스 요청(글쓰기)
	public int writeok(Board boarddata) {
		BoardDao dao = new BoardDao();
		int result = dao.writeok(boarddata);
		return result;
	}
	
	//서비스 요청(글 목록 보여주기)
	public List<Board> list(int cpage, int pagesize){
		BoardDao dao =  new BoardDao();
		return dao.getList(cpage, pagesize);
	}
	
	//서비스 요청(게시물 총 건수 요청)
	public int totalboardcount() {
		BoardDao dao = new BoardDao();
		return dao.totalBoardCount();
	}
	
	//서비스 요청(게시물 상세보기)
	public Board content(int idx){
		BoardDao dao =  new BoardDao();
		return dao.getContent(idx);
	}
	
	//서비스 요청(글 상세보기 시 조회수 증가)
	public boolean addReadNum(String idx) {
		BoardDao dao = new BoardDao();
		return dao.getReadNum(idx);
	}
	
	//서비스 요청(글 삭제)
	public int board_delete(String idx, String pwd) {
		return new BoardDao().deleteOk(idx, pwd);
	}
	
	//서비스 요청(댓글 입력하기)
	public int replyWrite(int idx_fk, String writer, String userid, String content, String pwd) {
		return new BoardDao().replywrite(idx_fk, writer, userid, content, pwd);
	}
	
	//서비스 요청(댓글 목록조회하기)
	public List<Reply> replyList(String idx_fk){
		return new BoardDao().replylist(idx_fk);
	}
	
	//서비스 요청(댓글 삭제하기)
	public int replyDelete(String no, String pwd) {
		return new BoardDao().replyDelete(no, pwd);
	}
	
	//서비스 요청(게시물 상세조회  > 답글 쓰기(rewriteok)
	public int rewriteok(Board boardata) throws Exception {
		return new BoardDao().reWriteOk(boardata);
	}
	
	//서비스 요청(게시물 수정데이터 조회)
	public Board board_EditContent(String idx) {
		return new BoardDao().getEditContent(idx);
	}
	
	//서비스 요청(게시물 수정) : 다른 테스트(request 요청객체를 parameter 로 사용) >> view 코드 감소, java 코드 증가
	public int board_Edit(HttpServletRequest req) {
		return new BoardDao().boardEdit(req);
	}
	
}
