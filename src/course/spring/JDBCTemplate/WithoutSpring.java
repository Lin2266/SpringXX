package course.spring.JDBCTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import course.spring.Employee;

public class WithoutSpring {
	//JDBC流程與步驟
	public static Employee getEmployeeById(int id) {
		String url = "jdbc:derby://localhost:1527/myDB";
		String username = "root";
		String password = "sa";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			//1.建立Connection物件
			conn = DriverManager.getConnection(url, username, password);
			//2.建立prepareStatement物件
			stmt = conn.prepareStatement("select id,firstname,lastname,salary from"
						+ "employee where id=?");
			stmt.setInt(1,id);
			//3.建立ResultSet物件
			rs = stmt.executeQuery();
			//4.藉由ORM(物件關聯對映)機制轉化ResultSet物件為domain object
			Employee employee = new Employee();
			if(rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setFirstName(rs.getString("firstname"));
				employee.setLastName(rs.getString("lastname"));
				employee.setSalary(rs.getLong("salary"));
			}
			return employee;
			//5.處理SQLException
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//關ＭＵＰ
		}finally {
			//由下往上關
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getEmployeeById(2));
	}
}
