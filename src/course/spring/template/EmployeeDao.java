package course.spring.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import course.spring.Employee;

public class EmployeeDao {
	//spring的JDBCTemplate，可直接執行新增/刪除/修改/查詢 SQL語句
	//且拋出RuntimeException,為unchecked exception無須主動處理
	//JDBCTemplate物件需注入DataSource物件以取得資料庫連線資訊，該關聯由spring設定檔完成
	JdbcTemplate jdbcTemplate;
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	//使用jdbcTemplate執行queryForObject()方法進行查詢:
	//1.SQL敘述使用prepared statement
	//2.queryForObject()第1個參數是SQL字串，第3個參數是SQL需要的參數值，第2個參數是實作介面RowMapper
	//的物件參考(用於協助將資料庫查詢結果經ORM(物件關聯對映)機制轉換為Employee物件)。
	public Employee getEmployeeById(int id) {
		String sql = "select id, firstname,lastname,salary from employee where id=?";
		return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),id);
	}
	//使用RowMapper介面和泛型處理ORM，負責將資料庫查詢的資料列轉換為java物件，意即ORM之處理
	//1.該類別必須實作介面RowMapper，且支援泛型
	//2.方法mapRow()可將傳入的ResultSet物件轉換成Employee物件。
	//3.因為只用於支援外部EmployeeDao類別，且不涉及外部類別狀態，故使用靜態內部類別定義。
	private static class EmployeeRowMapper implements RowMapper<Employee>{
		public Employee mapRow(ResultSet rs,int rowNum)throws SQLException{
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setSalary(rs.getFloat("salary"));
			return employee;
		}
	}

}
