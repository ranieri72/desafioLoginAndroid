package br.com.ranieri.desafiologin.request;

public enum WSmethods {

    login("/user/login");

    private final String text;

    WSmethods(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
