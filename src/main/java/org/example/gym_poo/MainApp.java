package org.example.gym_poo;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import org.example.gym_poo.models.Cliente;
import org.example.gym_poo.models.Gym;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        Gym.getClientes().add(
                new Cliente(1, "Diego", "8123", "correo", "plus", 20)
        );

        Cliente cliente = Gym.getClientes().get(0);

        System.out.println(cliente.getNombre());


        Group root = new Group();
        Scene scene = new Scene(root, 800, 600 ,Color.BEIGE);

        Image icon = new Image("omori1.jpeg");
        stage.getIcons().add(icon);
        stage.setTitle("Stage demo Diego");

        Text text = new Text();
        text.setText("hola");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Times New Roman"));
        text.setFont(Font.font(50));

        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}