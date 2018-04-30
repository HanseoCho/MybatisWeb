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
		// File Load (물리적 파일을 Byte 배열에 담아주는 작업)
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// Mybatis에서 JDBC 연결해 주는 작업
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public SqlSessionFactory getConn() {
		return sqlSessionFactory;
	}
}
