package com.DAO;

import com.bean.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImplementaion implements BookDAO {
    //here we need to Create JDBCTemplate
    private JdbcTemplate jdbcTemplate;
    Book book;
    int updateID , newPrice,fetchBookID;
    static BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int insertBook() throws IOException {
        book = new Book();
        System.out.println("Enter BookID");book.setBookID(Integer.parseInt(reader.readLine()));
        System.out.println("Enter BookName");book.setBookName(reader.readLine());
        System.out.println("Enter Author name");book.setAuthorName(reader.readLine());
        System.out.println("Enter Price :");book.setPrice(Float.parseFloat(reader.readLine()));
        return (jdbcTemplate.update("INSERT INTO BOOK_DETAILS VALUES(?,?,?,?)",
               book.getBookID(),book.getBookName(),book.getAuthorName(),book.getPrice()));
    }

    @Override
    public int deleteBook() throws IOException {
        System.out.println("ENTER ID FOR DELETING RECORD : ");
        return (jdbcTemplate.update("DELETE FROM BOOK_DETAILS WHERE BOOK_ID = "
                +Integer.parseInt(reader.readLine())+" "));
    }

    @Override
    public int updateBook() throws IOException {
        System.out.println("ENTER ID FOR UPDATE : ");
         updateID = Integer.parseInt(reader.readLine());
        System.out.println("ENTER NEW BOOK PRICE :");
        newPrice = Integer.parseInt(reader.readLine());
       return (jdbcTemplate.update("UPDATE BOOK_DETAILS SET PRICE = ? WHERE BOOK_ID = ?"
               ,newPrice,updateID));
    }

    @Override
    public void fetchAll() {
        // here we are using .query(sql,new RowMapper<>(){
        //      mapRow(ResultSet result,int i){
        //
        //    }
        // });
          String query="SELECT * FROM BOOK_DETAILS";
          List<Book>bookList=jdbcTemplate.query(query, new RowMapper<Book>() {
              @Override
              public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                  book = new Book();
                  book.setBookID(resultSet.getInt(1));
                  book.setBookName(resultSet.getString(2));
                  book.setAuthorName(resultSet.getString(3));
                  book.setPrice(resultSet.getFloat(4));
                  return book;
              }
          })   ;
          for (Book item :bookList)
              System.out.println(item);

    }

    @Override
    public void fetchSpecificBook() throws IOException {
        System.out.println("ENTER BOOK ID FOR FETCH : ");
        String query= "SELECT * FROM BOOK_DETAILS WHERE BOOK_ID = ? ";

        book = jdbcTemplate.query(query,new ResultSetExtractor<Book>() {
            @Override
            public Book extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Book> list = new ArrayList<>();
                while(resultSet.next()){
                    book=new Book();
                    book.setBookID(resultSet.getInt(1));
                    book.setBookName(resultSet.getString(2));
                    book.setAuthorName(resultSet.getString(3));
                    book.setPrice(resultSet.getFloat(4));
                    list.add(book);
                }
                return book;
            }
            // always write parameter at last because it is args[] which must lie at last
        },Integer.parseInt(reader.readLine()));
        System.out.println(book);
    }
}
