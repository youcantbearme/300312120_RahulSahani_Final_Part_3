package springmvc;

import java.sql.SQLException;

public interface StudentInterface {
    public void display() throws ClassNotFoundException, SQLException;
    public void update(StudentData studentData) throws ClassNotFoundException, SQLException;
    public void delete(String snumber) throws SQLException;
    public StudentData edit(StudentData studentData, String snumber) throws SQLException, ClassNotFoundException;
}
