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
		la1 = new Label("ѧ��");
		la2 = new Label("����");
		la3 = new Label("�Ա�");
		la4 = new Label("�༶���");
		la5 = new Label("�ɼ�");
		la6 = new Label("��ӭ����Java���ݿ��̣�");

		la7 = new Label("����");
		la8 = new Label("��ѯ���ҹؼ���");

		num = new TextField(10);
		nam = new TextField(10);
		cla_num = new TextField(10);
		mar = new TextField(10);
		gjz = new TextField(10);

		se = new Choice();
		se.add("m");
		se.add("f");

		se1 = new Choice();
		se1.add("ѧ��");
		se1.add("����");
		se1.add("�Ա�");
		se1.add("���");

		bt = new Button("���");
		bt_bc = new Button("����");
		bt_sc = new Button("ɾ��");
		bt_cx = new Button("��ѯ");
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
		addWindowListener(this); // ע�ᴰ�������
		li.addItemListener(this); // ��liע�������

		// ���õ�ǰ�����Ĳ��ֹ�����
		BorderLayout bl = new BorderLayout(10, 10);
		setLayout(bl);

		add(la6, BorderLayout.NORTH);
		add(pa, BorderLayout.CENTER);
		add(li, BorderLayout.SOUTH);

		setTitle("Java���ݿ���ʾ��");
		setSize(900, 600);
		setVisible(true);

		String spath = "C://Users//��־��//Desktop//Java Web//Java���ݿ�Ӧ��//db_stu.mdb";// Access
		// ���ݿ�·��
		// ���ݿ������ַ���
		// String url
		// ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+spath;
		try {
			// ������������
			// DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			// ��������
			// conn= DriverManager.getConnection(url);
			
			//ע������   
			Class.forName("com.hxtt.sql.access.AccessDriver").newInstance();
			String url = "jdbc:Access:///" + spath;
			//��ȡ����
			conn = DriverManager.getConnection(url, "", ""); // �����������ֱ��ʾ�û���������
		} catch (Exception e) {
			la6.setText("���ݿ����ӳ���");
		}
		;

		showData();
	}

	public void showData() {
		String sql = "select * from student order by number"; // SQL��ѯ���
		String s = "";
		Statement stmt; // �����󣬿ɽ��ܺ�ִ��һ��SQL���
		ResultSet rs; // �����¼�������ڱ����ѯ�󷵻صĽ��
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // ִ�в�ѯ��䲢���ؽ��

			while (rs.next()) // ѭ����ʾ���
			{
				s = rs.getString("number") + " ";
				s += rs.getString("name") + " ";
				s += rs.getString("sex") + " ";
				s += rs.getString("class_number") + " ";
				s += rs.getInt("mark");

				li.add(s);
			}
		} catch (Exception e) {
			la6.setText("���ݲ�ѯ����");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) // �������
		{
			try {
				Statement stmt = conn.createStatement();
				String sql_cx = "select number from student where number='"
						+ num.getText() + "'"; // SQL��ѯ���
				ResultSet rs = stmt.executeQuery(sql_cx);

				if (!rs.next()) {
					String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
					/*
					 * 
					 * ��ʾԤ����� SQL ���Ķ��� 
						SQL ��䱻Ԥ���벢�洢�� PreparedStatement �����С�Ȼ�����ʹ�ô˶����θ�Ч��ִ�и���䡣 
					 */
					// ִ��SQL��䣬��������ӵ����ݿ���
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
					// sql="INSERT INTO student VALUES('2300080203','����','m','23000802',97)";
					// stmt.executeUpdate(sql);
					la6.setText("������ӳɹ���");

					// �����ı������
					num.setText("");
					nam.setText("");
					cla_num.setText("");
					mar.setText("");

					// �����������ڵ�һ���ı�����
					num.requestFocus();

					li.removeAll(); // ɾ���б��li�����е�����
					showData(); // ������ʾ��ǰ���ݣ��Ա㽫����ӵ�������ʾ����
				} else {
					la6.setText("ѧ���ظ���");
				}
			} catch (Exception SQLe) {
				la6.setText("�������ݴ���");
			}
		} else if (e.getSource() == bt_bc) // �޸ı�������
		{
			try {
				Statement stmt = conn.createStatement();
				String sql_cx = "select number from student where number='"
						+ num.getText() + "' and number!='" + la6.getText()
						+ "'"; // SQL��ѯ���
				ResultSet rs = stmt.executeQuery(sql_cx);
				if (!rs.next()) {
					Statement stmt1 = conn.createStatement();
					String sql = "update student set number='" + num.getText()
							+ "',name='" + nam.getText() + "',sex='"
							+ se.getSelectedItem() + "',class_number='"
							+ cla_num.getText() + "',mark=" + mar.getText()
							+ " where number='" + la6.getText() + "'";
					stmt1.executeUpdate(sql);

					la6.setText("���ݱ���ɹ���");

					// �����ı������
					num.setText("");
					nam.setText("");
					cla_num.setText("");
					mar.setText("");

					// �����������ڵ�һ���ı�����
					num.requestFocus();

					li.removeAll(); // ɾ���б��li�����е�����
					showData(); // ������ʾ��ǰ���ݣ��Ա㽫����ӵ�������ʾ����
				}

				else {
					la6.setText("ѧ���ظ���");
				}
			} catch (Exception SQLe) {
				la6.setText("�������ݴ���");
			}
		} else if (e.getSource() == bt_sc) {
			try {
				Statement stmt1 = conn.createStatement();
				String sql = "delete from student where number='"
						+ la6.getText() + "'";
				stmt1.executeUpdate(sql);

				la6.setText("����ɾ���ɹ���");

				// �����ı������
				num.setText("");
				nam.setText("");
				cla_num.setText("");
				mar.setText("");

				// �����������ڵ�һ���ı�����
				num.requestFocus();

				li.removeAll(); // ɾ���б��li�����е�����
				showData(); // ������ʾ��ǰ���ݣ��Ա㽫����ӵ�������ʾ����
			} catch (Exception SQLe) {
				la6.setText("�������ݴ���");
			}
		} else if (e.getSource() == bt_cx) // ��ѯ����
		{
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = null;

				String sql = "select * from student";
				String tj = gjz.getText().trim();
				if (tj.length() > 0) {
					if (se1.getSelectedItem().equals("ѧ��")) {
						sql += " where number like'%" + tj + "%'";
					} else if (se1.getSelectedItem().equals("����")) {
						sql += " where name like'%" + tj + "%'";
					} else if (se1.getSelectedItem().equals("�Ա�")) {
						sql += " where sex like'%" + tj + "%'";
					} else if (se1.getSelectedItem().equals("���")) {
						sql += " where class_number like'%" + tj + "%'";
					}
				}
				sql += " order by number";

				rs = stmt.executeQuery(sql);

				// �����ı������
				num.setText("");
				nam.setText("");
				cla_num.setText("");
				mar.setText("");

				// �����������ڵ�һ���ı�����
				num.requestFocus();
				li.removeAll(); // ɾ���б��li�����е�����
				// showData(); //������ʾ��ǰ���ݣ��Ա㽫����ӵ�������ʾ����

				String s = "";
				while (rs.next()) // ѭ����ʾ���
				{
					s = rs.getString("number") + " ";
					s += rs.getString("name") + " ";
					s += rs.getString("sex") + " ";
					s += rs.getString("class_number") + " ";
					s += rs.getInt("mark");

					li.add(s);
				}
			} catch (Exception SQLe) {
				la6.setText("�������ݴ���");
			}
		}

	}

	public void itemStateChanged(ItemEvent e) // ����ѡ���¼�
	{
		List t;
		t = (List) (e.getItemSelectable());
		String[] names = t.getSelectedItems(); // ��ȡ���б�ѡ�е���
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

	public void windowClosing(WindowEvent e) // ��Ӧ���ڹرտ�رմ��ڵ��¼�
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