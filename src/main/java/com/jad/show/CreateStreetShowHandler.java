package com.jad.show;

public class CreateStreetShowHandler extends CreateShowHandler {
    String PERFORMERS_KEY = "performers";
    String PERFORMERS_SEPARATOR_KEY = ",";

    public CreateStreetShowHandler() {
        super(ShowType.STREET_SHOW);
    }

    @Override
    IShow handle(String showDescription) throws IllegalArgumentException {
        if(getShowType(showDescription) == getShowTypeHandled()) {
            return CreateStreetShow(showDescription);
        }
        return getNextHandler().handle(showDescription);
    }

    protected StreetShow CreateStreetShow(String showDescription) {
        return ShowFactory.MakeStreetShow(getShowName(showDescription),
                getShowDescription(showDescription),
                getPerformers(showDescription));
    }

    protected String[] getPerformers(String showDesc) {
        String performers = getShowParameterByKey(showDesc, PERFORMERS_KEY);
        if(performers.isBlank()) {
            throw new IllegalArgumentException("Les acteurs ne sont pas spécifiés");
        }
        return performers.split(PERFORMERS_SEPARATOR_KEY);
    }
}
