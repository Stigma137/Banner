package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.Banner;

public class BannerController implements Initializable{

    @FXML
    private Tab tab1;
    @FXML
    private TextField path;
    @FXML
    private Label loadState;
    @FXML
    private TextField viewText;
    @FXML
    private Label timeViewers;
    @FXML
    private Label viewersState;
    @FXML
    private TextField participantsText;
    @FXML
    private Label timeParticipants;
    @FXML
    private Label participantsState;
    @FXML
    private ImageView avatar;
    @FXML
    private Label idLabel;
    @FXML
    private Label fnLabel;
    @FXML
    private Label lnLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label ipLabel;
    @FXML
    private Label counLabel;
    @FXML
    private Label birthLabel;
    @FXML
    private Tab tab2;
    @FXML
    private AnchorPane drawPane;
    @FXML
    private File data;
    private Banner banner;
    
    @FXML
    void explorate(ActionEvent event) {

        FileChooser fC = new FileChooser();
        fC.setTitle("Choose File Source");
        fC.setInitialDirectory(new File("sources"));
        data =  fC.showOpenDialog(null);
        if (data != null) {
        	path.setText(data.getPath());
        }
        
    }

    @FXML
    void load(ActionEvent event) {
    	if (data != null) {
    	try {
			banner.loadThree(data);
			loadState.setText("Data was load sucessfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	}
    }

    @FXML
    void participantsDraw(ActionEvent event) {

    }

    @FXML
    void searchParticipants(ActionEvent event) {

    }

    @FXML
    void searchViewers(ActionEvent event) throws Exception{
    	if (loadState.getText().equals("Data was load sucessfully") && banner.searchViewer(viewText.getText()) != null){
    	long start = System.currentTimeMillis();
    	idLabel.setText(banner.searchViewer(viewText.getText()).getId());
    	fnLabel.setText(banner.searchViewer(viewText.getText()).getFirstName());
    	lnLabel.setText(banner.searchViewer(viewText.getText()).getLastName());
    	emailLabel.setText(banner.searchViewer(viewText.getText()).getEmail());
    	genderLabel.setText(banner.searchViewer(viewText.getText()).getGender());
    	ipLabel.setText(banner.searchViewer(viewText.getText()).getIp());
    	counLabel.setText(banner.searchViewer(viewText.getText()).getCountry());
    	birthLabel.setText(banner.searchViewer(viewText.getText()).getBirthday());
    	
    	URL uri = new URL(banner.searchViewer(viewText.getText()).getAvatar());
    	Image a = new Image(uri.toURI().toString());
    	avatar.setImage(a);
    	viewersState.setText("Viewer with " + viewText.getText() + " id can be found");
    	long end = System.currentTimeMillis();
    	double time = (double)(end - start)/1000;
    	timeViewers.setText(time + "s");
    	} else if (banner.searchViewer(viewText.getText()) == null){
    		viewersState.setText("Viewer with " + viewText.getText() + " id couldn't be found");
    	} else {
    		throw new Exception("Data have not load yet!");
    	}
    }

    @FXML
    void viewersDraw(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadState.setText("There is not load data in the system");
		banner = new Banner();
	}

}

