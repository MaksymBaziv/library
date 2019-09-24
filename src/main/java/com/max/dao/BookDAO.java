package com.max.dao;

import com.max.DBUtils;
import com.max.ImageUtils;
import com.max.model.Book;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements BaseDAO<Book> {

    private static BookDAO bookDAO = null;
    private Connection connection = DBUtils.getConnection();

    public static BookDAO getInstance() {
        if (bookDAO == null)
            bookDAO = new BookDAO();

        return bookDAO;
    }

    @Override
    public long save(Book book) {
        String sql = "INSERT INTO book(name, pages, year_of_publication, price, description, image, author_id, publisher_id, created_by) " +
                "values (?,?,?,?,?,?,?,?,?)";
        long id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            InputStream image = book.getImage();
            ps.setString(1, book.getName());
            ps.setInt(2, book.getPages());
            ps.setInt(3, book.getYearOfPublication());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getDescription());
            ps.setBinaryStream(6, image);
            ps.setLong(7, book.getAuthorId());
            ps.setLong(8, book.getPublisherId());
            ps.setLong(9, book.getCreatedBy());
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next())
                    id = rs.getLong(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(Book book) {
        try {
            String sql = "UPDATE book SET name = ?, pages = ?, price = ?,year_of_publication = ?, description = ?, " +
                    "image = ?, author_id = ?, publisher_id = ? WHERE id = ?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setInt(2, book.getPages());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getYearOfPublication());
            ps.setString(5, book.getDescription());
            InputStream image = book.getImage();
            if (image == null) {
                Book bookById = findById(book.getId());
                image = bookById.getImage();
            }
            ps.setBinaryStream(6, image);
            ps.setLong(7, book.getAuthorId());
            ps.setLong(8, book.getPublisherId());
            ps.setLong(9, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE from book where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book findById(long id) {
        String sql = "SELECT * FROM book where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Book book = new Book();
            if (rs.next()) {
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setPages(rs.getInt("pages"));
                book.setPrice(rs.getDouble("price"));
                book.setYearOfPublication(rs.getInt("year_of_publication"));
                book.setDescription(rs.getString("description"));
                book.setImage(rs.getBinaryStream("image"));
                book.setImageBase64(ImageUtils.getBase64(rs.getBinaryStream("image")));
                book.setAuthorId(rs.getLong("author_id"));
                book.setPublisherId(rs.getLong("publisher_id"));
                book.setCreatedBy(rs.getLong("created_by"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM book");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setPages(rs.getInt("pages"));
                book.setPrice(rs.getDouble("price"));
                book.setYearOfPublication(rs.getInt("year_of_publication"));
                book.setDescription(rs.getString("description"));
                book.setImageBase64(ImageUtils.getBase64(rs.getBinaryStream("image")));
                book.setCreatedBy(rs.getLong("created_by"));
                books.add(book);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}