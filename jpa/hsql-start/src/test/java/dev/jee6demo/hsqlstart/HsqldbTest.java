package dev.jee6demo.hsqlstart;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HsqldbTest {
	static Connection conn;   
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");
		//mem or file
		conn = DriverManager.getConnection("jdbc:hsqldb:file:target/dbFileName",
		//conn = DriverManager.getConnection("jdbc:hsqldb:mem:dbName",
				"sa",
				"");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
		conn.close();
	}

	@Test
	public void pruebaDB(){
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT 1 FROM INFORMATION_SCHEMA.SYSTEM_USERS");
			assertTrue(rs.next());
			st.close(); 
		} catch (SQLException e) {
			fail("SQLException "+e.getMessage());
			e.printStackTrace();
		}
	}
}
