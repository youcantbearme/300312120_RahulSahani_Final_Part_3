package springmvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentService implements StudentInterface{

    public Connection con3;
    public Connection getCon3() {
        return con3;
    }

    public void setCon3(Connection con3) {
        this.con3 = con3;
    }

    public StudentService(Connection con3) throws SQLException{
        this.con3 = con3;
    }

    public StudentService() throws SQLException{
    }

    @Override
    public void update(StudentData studentData) throws ClassNotFoundException, SQLException {

        String quer1 = "INSERT INTO student VALUES ( ?, ? ,?)";
        PreparedStatement query = con3.prepareStatement(quer1);
        query.setString(1, studentData.getSnumber());
        query.setString(2, studentData.getSname());
        query.setDouble(3, studentData.getGpa());

        query.executeUpdate();
        System.out.println("One record added");
    }
    public StudentData search(String snumber) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from student where snumber = ?";
        PreparedStatement query = con3.prepareStatement(quer1);
        query.setString(1, snumber);
        ResultSet rs = query.executeQuery();

        if(!rs.first()){

            System.out.println("Record not existing");
            return null;
        }
        StudentData obj1=null;
        obj1 = new StudentData(rs.getString("snumber"), rs.getString("sname"), rs.getDouble("gpa"));
        return obj1;
    }

    @Override
    public StudentData edit(StudentData studentData, String snumber) throws SQLException, ClassNotFoundException {

        PreparedStatement query;
        query = con3.prepareStatement("Update student set snumber=?, sname=?, gpa=? where snumber = ?");
        query.setString(1, studentData.getSnumber());
        query.setString(2, studentData.getSname());
        query.setDouble(3, studentData.getGpa());
        query.executeUpdate();
        System.out.println("One record edited");
        return studentData;
    }

    @Override
    public void delete(String snumber) throws SQLException {

        String quer1 = "Delete from student where snumber = ?";
        PreparedStatement query = con3.prepareStatement(quer1);
        query.setString(1, snumber);
        query.executeUpdate();

        System.out.println("One record Deleted");
    }


    public void makeDB() throws ClassNotFoundException, SQLException {
        String quer1 = "CREATE DATABASE inventory";
        PreparedStatement query = con3.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        StudentData obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new StudentData(rs.getString("snumber"), rs.getString("sname"), rs.getDouble("gpa"));
            System.out.println();
            System.out.print("Student code: " + obj1.getSnumber() + "  ");
            System.out.print("Student Description " + obj1.getSname()+ "  ");
            System.out.print("Student GPA " + obj1.getGpa());
        }
    }

    public void display() throws ClassNotFoundException, SQLException {
        String quer1 = "Select * from student";
        PreparedStatement query = con3.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        StudentData obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new StudentData(rs.getString("snumber"),rs.getString("sname"),rs.getDouble("gpa"));
            System.out.println();
            System.out.print("Student Number: " + obj1.getSnumber() + "  ");
            System.out.print("Student Name " + obj1.getSname()+ "  ");
            System.out.print("Student GPA " + obj1.getGpa());
        }
    }
}


