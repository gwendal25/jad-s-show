package com.jad.show;

public class CreateMovieShowHandler extends CreateShowHandler{
    String DIRECTOR_NAME_KEY = "director";
    String YEAR_OF_RELEASE_KEY = "yearOfRelease";
    String MOVIE_TYPE_KEY = "movieType";

    public CreateMovieShowHandler() {
        super(ShowType.MOVIE);
    }

    @Override
    IShow handle(String showDescription) throws IllegalArgumentException {
        if(getShowType(showDescription) == getShowTypeHandled()) {
            return CreateMovieShow(showDescription);
        }
        return getNextHandler().handle(showDescription);
    }

    MovieShow CreateMovieShow(String showDescription) {
        return ShowFactory.MakeMovieShow(getShowName(showDescription),
                getShowDescription(showDescription),
                getDirectorName(showDescription),
                getYearOfRelease(showDescription),
                getMovieType(showDescription));
    }

    protected String getDirectorName(String showDesc) {
        return getShowParameterByKey(showDesc, DIRECTOR_NAME_KEY);
    }

    protected String getYearOfRelease(String showDesc) {
        return getShowParameterByKey(showDesc, YEAR_OF_RELEASE_KEY);
    }

    protected MovieType getMovieType(String showDesc) {
        return MovieType.valueOf(getShowParameterByKey(showDesc, MOVIE_TYPE_KEY));
    }
}
