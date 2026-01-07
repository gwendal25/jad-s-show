package com.jad.show;

public class CreateTheaterShowHandler extends CreateShowHandler {
    String DIRECTOR_NAME_KEY = "director";
    String ACTORS_KEY = "actors";
    String ACTORS_SEPARATOR_KEY = ",";

    public CreateTheaterShowHandler() {
        super(ShowType.THEATER);
    }

    @Override
    IShow handle(String showDescription) throws IllegalArgumentException {
        if(getShowType(showDescription) == getShowTypeHandled()) {
            return CreateTheaterShow(showDescription);
        }
        return getNextHandler().handle(showDescription);
    }

    protected TheaterShow CreateTheaterShow(String showDescription) {
        return ShowFactory.MakeTheaterShow(getShowName(showDescription),
                getShowDescription(showDescription),
                getDirectorName(showDescription),
                getActors(showDescription));
    }

    protected String getDirectorName(String showDesc) {
        return getShowParameterByKey(showDesc, DIRECTOR_NAME_KEY);
    }

    protected String[] getActors(String showDesc) {
        String actors = getShowParameterByKey(showDesc, ACTORS_KEY);
        if(actors.isBlank()) {
            throw new IllegalArgumentException("Les acteurs ne sont pas spécifiés");
        }
        return actors.split(ACTORS_SEPARATOR_KEY);
    }
}
