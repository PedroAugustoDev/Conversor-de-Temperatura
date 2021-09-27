package br.com.pedro.converter.controller;


import br.com.pedro.converter.model.Calculator;
import br.com.pedro.converter.model.Options;
import br.com.pedro.converter.model.service.LoadProperties;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class MainController {

    @FXML
    private TextField mainInput;
    @FXML
    private Label mainLabel;
    @FXML
    private Label labelInputMain;
    @FXML
    private ChoiceBox<String> choiceBox;
    private final Calculator calculator;
    private String optionOne = "C";
    private String optionTwo = "F";
    private static final LoadProperties LOAD_PROPERTIES;

    static {
        LOAD_PROPERTIES = new LoadProperties();
    }

    public MainController(){
        if(!LOAD_PROPERTIES.isEmpty()){
            if(LOAD_PROPERTIES.getDefaultTemp() == Options.CELSIUS) this.calculator = new Calculator(Options.CELSIUS);
            else this.calculator = new Calculator(Options.FAHRENHEIT);
        } else this.calculator = new Calculator();
    }

    private void configure(){
        if(this.calculator.getOption() == Options.CELSIUS) this.celsiusOption();
        else this.fahrenheitOption();
        this.choiceBox.setValue((this.calculator.getOption() == Options.CELSIUS) ? "Celsius": "Fahrenheit");
    }

    private void setChoiceBox(){
        List<String> items = Arrays.asList("Celsius", "Fahrenheit");
        this.choiceBox.setItems(FXCollections.observableList(items));
        this.addListenerInChoiceBox();

    }

    /*
     * Add event listener "change" in choice box
     * when the value was changed, call method
     * fahrenheitOption() if value select was fahrenheit (1)
     * else call celsiusOption() method, to another value 1
     */
    private void addListenerInChoiceBox(){
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    if(new_val.intValue() == 1) this.fahrenheitOption();
                    else this.celsiusOption();
                });
    }

    /**
     * @param number is the number 'll get in the TextField,
     *              parsed to Double and set attribute number of Calculator class
     */
    private double calc(double number){
        calculator.setNumber(number);
        if(calculator.getOption() == Options.CELSIUS) this.calculator.getCelsiusInFahrenheit();
        else if(calculator.getOption() == Options.FAHRENHEIT) this.calculator.getFahrenheitInCelsius();
        return calculator.getResult();
    }


    private void fahrenheitOption(){
        this.calculator.setOption(Options.FAHRENHEIT);
        this.optionOne = "F";
        this.optionTwo = "C";
        this.labelInputMain.setText(LOAD_PROPERTIES.getFahrenheitTempMessage());
        this.mainInput.setPromptText('\u00B0' +this.optionOne);
    }
    private void celsiusOption(){
        this.calculator.setOption(Options.CELSIUS);
        this.optionOne = "C";
        this.optionTwo = "F";
        this.labelInputMain.setText(LOAD_PROPERTIES.getCelsiusTempMessage());
        this.mainInput.setPromptText('\u00B0' +this.optionOne);
    }


    public void handlerEventButtonExit(){
        System.exit(0);
    }

    public void handlerEventInput(){
        if(this.mainInput.getText().length() != 0 && !this.mainInput.getText().equals("-")){
            try {
                if(mainInput.getText().contains(",")){
                    mainInput.setText(mainInput.getText().replace(",", "."));
                }
                this.setOnScreenValuesSuccess(this.calc(Double.parseDouble(this.mainInput.getText())));
            } catch (NumberFormatException e){
               this.setOnScreenValuesError();
            }
        }
    }
    private void setOnScreenValuesSuccess( double result ){
        this.mainLabel.setTextFill(LOAD_PROPERTIES.getSuccessColor());
        this.mainLabel.setText(this.calculator.getNumber() + "°" + optionOne + " " + LOAD_PROPERTIES.getEquateMessage() + " a " + result + "°" + optionTwo);
    }
    private void setOnScreenValuesError(){
        this.mainLabel.setTextFill(LOAD_PROPERTIES.getErrorColor());
        this.mainLabel.setText(LOAD_PROPERTIES.getInvalidInput());
    }

    public void setInputValueByTempValue(){
        this.mainInput.setText(LOAD_PROPERTIES.getDefaultTempValue().toString());
        this.setOnScreenValuesSuccess(this.calc(LOAD_PROPERTIES.getDefaultTempValue()));
    }

    public void initialize(){
        setChoiceBox();
        this.configure();
        this.setInputValueByTempValue();
    }
}