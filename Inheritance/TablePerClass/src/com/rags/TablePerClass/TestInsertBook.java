package com.rags.TablePerClass;

public class TestInsertBook {
	public static void main(String arg[])
	{
		try
		{
		BookDao m=new BookDao();
		
		Book bk=new Book();
		bk.setAuthor("raman");
		bk.setCost(60);
		bk.setTitle("mysql");
		
		
		InternationalBook ib=new InternationalBook();
		ib.setAuthor("Candid");
		ib.setCost(70);
		ib.setTitle("mysql");
		ib.setLanguages("english");
		ib.setRegion(12);
		
		SpecialEditionBook sb=new SpecialEditionBook();
		sb.setAuthor("surendar");
		sb.setCost(90);
		sb.setTitle("j2ee");
		sb.setNewfeatures("angular");
		
		m.insertBook(bk);
		m.insertBook(ib);
		m.insertBook(sb);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
