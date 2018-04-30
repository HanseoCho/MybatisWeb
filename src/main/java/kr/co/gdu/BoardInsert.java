package kr.co.gdu;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardInsert extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String regUser = request.getParameter("regUser");
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		System.out.println("regUser : "+regUser);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("content", content);
		map.put("regUser", regUser);
		System.out.println(map);
		
		DBCon con = new DBCon();
		SqlSessionFactory sqlSessionFactory = con.getConn();
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.insert("user.insertBoard",map);
		System.out.println(cnt);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}
}
