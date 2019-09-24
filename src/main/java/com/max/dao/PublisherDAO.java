package com.max.dao;

import com.max.DBUtils;
import com.max.model.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDAO implements BaseDAO<Publisher> {

    private static PublisherDAO publisherDAO = null;
    private Connection connection = DBUtils.getConnection();

    public static PublisherDAO getInstance() {
        if (publisherDAO == null)
            publisherDAO = new PublisherDAO();

        return publisherDAO;
    }

    @Override
    public long save(Publisher publisher) {
        String sql = "INSERT INTO publisher(name, city, phoneNumber) values (?,?,?)";
        long id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, publisher.getName());
            ps.setString(2, publisher.getCity());
            ps.setString(3, publisher.getPhoneNumber());
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
    public void update(Publisher publisher) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Publisher findById(long id) {
        return null;
    }

    public List<Publisher> findAll() {
        List<Publisher> publishers = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM publisher");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                String phoneNumber = rs.getString("phoneNumber");
                Publisher publisher = new Publisher(id, name, city, phoneNumber);
                publishers.add(publisher);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }


}
