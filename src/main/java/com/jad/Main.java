package com.jad;

import com.jad.customer.*;
import com.jad.show.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class Main {
    public static void main(final String[] args) {
        final ISpectator jad = new Spectator("Jean-Aymeric", "Diet");

        final List<IShow> shows = new ArrayList<>();
        shows.add(ShowFactory.MakeMovieShow("Kamen Riders",
                "Les Kamen Riders, conducteurs de moto au pouvoir des étoiles, défendent la ville contre les attaques des Narghuls.",
                "Mahimoto Yosuke",
                "2023",
                MovieType.SCIENCE_FICTION));
        shows.add(ShowFactory.MakeTheaterShow("Secrets souterrains",
                "Le clan des Lawrence cherche à reprendre son pouvoir et sa gloire passé à Mondstadt, mais Eula, une de ses membres s'y oppose.",
                "Jean de Favonius",
                "Eula Lawrence",
                "Harmand Lawrence",
                "Venti Dandelion"));
        shows.add(ShowFactory.MakeStreetShow("La mascarade des tissus",
                "Dans la grande ville aux batiments en pierre et en bois recouverts de tissus somptueux, une mascarade se prépare à l'abri des yeaux vigilants des gardiens",
                "Klee",
                "Nahida",
                "Diona"));
        shows.add(ShowFactory.MakeConcertShow("Under the sun",
                "Concert reprenant les meilleurs hits de Boris et Uamee",
                "Boris et Uamee"));

        System.out.println("");
        for (final IShow show : shows) {
            jad.watch(show);
        }
    }
}