package com.jad.customer;

import java.text.MessageFormat;
import java.util.stream.Collectors;

import com.jad.show.ConcertShow;
import com.jad.show.IShow;
import com.jad.show.MovieShow;
import com.jad.show.StreetShow;
import com.jad.show.TheaterShow;

public class Spectator implements ISpectator {
    private final String firstName;
    private final String lastName;

    public Spectator(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void watch(final IShow show) {
        show.watch(this);
    }

    @Override
    public void watch(ConcertShow concertShow) {
        String message = MessageFormat.format("""
            J''ai vu le concert {0} de {1}
            """,
            concertShow.getName(), concertShow.getArtist());
        System.out.println(message);
    }

    @Override
    public void watch(MovieShow movieShow) {
        String message = MessageFormat.format("""
            J''ai vu le film {0} de {1} sorti en {2}
            """, 
            movieShow.getName(), movieShow.getDirector(), movieShow.getYearOfRelease());
        System.out.println(message);
    }

    @Override
    public void watch(StreetShow streetShow) {
        String performers = streetShow.getPerformers().stream().collect(Collectors.joining(", "));
        String message = MessageFormat.format("""
            J''ai assisté au spectacle de rue {0} avec les artistes :
            {1}
            """,
            streetShow.getName(), performers);
        System.out.println(message);
    }

    @Override
    public void watch(TheaterShow theaterShow) {
        String actors = theaterShow.getActors().stream().collect(Collectors.joining(", "));
        String message = MessageFormat.format("""
            J''ai assisté à la pièce de théatre {0} de {1} avec les artistes :
            {2}
            """, 
            theaterShow.getName(), theaterShow.getDirector(), actors);
        System.out.println(message);
    }
}
