package springmvc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SpringDAO {
	JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public void insert (Student s) {
		jt.update("insert into students values("+s.getId()+",'"+s.getName()+"')");
	}
	public void update(Student s) {
		jt.update("update students set name='"+s.getName()+"' where id="+s.getId());
	}
	public Student find(int id) {
		
		return jt.queryForObject("select * from students where id=?", new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
	}
	
	public void delete(int id) {
		jt.update("delete from students where id="+id);
	}
	public List<Student> findall(){
		return jt.query("select * from students", new RowMapper<Student> () {
			public Student mapRow(ResultSet rs,int row) throws SQLException {
				Student s=new Student ();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				return s;
			}
		});
	}

}
