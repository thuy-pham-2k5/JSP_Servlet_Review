package com.example.jsp_servlet_review.no_2;

import java.sql.*;
import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {
    @Override
    public List<ProductType> getAllProduct (ProductType productType) {
        String query = "select * from products join types on products.id_type = types.id_type order by products.id_product";
        List<ProductType> productTypes = null;
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productTypes.add(new ProductType(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(7)));
            }
            return productTypes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductType> getAllType(ProductType productType) {
       List<ProductType> productTypes = null;
       String query = "select * from types";
       try {
           Connection connection = ConnectDatabase.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               productTypes.add(new ProductType(resultSet.getInt(1), resultSet.getString(2)));
           }
           return productTypes;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public ProductType getProductTypeById(int id_product) {
        String query = "select * from products join types on products.id_type = types.id_type where products.id_product = ?";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id_product);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new ProductType(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(7));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewProductType(String name, double price, int quantity, int id_type) {
        String query = "INSERT INTO products (name, price, quantity, id_type) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, id_type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductTypeWithId(int id_product) {
        String query = "delete from products where id_product = ?";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, id_product);
            pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateInfoProduct(int id_product, String name, double price, int quantity, int id_type) {
        String query = "update products set name = ?, price = ?, quantity = ?, id_type = ? where id_product = ?";
        try {
            Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, id_type);
            preparedStatement.setInt(5, id_product);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductType> searchProductByName(String keyword) {
        List<ProductType> productTypes = null;
        String query = "{call searchProductByName (?)}";
        try {
            Connection connection = ConnectDatabase.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, keyword);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                productTypes.add(new ProductType(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(7)));
            }
            return productTypes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
