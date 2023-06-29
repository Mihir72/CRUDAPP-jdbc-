package Persistence;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.*;
import in.IneuronUtil.ai.JDBCUtil;
public class StudentDaoImpl implements IStudentDao {
	

	
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		
		 Connection connection = null;
		PreparedStatement ppstmt = null;
		int rowsAffected = 0;
		
		
		try {
			connection = JDBCUtil.jdbc_Connection();
			if(connection != null) {
				String insertQuery = "insert into student(name,age,address) values(?,?,?)";
				try {
					ppstmt = connection.prepareStatement(insertQuery);
					if(ppstmt != null) {
						ppstmt.setString(1, sname);
						ppstmt.setInt(2, sage);
						ppstmt.setString(3, saddress);
						rowsAffected = ppstmt.executeUpdate();
					}
					if(rowsAffected == 0)
						return "failure";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
			
		
		return "success";
	}

	@Override
	public Student searchStudent(Integer sid) {
		String selectQuery = "select * from student where id=?";
		Connection connection = null;
		PreparedStatement ppstmt = null;
		ResultSet resultSet = null;
		
			try {
				connection = JDBCUtil.jdbc_Connection();
                if(connection != null) {
				ppstmt = connection.prepareStatement(selectQuery);
				ppstmt.setInt(1, sid);
                }
				if(ppstmt != null) {
					resultSet = ppstmt.executeQuery();
				}
				if(resultSet != null) {
					if(resultSet.next()) {
						Student std = new Student();
						std.setSid(resultSet.getInt(1));
						std.setSname(resultSet.getString(2));
						std.setSage(resultSet.getInt(3));
						std.setSaddress(resultSet.getString(4));
						return std;
					}
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			
		return null;
	}

	@Override
	public String updateStudent(Student std) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String updateQuery = "update student set name=?,age=?,address=? where id="+std.getSid();
		int rowsAffected = 0;
		
		try {
			connection = JDBCUtil.jdbc_Connection();
			if(connection != null) {
				pstmt = connection.prepareStatement(updateQuery);
				pstmt.setString(1,std.getSname());
				pstmt.setInt(2, std.getSage());
				pstmt.setString(3,std.getSaddress());
				
				rowsAffected = pstmt.executeUpdate();
			}
			if(rowsAffected != 0) {
				return "success";
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String deleteStudent(Integer sid) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String deleteQuery = "delete from student where id=?";
		int rowsAffected = 0;
		
		try {
			connection = JDBCUtil.jdbc_Connection();
			if(connection != null) {
				pstmt = connection.prepareStatement(deleteQuery);
			}
			if(pstmt != null) {
				pstmt.setInt(1, sid);
				rowsAffected = pstmt.executeUpdate();
			}
			if(rowsAffected != 0)
				return "successfull";
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "unsuccessfull";
	}
	
	
	public Student selectQuery(Integer sid)  {
		 Student std = null;
		 Connection connection = null;
		 PreparedStatement pstmt = null;
		 ResultSet resultSet = null;
		 String selectQuery = "select id,name,age,address from student where id=?";
		 
		 try {
			connection = JDBCUtil.jdbc_Connection();
			if(connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}
			if(pstmt != null) {
				pstmt.setInt(1, sid);
				resultSet = pstmt.executeQuery();
				if(resultSet != null) {
					if(resultSet.next()) {
						std = new Student();
						std.setSid(resultSet.getInt(1));
						std.setSname(resultSet.getString(2));
						std.setSage(resultSet.getInt(3));
						std.setSaddress(resultSet.getString(4));
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return std;
	}
       
}


