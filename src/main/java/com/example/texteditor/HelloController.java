package com.example.texteditor;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloController {

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnLock;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblDisplay;

    @FXML
    private TextArea txtEditor;

    FileChooser dialogbox = new FileChooser();


    @FXML
    void getCharacters(KeyEvent event) {
        //CHARACTERS TYPED
        lblDisplay.setText("Characters typed: "+txtEditor.getText().length());

    }

    @FXML
    void onEdit(ActionEvent event) {
        txtEditor.setEditable(true);

    }

    @FXML
    void onExit(ActionEvent event) {
        //CLOSE APPLICATION
        Platform.exit();
    }

    @FXML
    void onLock(ActionEvent event) {
        txtEditor.setEditable(false);

    }

    @FXML
    void onOpen(ActionEvent event) throws FileNotFoundException {
        //ADD FILTERS TO SHOW ONLY TEXT FILES
        dialogbox.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));

        File selectedFile = dialogbox.showOpenDialog(new Stage());
        //CHECK HAS USER SELECTED A FILE?
        if (selectedFile==null){
            //Do nothing
        }else{
            txtEditor.setText("");
            Scanner input = new Scanner(selectedFile);
            while(input.hasNextLine()){
                txtEditor.appendText(input.nextLine()+"\n");
            }

            input.close();

        }
        lblDisplay.setText("Characters typed"+txtEditor.getText().length());



    }

    @FXML
    void onSave(ActionEvent event) {

    }

}
