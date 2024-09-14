module lab1.todspclabv2 {
    requires javafx.fxml;
    requires javafx.controls;


    opens lab1.todspclabv2 to javafx.fxml;
    exports lab1.todspclabv2;
}