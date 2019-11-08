package kr.or.bit.dto;

import java.util.Date;

//DB jspboard 의 내용을 담을 객체
//DB의 컬럼명과 동일하게 만들기

public class Board { //DTO 데이터를 담는 클래스
	private int idx;
	private String writer;
	private String pwd;
	private String subject;
	private String content;
	//not null (필수입력사항)
	
	//필수인데 기본값이 있는 사항
	private Date writedate; //default SYSDATE
	private int readnum; // default 0;
	
	//부가입력사항
	private String filename;
	private int filesize;
	private String homepage;
	private String email;
	
	//계층형 구조를 위한 컬럼
	private int refer; //글의 묶음
	private int depth; //글의 들여쓰기
	private int step; //글의 순서
	
	public Board() {}

	public Board(int idx, String writer, String pwd, String subject, String content, Date writedate, int readnum,
			String filename, int filesize, String homepage, String email, int refer, int depth, int step) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.pwd = pwd;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.readnum = readnum;
		this.filename = filename;
		this.filesize = filesize;
		this.homepage = homepage;
		this.email = email;
		this.refer = refer;
		this.depth = depth;
		this.step = step;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	//필요에 따라서 구현
	@Override
	public String toString() {
		return "board [idx=" + idx + ", writer=" + writer + ", pwd=" + pwd + ", subject=" + subject + ", content="
				+ content + ", writedate=" + writedate + ", readnum=" + readnum + ", filename=" + filename
				+ ", filesize=" + filesize + ", homepage=" + homepage + ", email=" + email + ", refer=" + refer
				+ ", depth=" + depth + ", step=" + step + "]";
	}
	
}
