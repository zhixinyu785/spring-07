package Zy0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		//��ʽ  jdbc��mysql��//����Ip:�˿ں�/���ݿ���
		String  url="jdbc:mysql://192.168.80.140:3306/";
		String user="root";
		String password="950430";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//ѡ��Ҫ���������ݿ�����---��������(����)
			Class.forName("com.mysql.jdbc.Driver");
			// �������� ����IP �˿ں� �û���  ���� // ѡ��Ҫ���������ݿ�  
		    con = DriverManager.getConnection(url, user, password);
			// ��������� (дsql���)
			pstmt = con.prepareStatement("select * from student");
			// ����sql��䲢�鿴���  �������ɾ�� �򷵻���Ӱ������� ����ǲ�ѯ���ص��ǲ�ѯ���
			// ���е�ʱ��ע�� �������ɾ�������executeUpdate ����int  �����ѯ �����executeQuery ����ResultSet
			rs= pstmt.executeQuery();
			// �鿴�����
			while(rs.next()){
				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
}
			
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
