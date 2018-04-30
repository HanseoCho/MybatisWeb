package kr.go.gdu;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.gdu.DBCon;

public class UserList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBCon con = new DBCon();
		SqlSessionFactory sqlSessionFactory = con.getConn();
		System.out.println(sqlSessionFactory);
		// JDBC 연결되어 있는 것중에 하나의 연결 통로를 생성
		SqlSession session = sqlSessionFactory.openSession(true);
		/*
		 session.selectOne(""); -> 하나 행 가져오기
		 session.selectList(""); -> 여러개 행 가져오기
		 session.insert(""); -> 데이터 입력
		 session.update(""); -> 데이터 수정
		 session.delete(""); -> 데이터 삭제		 
		 */
		List<HashMap<String, Object>> list = session.selectList("user.selectUser");
		/*for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}*/
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("userList.Jsp");
		dis.forward(request, response);
		System.out.println("End");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
