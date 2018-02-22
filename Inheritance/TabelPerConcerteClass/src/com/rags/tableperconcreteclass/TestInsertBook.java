package com.rags.tableperconcreteclass;

public class TestInsertBook {
	public static void main(String arg[])
	{
		try
		{
		BookDao m=new BookDao();
		
		Book bk=new Book();
		bk.setAuthor("sivaraman");
		bk.setCost(760);
		bk.setTitle("oracle");
		
		
		InternationalBook ib=new InternationalBook();
		ib.setAuthor("sivaraman");
		ib.setCost(960);
		ib.setTitle("oracle");
		ib.setLanguages("tamil");
		ib.setRegion(12);
		
		SpecialEditionBook sb=new SpecialEditionBook();
		sb.setAuthor("surendar");
		sb.setCost(550);
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
