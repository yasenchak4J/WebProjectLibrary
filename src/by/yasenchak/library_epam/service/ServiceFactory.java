package by.yasenchak.library_epam.service;

public final class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService = new ClientServiceImpl();

    private ServiceFactory(){

    }
    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClientService(){
        return clientService;
    }
}
