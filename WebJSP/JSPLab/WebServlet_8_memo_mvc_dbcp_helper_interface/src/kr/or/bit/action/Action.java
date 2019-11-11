package kr.or.bit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { //interface 사용시 강제구현 해야함
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
