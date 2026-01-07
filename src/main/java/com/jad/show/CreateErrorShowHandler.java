package com.jad.show;

public class CreateErrorShowHandler extends CreateShowHandler{
    public CreateErrorShowHandler() {
        super(null);
    }

    @Override
    IShow handle(String showDescription) throws IllegalArgumentException {
        throw new IllegalArgumentException("Le type de show n'est pas valide");
    }
}
