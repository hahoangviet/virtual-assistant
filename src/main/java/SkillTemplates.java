import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SkillTemplates extends Run{
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private AnchorPane pane;
    private Scene scene;
    private Button back;
    private TextField skillName, sampleQuestions, description, keywords;
    private Label nameLabel, questionsLabel, keywordsLabel, descriptionLabel;

    public SkillTemplates(Button backButton){
        this.back = backButton;
        builder();
        scene = new Scene(pane, WIDTH, HEIGHT);
    }

    private void builder(){
        pane = new AnchorPane();
        Label label = new Label("Skill Maker");
        skillName = new TextField();
        nameLabel = new Label("Name your skill:");
        sampleQuestions = new TextField();
        questionsLabel = new Label("Add some sample questions you can use your skill for:");
        description = new TextField();
        descriptionLabel = new Label("Description of your skill:");
        keywordsLabel = new Label("What are the keywords you can use to invoke your skill?");
        keywords = new TextField();
        VBox box = new VBox();
        box.getChildren().addAll(label, nameLabel, skillName, questionsLabel, sampleQuestions, descriptionLabel, description, keywordsLabel, keywords, back);
        pane.getChildren().addAll(box);
        pane.setLeftAnchor(box, 500.0);
        pane.setTopAnchor(box, 250.0);
        //pane.setRightAnchor(back, 100);



    }

    private void events(){

    }



    public Scene getScene(){
        return this.scene;
    }


}
