package edu.debis.application.impl;

import edu.debis.application.ISBNService;
import edu.debis.dto.ISBN;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import lombok.NonNull;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class ISBNServiceJDBC implements ISBNService {

    @Inject
    @DataSource("default")
    AgroalDataSource ds;

    @Override
    public Collection<ISBN> getAll() {

        Collection<ISBN> isbnCollection = new ArrayList<ISBN>(10);
        try {
           ResultSet resultSet = ds.getConnection().prepareStatement("select code, area, publisher from ISBN").executeQuery();
           while (resultSet.next()) {
               ISBN isbn = new ISBN.Builder(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)).build();
               isbnCollection.add(isbn);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isbnCollection;
    }

    @Override
    public ISBN getDetails(@NonNull String code) {

        ISBN isbn;
        try {
            PreparedStatement statement = ds.getConnection().prepareStatement("select code, area, publisher from ISBN where code = ?");
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            resultSet.first();
            isbn = new ISBN.Builder(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isbn;
    }
}
