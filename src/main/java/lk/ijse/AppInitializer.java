package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RoomBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.DAOTypes;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class AppInitializer extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        createDemoUser();
        demoImport();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/Login.fxml")));
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void createDemoUser() {

        QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOTypes.QUERY_DAO);

        Session session = FactoryConfiguration.getInstance().getSession();
        queryDAO.getAllUnpaid(session);

        UserBO user = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);
        List<UserDTO> all = user.getAll();

        if (all.isEmpty()) {
            user.save(new UserDTO(1, "admin", "1234"));
        }

    }

    private void demoImport() {
        RoomBO rooms = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
        StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
        List<RoomDTO> allRooms = rooms.getAll();
        List<StudentDTO> allStudents = studentBO.getAll();


        if (allRooms.isEmpty()) {
            rooms.save(new RoomDTO("RM-1324", "Non-AC", 3100, 35));
            rooms.save(new RoomDTO("RM-5467", "Non-AC/Food", 6500, 20));
            rooms.save(new RoomDTO("RM-7896", "AC", 8900, 14));
            rooms.save(new RoomDTO("RM-0093", "AC/Food", 16000, 10));

        }

        if (allStudents.isEmpty()) {
            studentBO.save(new StudentDTO("IJSE-13432", "Saman", "Badulla", "0715813240", LocalDate.parse("2002-05-06"), "Male"));
            studentBO.save(new StudentDTO("SLIIT-34234", "Thejani", "Panadura", "0709713240", LocalDate.parse("2004-01-20"), "Female"));
            studentBO.save(new StudentDTO("NSBM-98736", "Kamal", "Galle", "0712313240", LocalDate.parse("2004-03-19"), "Male"));
            studentBO.save(new StudentDTO("NIBM-57380", "Windy", "Colombo", "0755963240", LocalDate.parse("2001-10-09"), "Female"));

        }
    }
}
