package Zy0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ʽ  jdbc:mysql://����Ip:�˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.80.140:3306/db2?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="950430";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String name="input";
		String pwd="input";
		try {
			//ѡ��Ҫ���������ݿ�����---��������(����)
			Class.forName("com.mysql.jdbc.Driver");
			// �������� ����IP �˿ں� �û���  ���� // ѡ��Ҫ���������ݿ�  
		    con = DriverManager.getConnection(url, user, password);
			// ��������� (дsql���)
			pstmt = con.prepareStatement("insert into student(name,b_id,gerden) values(?,?,?)");
			// ����sql��䲢�鿴���  �������ɾ�� �򷵻���Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ���
			// ���е�ʱ��ע�� �������ɾ�������executeUpdate ����int  �����ѯ �����executeQuery ����ResultSet
			// ע�����
			pstmt.setString(1, "123");
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 0);
			// ִ�����
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
