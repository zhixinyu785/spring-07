package Zy0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 格式  jdbc:mysql://主机Ip:端口号/数据库名
		String url="jdbc:mysql://192.168.80.140:3306/db2?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="950430";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String name="input";
		String pwd="input";
		try {
			//选择要操作的数据库种类---加载驱动(反射)
			Class.forName("com.mysql.jdbc.Driver");
			// 创建连接 主机IP 端口号 用户名  密码 // 选择要操作的数据库  
		    con = DriverManager.getConnection(url, user, password);
			// 创建命令窗口 (写sql语句)
			pstmt = con.prepareStatement("insert into student(name,b_id,gerden) values(?,?,?)");
			// 运行sql语句并查看结果  如果是增删改 则返回受影响的行数 如果是查询返回的是查询结果
			// 运行的时候注意 如果是增删改则调用executeUpdate 返回int  如果查询 则调用executeQuery 返回ResultSet
			// 注入参数
			pstmt.setString(1, "123");
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 0);
			// 执行语句
			int i=pstmt.executeUpdate();
			System.out.println(i);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
