package br.com.pedro.converter.model.service;

import br.com.pedro.converter.model.AnaliseProperties;
import br.com.pedro.converter.model.Options;
import javafx.scene.paint.Color;

public class LoadProperties {
    private final AnaliseProperties properties;
    private String invalidInput;
    private String celsiusTempMessage;
    private String fahrenheitTempMessage;
    private String equateMessage;
    private Options defaultTemp;
    private Double defaultTempValue;
    private Color successColor;
    private Color errorColor;

    public LoadProperties(){
        properties = new AnaliseProperties();
        loadPropertiesFromProperties();
    }

    public boolean isEmpty(){
        return properties.isEmpty();
    }

    private void loadPropertiesFromProperties(){
        this.invalidInput = properties.findAnotherValueFromKey("application.default.error.string.invalid").toString();
        this.celsiusTempMessage = properties.findAnotherValueFromKey("application.default.message.string.celsius").toString();
        this.fahrenheitTempMessage = properties.findAnotherValueFromKey("application.default.message.string.fahrenheit").toString();
        this.equateMessage = properties.findAnotherValueFromKey("application.default.message.string.equate").toString();
        if(properties.findAnotherValueFromKey("application.default.temp").toString().equals("C")) this.defaultTemp = Options.CELSIUS;
        else this.defaultTemp = Options.FAHRENHEIT;
        this.defaultTempValue = Double.parseDouble(properties.findAnotherValueFromKey("application.default.temp.value").toString());
        this.successColor = Color.web(properties.findAnotherValueFromKey("application.color.success").toString());
        this.errorColor = Color.web(properties.findAnotherValueFromKey("application.color.error").toString());
    }

    public String getInvalidInput() {
        return invalidInput;
    }

    public void setInvalidInput(String invalidInput) {
        this.invalidInput = invalidInput;
    }

    public String getCelsiusTempMessage() {
        return celsiusTempMessage;
    }

    public void setCelsiusTempMessage(String celsiusTempMessage) {
        this.celsiusTempMessage = celsiusTempMessage;
    }

    public String getFahrenheitTempMessage() {
        return fahrenheitTempMessage;
    }

    public void setFahrenheitTempMessage(String fahrenheitTempMessage) {
        this.fahrenheitTempMessage = fahrenheitTempMessage;
    }

    public Options getDefaultTemp() {
        return defaultTemp;
    }

    public void setDefaultTemp(Options defaultTemp) {
        this.defaultTemp = defaultTemp;
    }

    public Double getDefaultTempValue() {
        return defaultTempValue;
    }

    public void setDefaultTempValue(Double defaultTempValue) {
        this.defaultTempValue = defaultTempValue;
    }

    public Color getSuccessColor() {
        return successColor;
    }

    public void setSuccessColor(Color successColor) {
        this.successColor = successColor;
    }

    public Color getErrorColor() {
        return errorColor;
    }

    public void setErrorColor(Color errorColor) {
        this.errorColor = errorColor;
    }

    public AnaliseProperties getProperties() {
        return properties;
    }

    public String getEquateMessage() {
        return equateMessage;
    }

    public void setEquateMessage(String equateMessage) {
        this.equateMessage = equateMessage;
    }
}
