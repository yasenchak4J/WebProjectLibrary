package by.yasenchak.library_epam.utils;

public enum RequestParameter {
    ACTION("action"),
    AUTHORS("authors"),
    NEW_AUTHOR("addNewAuthor"),
    CHANGE_AUTHOR("changeAuthor"),
    CHANGE_GENRE("changeGenre"),
    NEW_GENRE("addNewGenre"),
    NAME("name"),
    SURNAME("surname"),
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
    RENEW_SUBS("renewSubs"),
    USER_RENEW_SUBS("userRenewSubs"),
    USER_CONFIRM_RENEW("userAgreeRenew"),
    USER_REJECT_RENEW("userRejectRenew"),
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
