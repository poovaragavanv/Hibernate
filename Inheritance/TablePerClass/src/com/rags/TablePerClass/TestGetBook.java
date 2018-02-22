package com.rags.TablePerClass;
public class TestGetBook {
	public static void main(String arg[])
	{  
		BookDao ms=new BookDao();
		
		Book b=ms.getBook(2);
		
		System.out.println(b.getAuthor());
		System.out.println(b.getTitle());
		System.out.println(b.getCost());
		
		if(b instanceof InternationalBook)
		{
			InternationalBook ib=(InternationalBook) b;
			System.out.println(ib.getLanguages());
			System.out.println(ib.getRegion());
		}
		if(b instanceof SpecialEditionBook)
		{
			SpecialEditionBook sb=(SpecialEditionBook) b;
			System.out.println(sb.getNewfeatures());
			
		}
				
	}

}
