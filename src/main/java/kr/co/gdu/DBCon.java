package kr.co.gdu;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBCon {
	SqlSessionFactory sqlSessionFactory;
	public DBCon() throws IOException {
		String resource = "kr/co/gdu/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource); 		// File Load (물리적 파일을 Byte 배열에 담아주는 작업)
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		// Mybatis에서 JDBC 연결해 주는 작업
	}
	
	public SqlSessionFactory getConn() {
		return sqlSessionFactory;
	}
}
