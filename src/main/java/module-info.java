module ru.mail.megatable {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires lombok;

    opens ru.mail.megatable to javafx.fxml;
    exports ru.mail.megatable;
    opens ru.mail.megatable.models to javafx.base;
    exports ru.mail.megatable.controllers;
    opens ru.mail.megatable.controllers to javafx.fxml;
}