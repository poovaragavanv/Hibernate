package xml;

public class TestGetStudent {
	public static void main(String arg[])
	{  
		StudentDao ms=new StudentDao();
		
		Student sas=ms.getStudent(1);
		Address sd=sas.getStudentAddress();
		System.out.println(sas.getStudentName());
		System.out.println(sd.getCity());
		System.out.println(sd.getState());
		System.out.println(sd.getStreet());
		System.out.println(sd.getZipcode());
	}		

}
