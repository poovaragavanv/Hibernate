package xml;

public class TestInsertStudent {
	public static void main(String arg[]) 
	{
		try 
		{
			StudentDao m = new StudentDao();
			
			Student s=new Student();
			
			s.setStudentName("vasuu");
	 
			Address ad = new Address();
			
			ad.setStreet("rajasozhan");
			ad.setCity("chennai");
			ad.setState("tamilnadu");
			ad.setZipcode("333333");
            s.setAddress(ad);	 
			
			m.insertStudent(s);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
