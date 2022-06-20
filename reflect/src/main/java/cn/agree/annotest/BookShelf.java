package cn.agree.annotest;


import cn.agree.annotation.Book;

/*
*
*
*
* */
@Book(value = "红楼梦", authors = "曹雪芹", price = 998)
public class BookShelf {

    @Book(value = "西游记", price = 889, authors = {"吴承恩", "白求恩"})
    public void showBook() {

    }
}


