package br.com.pedro.converter.model;

public class Calculator {
    private double number;
    private double result;
    private Options option;

    public Calculator(){
        this(Options.CELSIUS);
    }

    public Calculator(Options option){
        this.option = option;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }


    public double getResult() {
        return Double.parseDouble(String.format("%.1f", this.result).replace(",", "."));
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    public void getCelsiusInFahrenheit(){
        if(this.option == Options.CELSIUS){
            this.result = ((this.number * 9) / 5) + 32 ;
        } else throw new RuntimeException("Error to convert Celsius in Fahrenheit because number its fahrenheit!");
    }

    public void getFahrenheitInCelsius(){
        if(this.option == Options.FAHRENHEIT){
            this.result = (this.number - 32 ) * 5 /9;
        } else throw new RuntimeException("Error to convert Celsius in Fahrenheit because number its fahrenheit!");
    }

}
