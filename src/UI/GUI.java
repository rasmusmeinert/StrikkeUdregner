package UI;

import Model.Garn;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    //==Vars==
    TextField txfOriginaltGarnLøbelængde = new TextField();
    TextField txfOriginaltGarnGram = new TextField();
    TextField txfAlternativtGarnLøbelængde = new TextField();
    TextField txfAlternativtGarnGram = new TextField();
    TextField txfSamletOpskriftGram = new TextField();
    TextField txfAlternativtGarnUdregnetGram = new TextField();
    TextField txfAlternativtGarnUdregnetNøgle = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("StrikkeUdregner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void initContent(GridPane pane) {
        double maxWidthTxf = 100;
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        Label lblOriginalLøbelængde = new Label("Originalt Garn Løbelængde:");
        pane.add(lblOriginalLøbelængde,0,0);
        pane.add(txfOriginaltGarnLøbelængde,1,0);

        txfOriginaltGarnLøbelængde.setMaxWidth(maxWidthTxf);


        Label lblOriginalPer = new Label("per");
        Label lblOriginalGram = new Label("gram");
        pane.add(lblOriginalPer,2,0);
        pane.add(txfOriginaltGarnGram,3,0);
        pane.add(lblOriginalGram,4,0);

        txfOriginaltGarnGram.setMaxWidth(maxWidthTxf);

        Label lblSamletGramOpkrift = new Label("Total Gram i Opskrift:");
        pane.add(lblSamletGramOpkrift,0,1);
        pane.add(txfSamletOpskriftGram,1,1);

        txfSamletOpskriftGram.setMaxWidth(maxWidthTxf);

        Label lblAlternativLøbelængde = new Label("Alternativt Garn Løbelængde:");
        pane.add(lblAlternativLøbelængde,0,2);
        pane.add(txfAlternativtGarnLøbelængde,1,2);

        txfAlternativtGarnLøbelængde.setMaxWidth(maxWidthTxf);


        Label lblAlternativPer = new Label("per");
        Label lblAlternativGram = new Label("gram");
        pane.add(lblAlternativPer,2,2);
        pane.add(txfAlternativtGarnGram,3,2);
        pane.add(lblAlternativGram,4,2);

        txfAlternativtGarnGram.setMaxWidth(maxWidthTxf);

        Button btnUdregn = new Button("Udregn");
        btnUdregn.setDefaultButton(true);
        btnUdregn.setOnAction(e -> udregn());
        pane.add(btnUdregn,1,3);


        Label lblResult = new Label("Du skal bruge:");
        Label lblGram = new Label("gram");
        Label lblNøgler = new Label("nøgler");
        pane.add(lblResult,0,4);
        pane.add(txfAlternativtGarnUdregnetGram,1,4);
        pane.add(lblGram,2,4);
        pane.add(txfAlternativtGarnUdregnetNøgle,3,4);
        pane.add(lblNøgler,4,4);
        txfAlternativtGarnUdregnetGram.setFocusTraversable(false);
        txfAlternativtGarnUdregnetGram.setEditable(false);
        txfAlternativtGarnUdregnetGram.setMaxWidth(maxWidthTxf);

        txfAlternativtGarnUdregnetNøgle.setFocusTraversable(false);
        txfAlternativtGarnUdregnetNøgle.setEditable(false);
        txfAlternativtGarnUdregnetNøgle.setMaxWidth(maxWidthTxf);

    }

    public void udregn(){
        try{
            double garn1Loeb = Double.parseDouble(txfOriginaltGarnLøbelængde.getText());
            double garn1Gram = Double.parseDouble(txfOriginaltGarnGram.getText());
            Garn garn1 = new Garn(garn1Loeb, garn1Gram);
            double garn2Loeb = Double.parseDouble(txfAlternativtGarnLøbelængde.getText());
            double garn2Gram = Double.parseDouble(txfAlternativtGarnGram.getText());
            Garn garn2 = new Garn(garn2Loeb, garn2Gram);
            double gram = Double.parseDouble(txfSamletOpskriftGram.getText());
            txfAlternativtGarnUdregnetGram.setText(String.format("%.2f",udregnGram(garn1,garn2, gram)));
            txfAlternativtGarnUdregnetNøgle.setText(String.format("%.2f",udregnNøgle(garn1,garn2,gram)));
        } catch (NumberFormatException e){

        }


    }
    public double udregnGram(Garn garn1, Garn garn2, double gram){
        return udregnNøgle(garn1,garn2,gram) * garn2.getGram();
    }

    public double udregnNøgle(Garn garn1, Garn garn2, double gram){
        double nøgler = gram/garn1.getGram(); //antal nøgler
        double samledeLøbelængde = nøgler * garn1.getLøbelængde(); //udregner den totale løbelængde

        return samledeLøbelængde / garn2.getLøbelængde();// udregner antal nøgler;
    }
}
