module br.com.pedro.converter {
    requires javafx.controls;
    requires javafx.fxml;
    requires fontawesomefx;

    opens br.com.pedro.converter to javafx.fxml;
    exports br.com.pedro.converter;
    exports br.com.pedro.converter.controller;
    opens br.com.pedro.converter.controller to javafx.fxml;
}