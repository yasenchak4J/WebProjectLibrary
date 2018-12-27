package by.yasenchak.library_epam.utils;

public enum RequestParameter {
    ACTION("action"),
    NAME("name"),
    PUBLISHER("publisher"),
    PAGE_COUNT("pageCount"),
    ISBN("isbn"),
    BOOKS("books"),
    BOOK("book"),
    TYPE("type"),
    USER("user"),
    USERS("users"),
    ID("id"),
    FILE("file"),
    LANG("lang"),
    GENRE("genre"),
    GENRES("genres"),
    LOGIN("login"),
    PASSWORD("password"),
    REGISTRATION("registration"),
    TEXT_SEARCH("textSearch"),
    SESSION_LOCALE("sessionLocale"),
    ERROR("error");

    private String code;

    RequestParameter (String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
