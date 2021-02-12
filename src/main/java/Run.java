import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import assistant.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Run extends Application {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static Stage stage;
    private Scene homeScene, skillScene;
    private StackPane root;
    private Label greeting, warning;
    private Button ask, back, addSkill;
    private TextField inputText;
    private ObservableList<String> outputList;
    private ListView<String> outputAnswer;
    private GridPane homePane;
    private VBox left , right;
    private ImageView icon;
    private ChoiceBox chooseSkill;



    /**
     * Basic test example to check that the gradle client works and can run JavaFX
     */
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        setPrimaryStage(primaryStage);
        stage = primaryStage;
        root = new StackPane();
        homePane = new GridPane();
        setupElements();
        events();

        //TODO: skillTemplate class to build/add new templates instead of having a scene builder in this class as well.
        SkillTemplates skills = new SkillTemplates(back);
        skillScene = skills.getScene();

        homeScene = new Scene(root, WIDTH, HEIGHT);
        homeScene.getStylesheets().add("css/HomeScene.css");

        primaryStage.setTitle("Multi Modal Digital Assisstant");
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setScene(homeScene);
        primaryStage.show();
    }

    private void setupElements() throws FileNotFoundException {
        greeting = new Label("Hi I'm Alexa but better.");
        warning = new Label("I might still spy on you though");
        ask = new Button("Ask");
        back = new Button("Back");
        addSkill = new Button("Add new skill");
        inputText = new TextField();
        outputList = FXCollections.observableArrayList(
                " ");
        outputAnswer = new ListView<String>(outputList);
        Image image = new Image(new FileInputStream("src/main/res/images/marvin.png"));
        icon = new ImageView(image);
        icon.setFitWidth(350);
        icon.setFitHeight(350);
        chooseSkill = new ChoiceBox();
        chooseSkill.getItems().addAll("Alarm", "Calendar", "Leisure");
        chooseSkill.getStyleClass().add("choice-box");

        left = new VBox();
        right = new VBox();

        left.getChildren().addAll(icon, greeting, chooseSkill, addSkill);
        left.setAlignment(Pos.CENTER);
        left.getStyleClass().add("vbox");

        right.getChildren().addAll(outputAnswer, inputText, ask);
        right.setAlignment(Pos.CENTER);
        right.getStyleClass().add("vbox");

        homePane.getStyleClass().add("grid");

        homePane.add(left, 0, 0);
        homePane.add(right, 1, 0);
        homePane.setPadding(new Insets(100, 0, 0, 75));
        homePane.setVgap(15);
        homePane.setPrefHeight(30);

        root.getChildren().addAll(homePane);




    }


    private void events(){
        // Get reply in the Answer box.
        ask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String question = inputText.getText();
                Assistant assistant = new Assistant();
                String answer = assistant.listen(question);
                outputList.addAll("Here we show your answer.");
                outputList.add(answer);
                outputAnswer.setItems(outputList);
            }
        });

        // Add new Skill
        addSkill.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(skillScene);
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homeScene);
            }
        });





    }

    //Setters and getters for the primaryStage.
    public static Stage getPrimaryStage(){
        return stage;
    }

    private void setPrimaryStage(Stage tempStage){
        this.stage = tempStage;
    }

}
