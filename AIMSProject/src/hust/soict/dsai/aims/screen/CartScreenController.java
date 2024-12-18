package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;

@SuppressWarnings("unused")
public class CartScreenController {
    private Cart cart;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Gán giá trị cho từng cột
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Ẩn các nút ban đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Tạo ObservableList và FilteredList
        ObservableList<Media> mediaList = FXCollections.observableArrayList(cart.getItemsOrdered());
        FilteredList<Media> filteredList = new FilteredList<>(mediaList);
        tblMedia.setItems(filteredList);

        updateTotalCost();

        // Listener cho TableView selection
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                updateButtonBar(newValue);
        });
        // Listener cho bộ lọc TextField
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(media -> {
                if (newValue == null || newValue.isEmpty())
                    return true;
                String lowerCaseFilter = newValue.toLowerCase();
                if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(lowerCaseFilter);
                } else if (radioBtnFilterTitle.isSelected()) {
                    return media.getTitle().toLowerCase().contains(lowerCaseFilter);
                }
                return false;
            });
        });
    }

    private void updateButtonBar(Media media) {
        // Hiển thị nút Remove
        btnRemove.setVisible(true);

        // Kiểm tra media có phải là Playable hay không
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        // Lấy mục được chọn từ TableView
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media != null) {
            // Xóa mục khỏi giỏ hàng
            cart.removeMedia(media);
            showAlert(Alert.AlertType.INFORMATION, "Remove Media", "Removed: " + media.getTitle());

            // Cập nhật lại ObservableList cho TableView
            ObservableList<Media> updatedList = FXCollections.observableArrayList(cart.getItemsOrdered());
            tblMedia.setItems(updatedList);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        System.out.println("Order placed succesfully");
        cart.getItemsOrdered().clear();
        tblMedia.getItems().clear();
        updateTotalCost();
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("Total: %.2f $", cart.totalCost()));
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            // Kiểm tra nếu mục được chọn là Playable
            if (media instanceof Playable) {
                String message = "Now playing: " + media.getTitle();
                showAlert(Alert.AlertType.INFORMATION, "Play Media", message);
                ((Playable) media).play();
            }
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}