import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Menus extends Application {
    // Set scenes
    private Stage primaryStage;
    private Scene mainMenuScene, menuTemplateScene;
    public Button exitToMain = new Button("Main Menu");

    // Members
    List<Flight> flights = new ArrayList<>(Arrays.asList(
            new Flight(
                    "IBS",
                    LocalDate.of(2023, 12, 22),
                    "Paris",
                    "Geneva",
                    21,
                    300.00),
            new Flight(
                    "ABC",
                    LocalDate.of(2023, 12, 22),
                    "Toronto",
                    "Heathrow",
                    200,
                    1400.0)
    ));
    List<Passenger> passengers = new ArrayList<>(Arrays.asList(
            new Passenger("ABC!@#", "Nicole", "M", 22),
            new Passenger("ABC123", "Ty", "P", 23)
    ));
    ArrayList<Reservation> reservations = new ArrayList<>(Arrays.asList(
            new Reservation(
                    "ABC",
                    "Toronto",
                    "Heathrow",
                    LocalDate.of(2023, 12, 22),
                    "ABC!@#",
                    "Nicole M",
                    22,
                    1400.00),
            new Reservation(
                    "ABC",
                    "Toronto",
                    "Heathrow",
                    LocalDate.of(2023, 12, 22),
                    "ABC123",
                    "Ty P",
                    23,
                    1400.00)
    ));


    // Main
    public static void main(String[] args) {
        launch(args);
    }

    //Start / Main Menu
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        exitToMain.setOnAction      (e -> primaryStage.setScene(mainMenuScene));
        exitToMain.setMinSize       (80, 30);

        // Main Menu Scene
        mainMenu();

        primaryStage.setScene(mainMenuScene);
        primaryStage.setTitle("Travel Reservation System");
        primaryStage.show();

    }

    // Main Menu
    public void mainMenu(){

        //Members
        Label title = new Label("Main Menu");
        title.setStyle("-fx-font-size: 26;");
        Button flightMenu       = new Button("Flight Menu");
        flightMenu.setOnAction      (e -> menuTemplate("Flight"));
        Button passengerMenu     = new Button("Passenger Menu");
        passengerMenu.setOnAction    (e -> menuTemplate("Passenger"));
        Button reservationMenu  = new Button("Reservation Menu");
        reservationMenu.setOnAction (e -> menuTemplate("Reservation"));
        Button mainExitButton   = new Button("Exit");
        mainExitButton.setOnAction  (e -> primaryStage.close());

        // Main Menu Layout
        VBox mainMenuLayout = new VBox(10);
        mainMenuLayout.getChildren().addAll(title, flightMenu, passengerMenu, reservationMenu, mainExitButton);
        mainMenuLayout.setStyle     ("-fx-alignment: center;");
        flightMenu.setMinSize       (140, 30);
        passengerMenu.setMinSize    (140, 30);
        reservationMenu.setMinSize  (140, 30);
        mainExitButton.setMinSize   (80, 30);

        mainMenuScene = new Scene(mainMenuLayout, 500, 450);
    }



    private void menuTemplate(String type){
        Label title = new Label();
        title.setText(type + " Menu");
        title.setStyle("-fx-font-size: 26;");
        Button button1       = new Button("Add " + type);
        button1.setOnAction      (e -> {
            if (type.equals("Reservation")) {
                primaryStage.setScene(Reservation.add(flights, passengers, reservations, primaryStage, menuTemplateScene));
            } else if (type.equals("Passenger")) {
                primaryStage.setScene(Passenger.add(passengers, primaryStage, menuTemplateScene));
            } else {
                primaryStage.setScene(Flight.add(flights, primaryStage, menuTemplateScene));
            }
        });
        Button button2     = new Button("Remove " + type);
        button2.setOnAction    (e -> {
            if (type.equals("Reservation"))
                primaryStage.setScene(Reservation.remove(reservations, primaryStage, menuTemplateScene));
            else if (type.equals("Passenger"))
                primaryStage.setScene(Passenger.remove(passengers, reservations, primaryStage, menuTemplateScene));
            else
                primaryStage.setScene(Flight.remove(flights, reservations, primaryStage, menuTemplateScene));
        });
        Button button3  = new Button("Display " + type);
        button3.setOnAction (e -> {
            if (type.equals("Reservation"))
                primaryStage.setScene(Reservation.display(reservations, primaryStage, menuTemplateScene));
            else if (type.equals("Passenger"))
                primaryStage.setScene(Passenger.display(passengers, primaryStage, menuTemplateScene));
            else
                primaryStage.setScene(Flight.display(flights, primaryStage, menuTemplateScene));
        });

        // Main Menu Layout
        VBox menuTemplateLayout = new VBox(10);
        menuTemplateLayout.getChildren().addAll(title, button1, button2, button3, exitToMain);
        menuTemplateLayout.setStyle     ("-fx-alignment: center;");
        button1.setMinSize       (140, 30);
        button2.setMinSize       (140, 30);
        button3.setMinSize       (140, 30);

        menuTemplateScene = new Scene(menuTemplateLayout, 500, 450);
        primaryStage.setScene(menuTemplateScene);
    }


}
