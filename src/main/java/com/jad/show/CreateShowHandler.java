package com.jad.show;

public abstract class CreateShowHandler {
    String SHOW_TYPE_SEPARATOR = ":";
    String SHOW_NAME_KEY = "name";
    String SHOW_DESCRIPTION_KEY = "description";
    String PARAM_SEPARATOR = ";";
    String PARAM_VALUE_SEPARATOR = "=";
    ShowType showTypeHandled;
    CreateShowHandler nextHandler;

    public ShowType getShowTypeHandled() {
        return showTypeHandled;
    }

    public CreateShowHandler getNextHandler() {
        return nextHandler;
    }

    public boolean hasNextHandler() {
        return nextHandler != null;
    }

    public void addHandler(CreateShowHandler nextHandler) {
        if(this.hasNextHandler()) {
            this.nextHandler.addHandler(nextHandler);
        }
        else {
            this.nextHandler = nextHandler;
        }
    }

    public CreateShowHandler(ShowType showTypeHandled) {
        this.showTypeHandled = showTypeHandled;
    }

    abstract IShow handle(String showDescription) throws IllegalArgumentException;

    protected ShowType getShowType(String showDesc) {
        return ShowType.valueOf(showDesc.split(SHOW_TYPE_SEPARATOR)[0]);
    }

    protected String getShowName(String showDesc) {
        return getShowParameterByKey(showDesc, SHOW_NAME_KEY);
    }

    protected String getShowParameterByKey(String showDesc, String key) throws IllegalArgumentException {
        String parameters = showDesc.split(SHOW_TYPE_SEPARATOR)[1];
        String[] paramsArray = parameters.split(PARAM_SEPARATOR);
        for(String param : paramsArray) {
            if(param.startsWith(key)) {
                return param.split(PARAM_VALUE_SEPARATOR)[1];
            }
        }
        
        throw new IllegalArgumentException("La clé " + key + "n'est pas valide");
    }

    protected String getShowDescription(String showDesc) {
        return getShowParameterByKey(showDesc, SHOW_DESCRIPTION_KEY);
    }
}
