//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import springmvc.Connection1;
//import springmvc.StudentData;
//import springmvc.StudentService;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//class StudentServiceTest {
//    @InjectMocks
//    private StudentService studentService;
//
//    @Mock
//    private Connection connection;
//
//    @Mock
//    private ResultSet resultSet;
//
//    @Mock
//    private PreparedStatement preparedStatement;
//
//    @Mock
//    private Connection1 connection1;
//
//    StudentData studentData;
//
//    @BeforeEach
//    public void Setup() throws SQLException, ClassNotFoundException {
//        MockitoAnnotations.openMocks(this);
//        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
//        when(connection1.connect()).thenReturn(connection);
//        studentData=new StudentData("1","Rahul",4.09);
//    }
//
//    @Test
//    void update() throws SQLException, ClassNotFoundException {
//        when(connection.prepareStatement("INSERT INTO studentrecord VALUES ( ?, ? ,?)")).thenReturn(preparedStatement);
//        studentService.update(studentData);
//        verify(preparedStatement).executeUpdate(); //verify checks if a method is ran
//
//    }
//
//    @Test
//    void edit() throws SQLException, ClassNotFoundException {
//        when(resultSet.next()).thenReturn(true).thenReturn(false);
//        when(resultSet.getString("snumber")).thenReturn("1");
//        when(resultSet.getString("sname")).thenReturn("Rahul");
//        when(resultSet.getDouble("gpa")).thenReturn(4.09);
//        when(resultSet.first()).thenReturn(true);
//        when(preparedStatement.executeQuery()).thenReturn(resultSet);
//
//        studentData=new StudentData("1","Rahul",4.09);
//        StudentData sdata=studentService.edit(studentData,"1");
//        assertEquals("Rahul Sahani",sdata.getSname());
//    }
//
//    @Test
//    void delete() throws SQLException {
//        when(connection.prepareStatement("Delete from StudentData where catcode = ?")).thenReturn(preparedStatement);
//        studentService.delete("1");
//        verify(preparedStatement).executeUpdate();
//
//    }
//
//    @Test
//    void display() throws SQLException, ClassNotFoundException {
//        when(resultSet.next()).thenReturn(true).thenReturn(false);
//        when(resultSet.getString("snumber")).thenReturn("1");
//        when(resultSet.getString("sname")).thenReturn("Rahul");
//        when(resultSet.getDouble("gpa")).thenReturn(4.09);
//        when(resultSet.first()).thenReturn(true);
//
//        doReturn(resultSet).when(preparedStatement).executeQuery();
//        studentService.display();
//        verify(preparedStatement).executeQuery();
//
//    }
//}