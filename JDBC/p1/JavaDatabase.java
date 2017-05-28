package p1;

import java.sql.*;

public class JavaDatabase {

	/**
	 * @param args
	 */
	Connection conn = null;
	// String spath="d:\\db_stu.mdb";//Access 数据库路径
	
	// String dbname=""; //Access 数据库用户名，没有则为空
	// String user=""; //Access 数据库密码，没有则为空
	Statement stmt; // 语句对象，可接受和执行一条SQL语句
	ResultSet rs; // 结果记录集，用于保存查询后返回的结果
	public JavaDatabase() {
		// TODO Auto-generated constructor stub
		// 数据库连接字符串
		// String url
		// ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+spath;
		try {
			// 加载驱动程序
			// DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			// 建立连接
			// conn= DriverManager.getConnection(url);
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_stu", "root", "root");// 帐号和密码
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//查询  id name password sex
	private void quary(String sql){
		try {
			rs = stmt.executeQuery(sql); // 执行查询语句并返回结果
			while (rs.next()) // 循环显示结果
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
	//添加
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
//		new JavaDatabase().update("insert into student values(2365,'李四','男',2345,'英语')");
//		new JavaDatabase().quary("select * from student");
		new JavaDatabase().update("delete from student where id = 1003");
		new JavaDatabase().quary("select * from student");

	}
	
	

}
