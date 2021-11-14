package ru.pavlov.jmcalculator;

public class OutputHandler {
    private boolean modeRomeDigits;
    private int intResult;

    private String result;

    private boolean outputValid = false;

    public boolean isOutputValid() {
        return outputValid;
    }

    public String getResult() {
        return result;
    }

    public OutputHandler(boolean modeRomeDigits, int intResult) throws CalculatorException {
        this.modeRomeDigits = modeRomeDigits;
        this.intResult = intResult;
        this.outputControl();
    }

    private void outputControl() throws CalculatorException{

        if (!this.checkRomeMode()){
            result = String.valueOf(this.intResult);
        }
        else {
            result = ConverterArabicRoman.arabicToRoman(this.intResult);
        }

        this.outputValid = true;

    }

    private boolean checkRomeMode() throws CalculatorException{
        if (this.modeRomeDigits){
            if (this.intResult < 1){
                throw new CalculatorException.RomeSystemHasNoNegativeDigits();
            }
            return true;
        }
        return false;
    }

}
