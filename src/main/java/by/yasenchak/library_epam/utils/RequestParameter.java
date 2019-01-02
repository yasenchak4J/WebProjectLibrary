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
    DATE_IN("dateIn"),
    DATE_OUT("dateOut"),
    CURRENT_SUBS("currentSubs"),
    CURRENT_USER_SUBS("currentUserSubs"),
    USERS("users"),
    NEW_ROLE("newRole"),
    UNC_SUBS("unconfirmedSubs"),
    FIRSTNAME("firstName"),
    LASTNAME("lastName"),
    GENDER("gender"),
    ID("id"),
    FILE("file"),
    LANG("lang"),
    GENRE("genre"),
    GENRES("genres"),
    LOGIN("login"),
    PASSWORD("password"),
    REGISTRATION("registration"),
    TEXT_SEARCH("textSearch"),
    SUBS("subs"),
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
