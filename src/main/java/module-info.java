module com.beginsecure.blobfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.beginsecure.blobfx to javafx.fxml;
    exports com.beginsecure.blobfx;
}