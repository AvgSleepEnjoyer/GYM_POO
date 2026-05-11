module org.example.gym_poo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.gym_poo to javafx.fxml;
    opens org.example.gym_poo.controllers to javafx.fxml;
    exports org.example.gym_poo;
}