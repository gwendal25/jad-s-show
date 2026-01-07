package com.jad.show;

public abstract class ShowFactory {
    public static ConcertShow MakeConcertShow(final String name, final String description, final String artist){
        return new ConcertShow(name, description, artist);
    }

    public static MovieShow MakeMovieShow(final String name, final String description, final String director, final String yearOfRelease, final MovieType movieType) {
        return new MovieShow(name, description, director, yearOfRelease, movieType);
    }

    public static StreetShow MakeStreetShow(final String name, final String description, final String... performers) {
        return new StreetShow(name, description, performers);
    }

    public static TheaterShow MakeTheaterShow(final String name, final String description, final String director, final String... actors) {
        return new TheaterShow(name, description, director, actors);
    }

    public static IShow MakeShow(final String showDescription) {
        return CreateShowHandlerChain.getInstance().handle(showDescription);
    }
}
