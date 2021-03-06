package by.yasenchak.library_epam.concrete_controller;


import by.yasenchak.library_epam.concrete_controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private static CommandHelper instance = new CommandHelper();
    private Map<String, Command> commands = new HashMap<>();

    private CommandHelper(){
        commands.put("registration", new RegistrationCommand());
        commands.put("signin", new SignInCommand());
        commands.put("getAllBook", new GetAllBookCommand());
        commands.put("addNewBook", new AddNewBook());
        commands.put("getBookById", new GetBookById());
        commands.put("editBook", new EditBook());
        commands.put("getBookByGenre", new GetBooksByGenre());
        commands.put("deleteBook", new DeleteBookByID());
        commands.put("search", new SearchByText());
        commands.put("signOut", new SignOut());
        commands.put("goToProfile", new GoToProfile());
        commands.put("subscriptionBook", new SubscriptionBook());
        commands.put("goToAuthPage", new GoToAuth());
        commands.put("addToSubs", new AddNewSubscription());
        commands.put("getAllBookAdmin", new GetAllBooksAdmin());
        commands.put("searchAdmin", new SearchAdmin());
        commands.put("toAddNewBook", new GoToAddNewBook());
        commands.put("toAllUsers", new GoToAllUsers());
        commands.put("changeRole", new ChangeUserRole());
        commands.put("deleteUser", new DeleteUser());
        commands.put("whatIsTheBook", new WhatIsTheBookLibrarian());
        commands.put("goToConfirmSubs", new GoToConfirmSubs());
        commands.put("confirmSubs", new ConfirmSubscription());
        commands.put("goToAllUncSubs", new GoToAllUnconfirmedSubs());
        commands.put("goToCurrentSubs", new GoToCurrentSubs());
        commands.put("agreeReturn", new ConfirmReturnBook());
        commands.put("renewSubscription", new RenewSubscription());
        commands.put("goToRenewSubs", new GoToRenewSubs());
        commands.put("goUserRenewSubs", new GoToUserRenewSubs());
        commands.put("toAgreeRenew", new GoToAgreeRenew());
        commands.put("agreeRenew", new AgreeRenew());
        commands.put("rejectRenew", new RejectRenew());
        commands.put("toAllAuthors", new GoToAllAuthors());
        commands.put("deleteAuthor", new DeleteAuthor());
        commands.put("toChangeAuthor", new GoToChangeAuthor());
        commands.put("changeAuthor", new ChangeAuthor());
        commands.put("addNewAuthor", new AddNewAuthor());
        commands.put("toAddNewAuthor", new GoToAddNewAuthor());
        commands.put("toAllGenres", new GoToAllGenres());
        commands.put("toChangeGenre", new GoToChangeGenre());
        commands.put("changeGenre", new ChangeGenre());
        commands.put("toAddNewGenre", new GoToAddNewGenre());
        commands.put("addNewGenre", new AddNewGenre());
    }

    public static CommandHelper getInstance(){
        return instance;
    }

    public Command getCommand(String commandName){
        Command command = null;
        if(commandName != null){
            command = commands.get(commandName);
        }
        return command;
    }
}
