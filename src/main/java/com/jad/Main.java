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
        shows.add(ShowFactory.MakeShow("MOVIE:name=Kamen Riders;"+
                "description=Les Kamen Riders, conducteurs de moto au pouvoir des étoiles, défendent la ville contre les attaques des Narghuls;"+
                "director=Mahimoto Yosuke;"+
                "yearOfRelease=2023;"+
                "movieType=SCIENCE_FICTION"));
        shows.add(ShowFactory.MakeShow("THEATER:name=Secrets souterrains;"+
                "description=Le clan des Lawrence cherche à reprendre son pouvoir et sa gloire passé à Mondstadt, mais Eula, une de ses membres s'y oppose;"+
                "director=Jean de Favonius;"+
                "actors=Eula Lawrence,"+
                "Harmand Lawrence,"+
                "Venti Dandelion,"+
                "Amber Pyra,"+
                "Kaeya Kaschlana,"+
                "Lisa Lewis"));
        shows.add(ShowFactory.MakeShow("STREET_SHOW:name=La mascarade des tissus;"+
                "description=Dans la grande ville aux batiments en pierre et en bois recouverts de tissus somptueux, une mascarade se prépare à l'abri des yeaux vigilants des gardiens;"+
                "performers=Klee,"+
                "Nahida,"+
                "Diona,"+
                "YaoYao,"+
                "Dori,"+
                "Aino,"+
                "Kachina,"+
                "Quiqui,"+
                "Lansan,"+
                "Sayu,"+
                "Sigewinne"));
        shows.add(ShowFactory.MakeShow("CONCERT:name=Under the sun;"+
                "description=Concert reprenant les meilleurs hits de Boris et Uamee;"+
                "artist=Boris et Uamee"));

        System.out.println("");
        for (final IShow show : shows) {
            jad.watch(show);
        }
    }
}