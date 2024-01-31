module com.begin.blobfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.begin.blobfx to javafx.fxml;
    exports com.begin.blobfx;
}