package kr.co.gdu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardView extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBCon con = new DBCon();
		SqlSessionFactory sqlSessionFactory = con.getConn();
		SqlSession session = sqlSessionFactory.openSession(true);
		request.setCharacterEncoding("UTF-8");
		String boardNo = request.getParameter("boardNo");
		String regUser = request.getParameter("regUser");
		System.out.println("boardNo : "+boardNo);
		System.out.println("regUser : "+regUser);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardNo", boardNo);
		map.put("regUser", regUser);
		System.out.println(map);
		
		HashMap<String, Object> data = session.selectOne("user.selectBoardOne", map);
		System.out.println(data);
		
		request.setAttribute("data", data);
		RequestDispatcher dis = request.getRequestDispatcher("boardView.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
