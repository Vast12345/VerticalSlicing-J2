package com.repasojava.Pais.infrastructure.repository;

import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;
import java.util.Properties;
import java.sql.*;

public class PaisRepository implements PaisService{
    private Connection connection;

    public PaisRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void createPais(Pais pais) {
        String sql = "Insert into pais (descripcion) values (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, 
                        PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pais.getName());
            statement.executeUpdate();

            try(ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pais.setId(generatedKeys.getInt(1));
                }
            }
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findPaisById(Long id) {
        String sql = "select * from pais where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
