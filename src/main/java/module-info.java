module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;
    requires opencv;



    exports ku.cs;
    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
    exports ku.cs.controllers.old;
    opens ku.cs.controllers.old to javafx.fxml;
}
