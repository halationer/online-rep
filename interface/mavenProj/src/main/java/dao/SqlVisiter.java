package dao;

import java.util.*;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;

public class SqlVisiter {

//	private static String url;
//	private static String name;
//	private static String password;
	private static DruidDataSource datasourse = new DruidDataSource();
	
	static {
		try {
			//读取配置文件
			Properties properties = new Properties();
			InputStream in = SqlVisiter.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(in);
			in.close();
			
			//连接池用法
			datasourse.setDriverClassName("com.mysql.jdbc.Driver");
			datasourse.setUrl(properties.getProperty("url"));
			datasourse.setUsername(properties.getProperty("name"));
			datasourse.setPassword(properties.getProperty("password"));
			datasourse.setMaxActive(20);
			datasourse.setMinIdle(8);
			
			/*  基础用法
				Class.forName("com.mysql.jdbc.Driver");
				url = properties.getProperty("url");
				name = properties.getProperty("name");
				password = properties.getProperty("password");
				System.out.println(url + '\n' + name);
				System.out.println("database init success!\n");
			*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SqlVisiter() {
		// TODO Auto-generated constructor stub
	}
	
	private static Connection getConnection() throws SQLException 
	{
		return datasourse.getConnection();
//		return DriverManager.getConnection(url, name, password);
	}
	
	private static void close(PreparedStatement pstmt, Connection con) throws SQLException 
	{
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}
	
	private static void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException 
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}
	
	public static int executeUpdate(String sql, Object... params)
	{
		int count = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			if(params != null)
				for(int i=0; i<params.length; i++)
					pstmt.setObject(i+1, params[i]);
			System.out.println((count = pstmt.executeUpdate()) + "行已修改");
			close(pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public static <T> List<T> executeQuery(String sql, Class<T> clz, Object... params)
	{
		List<T> rslist = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			if(params != null)
				for(int i=0; i<params.length; i++)
					pstmt.setObject(i+1, params[i]);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				T t = clz.newInstance();							//根据传入的类对象创建一个实例
				Field[] fields = clz.getDeclaredFields(); 			//获取类的所有属性
				for(Field field : fields)
				{
					//驼峰转化为下划线类型
					StringBuilder fieldname = new StringBuilder(field.getName());
					for(int i = 0; i < fieldname.length(); i++)
					{
						char now = fieldname.toString().charAt(i);
						if( now >= 'A' && now <= 'Z')
						{
							fieldname.replace(i, i+1, Character.toString((char)(now - 'A' + 'a')));
							fieldname.insert(i, '_');
						}
					}
					//设置属性
					field.setAccessible(true);						//获取对象私有属性修改权限
					field.set(t, rs.getObject(fieldname.toString()));	//设置对象属性值
				}
				rslist.add(t);
			}
			close(rs, pstmt, con);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rslist;
	}
}
