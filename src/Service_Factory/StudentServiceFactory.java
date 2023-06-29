package Service_Factory;
import Service.IStudentService;
import Service.StudentServiceImpl;

public class StudentServiceFactory {
   private StudentServiceFactory() {}
   
   private static IStudentService studentService = null;
   
   public static IStudentService getStudentService() {
	   if(studentService == null) {
		   studentService = new StudentServiceImpl();
	   }
	   return studentService;
   }
}
