package p1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class myjavaDB {
	public static void main(String args[]) {
		new TestJavaDB();
	}
}

class TestJavaDB extends Frame implements ActionListener, WindowListener,
		ItemListener {
	Label la1, la2, la3, la4, la5, la6, la7, la8;
	TextField num, nam, cla_num, mar, gjz;
	Choice se;
	Choice se1;
	Button bt, bt_bc, bt_sc, bt_cx;
	List li;
	Panel pa;
	Connection conn = null;

	TestJavaDB() {
		la1 = new Label("学号");
		la2 = new Label("姓名");
		la3 = new Label("性别");
		la4 = new Label("班级编号");
		la5 = new Label("成绩");
		la6 = new Label("欢迎来到Java数据库编程！");

		la7 = new Label("按照");
		la8 = new Label("查询，且关键字");

		num = new TextField(10);
		nam = new TextField(10);
		cla_num = new TextField(10);
		mar = new TextField(10);
		gjz = new TextField(10);

		se = new Choice();
		se.add("m");
		se.add("f");

		se1 = new Choice();
		se1.add("学号");
		se1.add("姓名");
		se1.add("性别");
		se1.add("班号");

		bt = new Button("添加");
		bt_bc = new Button("保存");
		bt_sc = new Button("删除");
		bt_cx = new Button("查询");
		li = new List(8, false);
		pa = new Panel();

		pa.add(la1);
		pa.add(num);
		pa.add(la2);
		pa.add(nam);
		pa.add(la3);
		pa.add(se);
		pa.add(la4);
		pa.add(cla_num);
		pa.add(la5);
		pa.add(mar);
		pa.add(bt);
		pa.add(bt_bc);
		pa.add(bt_sc);
		pa.add(la7);
		pa.add(se1);
		pa.add(la8);
		pa.add(gjz);
		pa.add(bt_cx);

		bt.addActionListener(this);
		bt_bc.addActionListener(this);
		bt_sc.addActionListener(this);
		bt_cx.addActionListener(this);
		addWindowListener(this); // 注册窗体监听器
		li.addItemListener(this); // 向li注册监听器

		// 设置当前容器的布局管理器
		BorderLayout bl = new BorderLayout(10, 10);
		setLayout(bl);

		add(la6, BorderLayout.NORTH);
		add(pa, BorderLayout.CENTER);
		add(li, BorderLayout.SOUTH);

		setTitle("Java数据库编程示例");
		setSize(900, 600);
		setVisible(true);

		String spath = "C://Users//张志鹏//Desktop//Java Web//Java数据库应用//db_stu.mdb";// Access
		// 数据库路径
		// 数据库连接字符串
		// String url
		// ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+spath;
		try {
			// 加载驱动程序
			// DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			// 建立连接
			// conn= DriverManager.getConnection(url);
			
			//注册驱动   
			Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
			String url = "jdbc:Access:///" + spath;
			//获取连接
			conn = DriverManager.getConnection(url, "", ""); // 后两个参数分别表示用户名和密码
		} catch (Exception e) {
			la6.setText("数据库连接出错！");
		}
		;

		showData();
	}

	public void showData() {
		String sql = "select * from student order by number"; // SQL查询语句
		String s = "";
		Statement stmt; // 语句对象，可接受和执行一条SQL语句
		ResultSet rs; // 结果记录集，用于保存查询后返回的结果
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 执行查询语句并返回结果

			while (rs.next()) // 循环显示结果
			{
				s = rs.getString("number") + " ";
				s += rs.getString("name") + " ";
				s += rs.getString("sex") + " ";
				s += rs.getString("class_number") + " ";
				s += rs.getInt("mark");

				li.add(s);
			}
		} catch (Exception e) {
			la6.setText("数据查询出错！");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) // 添加数据
		{
			try {
				Statement stmt = conn.createStatement();
				String sql_cx = "select number from student where number='"
						+ num.getText() + "'"; // SQL查询语句
				ResultSet rs = stmt.executeQuery(sql_cx);

				if (!rs.next()) {
					String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
					/*
					 * 
					 * 表示预编译的 SQL 语句的对象。 
						SQL 语句被预编译并存储在 PreparedStatement 对象中。然后可以使用此对象多次高效地执行该语句。 
					 */
					// 执行SQL语句，将数据添加到数据库中
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, num.getText());
					ps.setString(2, nam.getText());
					ps.setString(3, se.getSelectedItem());
					ps.setString(4, cla_num.getText());
					ps.setInt(5, Integer.parseInt(mar.getText()));
					ps.executeUpdate();

					// String
					// sql="INSERT INTO student VALUES('"+num.getText()+"','"+nam.getText()+"','"+se.getSelectedItem()+"','"+cla_num.getText()+"',"+mar.getText()+")";
					// String
					// sql="INSERT INTO student VALUES('2300080203','张三','m','23000802',97)";
					// stmt.executeUpdate(sql);
					la6.setText("数据添加成功！");

					// 将各文本框清空
					num.setText("");
					nam.setText("");
					cla_num.setText("");
					mar.setText("");

					// 将焦点设置在第一个文本框上
					num.requestFocus();

					li.removeAll(); // 删除列表框li中所有的数据
					showData(); // 重新显示当前数据，以便将新添加的数据显示出来
				} else {
					la6.setText("学号重复！");
				}
			} catch (Exception SQLe) {
				la6.setText("输入数据错误！");
			}
		} else if (e.getSource() == bt_bc) // 修改保存数据
		{
			try {
				Statement stmt = conn.createStatement();
				String sql_cx = "select number from student where number='"
						+ num.getText() + "' and number!='" + la6.getText()
						+ "'"; // SQL查询语句
				ResultSet rs = stmt.executeQuery(sql_cx);
				if (!rs.next()) {
					Statement stmt1 = conn.createStatement();
					String sql = "update student set number='" + num.getText()
							+ "',name='" + nam.getText() + "',sex='"
							+ se.getSelectedItem() + "',class_number='"
							+ cla_num.getText() + "',mark=" + mar.getText()
							+ " where number='" + la6.getText() + "'";
					stmt1.executeUpdate(sql);

					la6.setText("数据保存成功！");

					// 将各文本框清空
					num.setText("");
					nam.setText("");
					cla_num.setText("");
					mar.setText("");

					// 将焦点设置在第一个文本框上
					num.requestFocus();

					li.removeAll(); // 删除列表框li中所有的数据
					showData(); // 重新显示当前数据，以便将新添加的数据显示出来
				}

				else {
					la6.setText("学号重复！");
				}
			} catch (Exception SQLe) {
				la6.setText("输入数据错误！");
			}
		} else if (e.getSource() == bt_sc) {
			try {
				Statement stmt1 = conn.createStatement();
				String sql = "delete from student where number='"
						+ la6.getText() + "'";
				stmt1.executeUpdate(sql);

				la6.setText("数据删除成功！");

				// 将各文本框清空
				num.setText("");
				nam.setText("");
				cla_num.setText("");
				mar.setText("");

				// 将焦点设置在第一个文本框上
				num.requestFocus();

				li.removeAll(); // 删除列表框li中所有的数据
				showData(); // 重新显示当前数据，以便将新添加的数据显示出来
			} catch (Exception SQLe) {
				la6.setText("输入数据错误！");
			}
		} else if (e.getSource() == bt_cx) // 查询数据
		{
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = null;

				String sql = "select * from student";
				String tj = gjz.getText().trim();
				if (tj.length() > 0) {
					if (se1.getSelectedItem().equals("学号")) {
						sql += " where number like'%" + tj + "%'";
					} else if (se1.getSelectedItem().equals("姓名")) {
						sql += " where name like'%" + tj + "%'";
					} else if (se1.getSelectedItem().equals("性别")) {
						sql += " where sex like'%" + tj + "%'";
					} else if (se1.getSelectedItem().equals("班号")) {
						sql += " where class_number like'%" + tj + "%'";
					}
				}
				sql += " order by number";

				rs = stmt.executeQuery(sql);

				// 将各文本框清空
				num.setText("");
				nam.setText("");
				cla_num.setText("");
				mar.setText("");

				// 将焦点设置在第一个文本框上
				num.requestFocus();
				li.removeAll(); // 删除列表框li中所有的数据
				// showData(); //重新显示当前数据，以便将新添加的数据显示出来

				String s = "";
				while (rs.next()) // 循环显示结果
				{
					s = rs.getString("number") + " ";
					s += rs.getString("name") + " ";
					s += rs.getString("sex") + " ";
					s += rs.getString("class_number") + " ";
					s += rs.getInt("mark");

					li.add(s);
				}
			} catch (Exception SQLe) {
				la6.setText("输入数据错误！");
			}
		}

	}

	public void itemStateChanged(ItemEvent e) // 处理选择事件
	{
		List t;
		t = (List) (e.getItemSelectable());
		String[] names = t.getSelectedItems(); // 获取所有被选中的项
		String s = "";
		// for(int i=0;i<names.length;i++)
		// {
		// s+=" "+names[i];
		// }
		s = names[0];
		la6.setText(s.substring(0, 10));
		// num.setText(s.substring(0,10));
		// nam.setText(s.substring(0,10));
		String[] s_arr = s.split(" ");
		num.setText(s_arr[0]);
		nam.setText(s_arr[1]);
		cla_num.setText(s_arr[3]);
		mar.setText(s_arr[4]);
		se.select(s_arr[2]);
	}

	public void windowClosing(WindowEvent e) // 响应窗口关闭框关闭窗口的事件
	{
		try {
			conn.close();
			dispose();
			System.exit(0);
		} catch (SQLException e_winclo) {
		}
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}
}