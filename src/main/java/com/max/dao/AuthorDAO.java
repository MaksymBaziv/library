package com.max.dao;

import com.max.DBUtils;
import com.max.model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements BaseDAO<Author> {

    private static AuthorDAO authorDAO = null;
    private Connection connection = DBUtils.getConnection();

    public static AuthorDAO getInstance() {
        if (authorDAO == null)
            authorDAO = new AuthorDAO();

        return authorDAO;
    }

    @Override
    public long save(Author author) {
        String sql = "INSERT INTO author(firstName, lastName, about) values (?,?,?)";
        long id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getAbout());
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
    public void update(Author author) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Author findById(long id) {
        String sql = "SELECT * FROM author where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Author author = new Author();
            if (rs.next()) {
                author.setId(rs.getLong("id"));
                author.setFirstName(rs.getString("firstName"));
                author.setLastName(rs.getString("lastName"));
                author.setAbout(rs.getString("about"));
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM author");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String about = rs.getString("about");
                Author author = new Author(id, firstName, lastName, about);
                authors.add(author);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
}
