package com.martinez.lisandro.torrentfinder.exceptions;

public class PageNotFoundException extends RuntimeException {
    public static final String DESCRIPTION = "Page Not Found";
    private static final long serialVersionUID = 112075667688546379L;

    public PageNotFoundException() {
        super(DESCRIPTION);
    }

    public PageNotFoundException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}
