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
public class BoardList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBCon con = new DBCon();
		SqlSessionFactory sqlSessionFactory = con.getConn();
		SqlSession session = sqlSessionFactory.openSession(true);
		
		String regUser = request.getParameter("regUser");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("regUser", regUser);
		System.out.println(map);
		
		List<HashMap<String, Object>> list = session.selectList("user.selectBoard", map);
		
		
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("boardList.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
