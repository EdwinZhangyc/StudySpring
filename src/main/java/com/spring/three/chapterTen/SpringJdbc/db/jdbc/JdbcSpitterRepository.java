package com.spring.three.chapterTen.SpringJdbc.db.jdbc;

import com.spring.three.chapterTen.SpringJdbc.db.SpitterRepository;
import com.spring.three.chapterTen.SpringJdbc.domain.Spitter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
	
	private JdbcOperations jdbcOperations;

	@Inject
	public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;		
	}

	public long count() {
		return jdbcOperations.queryForLong("select count(id) from Spitter");
	}

	public Spitter save(Spitter spitter) {
		Long id = spitter.getId();
		if (id == null) {
			//long spitterId = insertSpitterAndReturnId(spitter);
			//return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(), spitter.isUpdateByEmail());
		} else {
			jdbcOperations.update("update Spitter set username=?, password=?, fullname=?, email=?, updateByEmail=? where id=?",					
					spitter.getUsername(),
					spitter.getPassword(),
					spitter.getFullName(),
					spitter.getEmail(),
					spitter.isUpdateByEmail(),
					id);
		}
		return spitter;
	}

	/**
	 * 程序清单10.9 使用NameParameterJdbcTempalte/Spring Jdbc模板的命名参数功能
	 */
	private static final String INSERT_SPITTER_ = "insert into Spitter " +
												 " (username, password, fullname, email, updateByEmail) "+
												 "values " +
												 " (:username, :password, :fullname, :mail, :ipdateByEmail)";
	public void addSpitter(Spitter spitter){
		Map<String, Object> paramMap = new HashMap<String, Object> ();
		paramMap.put("username", spitter.getUsername());//绑定参数
		paramMap.put("password", spitter.getPassword());
		paramMap.put("fullname", spitter.getFullName());
		paramMap.put("email", spitter.getEmail());
		paramMap.put("updateByEmail", spitter.isUpdateByEmail());
		//执行数据插入
		jdbcOperations.update(INSERT_SPITTER_, paramMap);
	}

	/**
	 * Inserts a spitter using SimpleJdbcInsert. 
	 * Involves no direct SQL and is able to return the ID of the newly created Spitter.
	 * @param spitter a Spitter to insert into the databse
	 * @return the ID of the newly inserted Spitter
	 */
	//private long insertSpitterAndReturnId(Spitter spitter) {
	//	SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcOperations).withTableName("Spitter");
	//	jdbcInsert.setGeneratedKeyName("id");
	//	Map<String, Object> args = new HashMap<String, Object>();
	//	args.put("username", spitter.getUsername());
	//	args.put("password", spitter.getPassword());
	//	args.put("fullname", spitter.getFullName());
	//	args.put("email", spitter.getEmail());
	//	args.put("updateByEmail", spitter.isUpdateByEmail());
	//	long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
	//	return spitterId;
	//}

	/**
	 * Inserts a spitter using a simple jdbcOperations update() call.
	 * Does not return the ID of the newly created Spitter.
	 * @param spitter a Spitter to insert into the database
	 */
	@SuppressWarnings("unused")
	private void insertSpitter(Spitter spitter) {
		jdbcOperations.update(INSERT_SPITTER, 
			spitter.getUsername(),
			spitter.getPassword(),
			spitter.getFullName(),
			spitter.getEmail(),
			spitter.isUpdateByEmail());
	}

	/**
	 * 由于RowMapper接口只声明了一个方法，因此他符合 functional interface（函数式接口）的 standard
	 * so 该方法还可以使用lambda表达式来写
	 * @param id
	 * @return
	 */
  //public Spitter findOne(long id) {
	//return jdbcOperations.queryForObject(
	//		SELECT_SPITTER + " where id=?", new SpitterRowMapper(), id);
  //}

	/**
	 * 使用lambda表达式写findOne Method  或者分开使用
	 * @param id
	 * @return
	 */
	public Spitter findOne(long id) {
		return jdbcOperations.queryForObject(SELECT_SPITTER + " where id=?",
				(rs, rowNum) -> {
					return new Spitter(
						rs.getLong("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("fullname"),
						rs.getString("email"),
						rs.getBoolean("updateByEmail"));
				},
				id);
	}
	/**
	 * 使用lambda表达式写findOne Method  或者分开使用
	 * @param id
	 * @return
	 */
	public Spitter findOneSpittle(long id) {
		return jdbcOperations.queryForObject(SELECT_SPITTER + " where id=?",
				this::mapSpitter, id);
	}

	private Spitter mapSpitter(ResultSet rs, int i) throws SQLException {
		return new Spitter(
				rs.getLong("id"),
				rs.getString("username"),
				rs.getString("password"),
				rs.getString("fullname"),
				rs.getString("email"),
				rs.getBoolean("updateByEmail"));
	}

	public Spitter findByUsername(String username) {
		return jdbcOperations.queryForObject("select id, username, password, fullname, email, updateByEmail from Spitter where username=?", new SpitterRowMapper(), username);
  }

	public List<Spitter> findAll() {
		return jdbcOperations.query("select id, username, password, fullname, email, updateByEmail from Spitter order by id", new SpitterRowMapper());
	}

	private static final class SpitterRowMapper implements RowMapper<Spitter> {
		public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
			long id = rs.getLong("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String fullName = rs.getString("fullname");
			String email = rs.getString("email");
			boolean updateByEmail = rs.getBoolean("updateByEmail");
			return new Spitter(id, username, password, fullName, email, updateByEmail);
		}		
	}

	private static final String INSERT_SPITTER = "insert into Spitter (username, password, fullname, email, updateByEmail) values (?, ?, ?, ?, ?)";

	private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter";

}
