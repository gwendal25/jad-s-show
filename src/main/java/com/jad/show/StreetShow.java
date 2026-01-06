package com.jad.show;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.jad.customer.ISpectator;

public class StreetShow extends Show {
    private final ArrayList<String> performers = new ArrayList<>();

    public StreetShow(final String name, final String description, final String... performers) {
        super(name, description, ShowType.STREET_SHOW);
        this.performers.addAll(Arrays.asList(performers));
    }

    public List<String> getPerformers() {
        return Collections.unmodifiableList(this.performers);
    }

    @Override
    public void watch(ISpectator spectator) {
        spectator.watch(this);
    }
}
