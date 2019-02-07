/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lektion1;

import ancient_encryption.AtbashCipher;
import ancient_encryption.CeasarCipher;
import ancient_encryption.CipherInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author aalsc
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private RadioButton rbAtbash;
    @FXML
    private TextField txtFieldMessage;
    @FXML
    private RadioButton rbCaesar;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private Button btnEncrypt;
    @FXML
    private Button btnDecrypt;
    @FXML
    private TextField txtFieldEncrypt;
    @FXML
    private TextField txtFieldDecrypt;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    final ToggleGroup group = new ToggleGroup();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory( 0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
        rbAtbash.setToggleGroup(group);
        rbCaesar.setToggleGroup(group);
    }    

    @FXML
    private void handleEncryptionButtonAction(ActionEvent event) {
        if (group.getSelectedToggle()==rbAtbash) {
            txtFieldEncrypt.setText(new AtbashCipher().encrypt(txtFieldMessage.getText()));
        } else {
            txtFieldEncrypt.setText(new CeasarCipher(spinner.getValue()).encrypt(txtFieldMessage.getText()));
        }
    }

    @FXML
    private void handleDecryptionButtonAction(ActionEvent event) {
        if (group.getSelectedToggle()==rbAtbash) {
          txtFieldDecrypt.setText(new AtbashCipher().decrypt(txtFieldEncrypt.getText()));
        } else {
            txtFieldDecrypt.setText(new CeasarCipher(spinner.getValue()).decrypt(txtFieldEncrypt.getText()));
        }
    }
    
}
