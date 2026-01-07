package com.jad.show;

public class CreateConcertShowHandler extends CreateShowHandler {
    String ARTIST_NAME_KEY = "artist";

    public CreateConcertShowHandler() {
        super(ShowType.CONCERT);
    }

    @Override
    IShow handle(String showDescription) throws IllegalArgumentException {
        if(getShowType(showDescription) == getShowTypeHandled()) {
            return makeConcertShow(showDescription);
        }
        return getNextHandler().handle(showDescription);
    }

    ConcertShow makeConcertShow(String showDescription) {
        return ShowFactory.MakeConcertShow(getShowName(showDescription),
                getShowDescription(showDescription),
                getArtistName(showDescription));
    }

    protected String getArtistName(String showDesc) {
        return getShowParameterByKey(showDesc, ARTIST_NAME_KEY);
    }
}
