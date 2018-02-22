package com.rags.tableperconcreteclass;

  public class Book {
    int id;
    String title; 
    String author;
   
    double cost;

    public Book() {
    }

    public Book(String title, String author,double cost) {
      this.title = title;
      this.author = author;
      
      this.cost = cost;
    }

    public void setId(int id) { 
      this.id = id;
    }

    public int getId(){ 
      return id;
    }

    public void setTitle(String title) { 
      this.title = title;
    }

    public String getTitle() { 
      return title;
    }

    public void setAuthor(String author) { 
       this.author = author;
    }

    public String getAuthor() { 
      return author;
    }

    
    public void setCost(double cost) { 
      this.cost = cost;
    }

    public double getCost() { 
      return cost;
    }
  }