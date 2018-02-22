package xml;
import java.util.Iterator;
import java.util.Set;
public class TestGetStudent {
	public static void main(String arg[])
	{  
		StudentDao ms=new StudentDao();		
		Student st=ms.getStudents(3);
		Set<Course> sts=st.getCourses();
		System.out.println(st.getStudentName());

		Iterator<Course>co=sts.iterator();
		while(co.hasNext())
		{
			Course cr=(Course)co.next();
			System.out.println(cr.getCourseName());
		}	
				
	}

}
