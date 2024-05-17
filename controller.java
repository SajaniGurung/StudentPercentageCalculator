package com.example.studentpercentagecalculator;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {  // Controller class and initializer superclass for tableview
    // FXML annotations to inject UI components
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField obtmarks;

    @FXML
    private TextField totalmarks;

    @FXML
    private Label throwException;
    @FXML
    public TableView<student> tableview;   // Tableview for displaying data
    // table columns
    @FXML
    private TableColumn<student, String> FullName;

    @FXML
    private TableColumn<student, Float> ObtainedMarks;

    @FXML
    private TableColumn<student, Float> TotalMarks;

    @FXML
    private TableColumn<student, Float> Percentage;
    // Method to calculate percentage with obtained and total marks
    @FXML
    public String PercentageCalculator(){
        float calculated = Float.parseFloat(obtmarks.getText());
        float total = Float.parseFloat(totalmarks.getText());
        float avg = (calculated/total) * 100.0f;
        return String.format("%.2f%%",avg);
    }
    // Event handler for the "Add student" button
    @FXML
    public void UserInput(ActionEvent event) throws IOException {
        throwException.setText("");
        // check if student marks are valid
    if (Float.parseFloat(obtmarks.getText())<= 500.0f && Float.parseFloat(obtmarks.getText()) >= 0.0f){
        // Check if obtained marks are valid
            student Student = new student(String.format("%s %s",firstname.getText(),lastname.getText()),
                    Float.parseFloat(obtmarks.getText()),
                    Float.parseFloat(totalmarks.getText()),
                    PercentageCalculator());

            //to create observable list
            ObservableList<student> students = tableview.getItems();;
            students.add(Student);
            tableview.setItems(students);}


        else{
            throwException.setText("Your data is invalid.");
            throw new IOException("Input must be at 0-500.");
        }
    }
    // Event handler to remove a selected student
    @FXML
    void removestudent(ActionEvent event) {
        int selected = tableview.getSelectionModel().getSelectedIndex();

        // Check if an item is actually selected
        if (selected >= 0) {
            tableview.getItems().remove(selected);
        } else {
            // Optionally, provide feedback to the user if no item is selected
            throwException.setText("No student selected for removal.");
        }
    }
    // Initialization method called by JavaFX during the controller's initialization
    @Override
    // Set cell value factories for each table column
    public void initialize(URL url, ResourceBundle resourceBundle){
        FullName.setCellValueFactory(new PropertyValueFactory<>("FullName"));
        ObtainedMarks.setCellValueFactory(new PropertyValueFactory<>("ObtainedMarks"));
        TotalMarks.setCellValueFactory(new PropertyValueFactory<>("TotalMarks"));
        Percentage.setCellValueFactory(new PropertyValueFactory<>("Percentage"));
        }

    }


