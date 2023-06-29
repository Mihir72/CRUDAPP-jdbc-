package Dao_Factory;
import Persistence.IStudentDao;
import Persistence.StudentDaoImpl;

public class StudentDaoFactory {
 
	private StudentDaoFactory() {}
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao() {
		if(studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
	
}
