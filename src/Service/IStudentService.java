package Service;
import dto.Student;

public interface IStudentService {

	// operations to be implemented
		public String addStudent(String sname, Integer sage, String saddress);

		public Student searchStudent(Integer sid);

		public String updateStudent(Student std);

		public String deleteStudent(Integer sid);
		
		public Student selectQuery(Integer sid);
}
