package Service;
import Dao_Factory.StudentDaoFactory;
import Persistence.IStudentDao;
import Service_Factory.StudentServiceFactory;
import dto.Student;

public class StudentServiceImpl implements IStudentService{
	
	IStudentDao studentDao = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		Student s = null;
		if(studentDao != null) {
			 s = studentDao.searchStudent(sid);
		}
		return s; // either s contains null or sum object 
		
	}

	@Override
	public String updateStudent(Student std) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(std);
	}

	@Override
	public String deleteStudent(Integer sid) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(sid);
	}
	
	public Student selectQuery(Integer sid) {
	   studentDao = StudentDaoFactory.getStudentDao();
	   return studentDao.selectQuery(sid);
	}
}
