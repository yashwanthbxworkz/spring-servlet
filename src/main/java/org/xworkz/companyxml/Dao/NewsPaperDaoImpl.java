package org.xworkz.companyxml.Dao;

import org.xworkz.companyxml.Dto.NewsPaperDto;

import java.sql.*;

public class NewsPaperDaoImpl implements NewspaperDao{
    @Override
    public void insertNewsPaperDetails(NewsPaperDto newsPaperDto) {

        String url="jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName="root";
        String password="Yashu8904126821";
        System.out.println("connection Establibed to database");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection= DriverManager.getConnection(url,userName,password);
            String query="INSERT INTO newspaper (id,paperName,noOfPages,language,price,editorName,date,noOfArticles)VALUES(?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,newsPaperDto.getId());
            preparedStatement.setString(2,newsPaperDto.getPaperName());
            preparedStatement.setInt(3,newsPaperDto.getNoOfPages());
            preparedStatement.setString(4,newsPaperDto.getLanguage());
            preparedStatement.setInt(5,newsPaperDto.getPrice());
            preparedStatement.setString(6,newsPaperDto.getEditorName());
            preparedStatement.setString(7,newsPaperDto.getDate());
            preparedStatement.setInt(8,newsPaperDto.getNoOfArticles());
            preparedStatement.execute();
            System.out.println("Insert Data !!!!!!!!!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String paperName, int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load And restored the url");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="Jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName="root";
        String password="Yashu8904126821";
        System.out.println("connection Established");
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            String query="UPDATE newspaper set paperName=? where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, paperName);
            preparedStatement.setInt(2, id);
            int  result= preparedStatement.executeUpdate();
            System.out.println(result + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load And restored the url");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName="root";
        String password="Yashu8904126821";
        System.out.println("connection Established to database");
        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            String query="delete from NEWSPAPER_DETAILS where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            boolean result= preparedStatement.execute();
            System.out.println(result+"Delete the data from database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void read(String paperName, int id) {
        String url="jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName="root";
        String password="Yashu8904126821";
        //scamenStand
        System.out.println("connection Established to the DataBase");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=  DriverManager.getConnection(url,userName,password);
            String query="SELECT * FROM newspaper WHERE paperName=? and id=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,paperName);
            preparedStatement.setInt(2,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println(resultSet.getString("paperName"));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("noOfPages"));
                System.out.println(resultSet.getString("language"));
                System.out.println(resultSet.getInt("price"));
                System.out.println(resultSet.getString("editorName"));
                System.out.println(resultSet.getString("date"));
                System.out.println(resultSet.getInt("noOfArticles"));
                System.out.println(resultSet + "Featch data into database using Prepared Statement!!!! ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void getAllNewsPaper() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load And restored the url");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName="root";
        String password="Yashu8904126821";
        //scamenStand
        System.out.println("connection Established to the DataBase");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=  DriverManager.getConnection(url,userName,password);
            String query="SELECT * FROM newspaper_details";
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("paperName"));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("noOfPages"));
                System.out.println(resultSet.getString("language"));
                System.out.println(resultSet.getInt("price"));
                System.out.println(resultSet.getString("editorName"));
                System.out.println(resultSet.getString("date"));
                System.out.println(resultSet.getInt("noOfArticles"));
                System.out.println(resultSet + "Featch data into database using Prepared Statement!!!! ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public NewsPaperDto getNewsPaperByDate(String date) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load And restored the url");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName="root";
        String password="Yashu8904126821";
        //scamenStand
        System.out.println("connection Established to the DataBase");
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=  DriverManager.getConnection(url,userName,password);
            String query="SELECT * FROM newspaper_details where date=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,date);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("paperName"));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("noOfPages"));
                System.out.println(resultSet.getString("language"));
                System.out.println(resultSet.getInt("price"));
                System.out.println(resultSet.getString("editorName"));
                System.out.println(resultSet.getString("date"));
                System.out.println(resultSet.getInt("noOfArticles"));
                System.out.println(resultSet + "Featch data into database using Prepared Statement!!!! ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public NewsPaperDto getNewsPaperByLanguage(String language) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load And restored the url");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "Jdbc:mysql://localhost:3306/newspapar_detailes";
        String userName = "root";
        String password = "Yashu8904126821";
        //scamenStand
        System.out.println("connection Established to the DataBase");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            String query = "SELECT * FROM newspaper_details where language=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, language);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("paperName"));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("noOfPages"));
                System.out.println(resultSet.getString("language"));
                System.out.println(resultSet.getInt("price"));
                System.out.println(resultSet.getString("editorName"));
                System.out.println(resultSet.getString("date"));
                System.out.println(resultSet.getInt("noOfArticles"));
                System.out.println(resultSet + "Featch data into database using Prepared Statement!!!! ");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

//            //String query="INSERT INTO NEWSPAPER_DETAILS (id,paperName,noOfPages,language,price,editorName,date,noOfArticles)VALUES(?,?,?,?,?,?,?,?)";

