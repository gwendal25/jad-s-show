package com.jad.show;

public class CreateShowHandlerChain extends CreateShowHandler {
    static CreateShowHandlerChain INSTANCE = new CreateShowHandlerChain();

    public static CreateShowHandlerChain getInstance() {
        if(!INSTANCE.hasNextHandler()) {
            INSTANCE.addHandler(new CreateConcertShowHandler());
            INSTANCE.addHandler(new CreateMovieShowHandler());
            INSTANCE.addHandler(new CreateStreetShowHandler());
            INSTANCE.addHandler(new CreateTheaterShowHandler());
            INSTANCE.addHandler(new CreateErrorShowHandler());
        }
        return INSTANCE;
    }

    public CreateShowHandlerChain() {
        super(null);
    }

    @Override
    public IShow handle(String showDescription) throws IllegalArgumentException {
        if(hasNextHandler()) {
            return getNextHandler().handle(showDescription);
        }
        return null;
    }
}
