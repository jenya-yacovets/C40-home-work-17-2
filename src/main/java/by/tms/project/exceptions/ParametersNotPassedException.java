package by.tms.project.exceptions;

public class ParametersNotPassedException extends Exception{
    private String param;

    public ParametersNotPassedException(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    @Override
    public String getMessage() {
        return String.format("The '%s' parameter was not passed", param);
    }
}
