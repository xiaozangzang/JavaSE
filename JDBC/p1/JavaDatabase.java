package p1;

import java.sql.*;

public class JavaDatabase {

	/**
	 * @param args
	 */
	Connection conn = null;
	// String spath="d:\\db_stu.mdb";//Access ���ݿ�·��
	
	// String dbname=""; //Access ���ݿ��û�����û����Ϊ��
	// String user=""; //Access ���ݿ����룬û����Ϊ��
	Statement stmt; // �����󣬿ɽ��ܺ�ִ��һ��SQL���
	ResultSet rs; // �����¼�������ڱ����ѯ�󷵻صĽ��
	public JavaDatabase() {
		// TODO Auto-generated constructor stub
		// ���ݿ������ַ���
		// String url
		// ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+spath;
		try {
			// ������������
			// DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			// ��������
			// conn= DriverManager.getConnection(url);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_stu", "root", "root");// �ʺź�����
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ѯ  id name password sex
	private void quary(String sql){
		try {
			rs = stmt.executeQuery(sql); // ִ�в�ѯ��䲢���ؽ��
			while (rs.next()) // ѭ����ʾ���
			{
				System.out.print(rs.getString("id") + " ");
				System.out.print(rs.getString("name") + " ");
				System.out.print(rs.getString("sex") + " ");
				System.out.print(rs.getString("password") + " ");
				System.out.println(rs.getString("sex") + " ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	//���
	private void update(String sql){
		try {
			int i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JavaDatabase().quary("select * from student");
//		new JavaDatabase().update("insert into student values(2365,'����','��',2345,'Ӣ��')");
//		new JavaDatabase().quary("select * from student");
		new JavaDatabase().update("delete from student where id = 1003");
		new JavaDatabase().quary("select * from student");

	}
	
	

}
