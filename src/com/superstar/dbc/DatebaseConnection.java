package com.superstar.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatebaseConnection {
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// private static final String
	// DBURL="jdbc:oralce:thin:@localhost:1521:orcl";
//	private static final String DBURL = "jdbc:Oracle:thin:@127.0.0.1:1521:orcl "; // 配置oracle数据库的远程连接
	private static final String DBURL = "jdbc:Oracle:thin:@192.168.0.181:1521:orcl "; // 配置oracle数据库的远程连接
	private static final String DBUSER = "scott";
	private static final String PASSWORD = "tiger";
	private Connection conn = null;

	/**
	 * 在构造方法里面为conn对象进行实例化，可以直接取得数据库的链接对象<br>
	 * 由于所有的操作都是基于数据库完成的，如果数据库取不到链接，那么也就意味着 所有的操作都可以停止了
	 */
	public DatebaseConnection() {
		try {
			Class.forName(DBDRIVER);
			try {
				this.conn = DriverManager
						.getConnection(DBURL, DBUSER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 取得一个数据库的链接对象
	 * 
	 * @return Connection实例化对象
	 */
	public Connection getConnection() {
		return this.conn;
	}

	/**
	 * 负责关闭数据库连接
	 */
	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
