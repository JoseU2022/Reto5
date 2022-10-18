package com.example.toolproject.entities;

public class ClientCounter {

    private Long total;
    private Client client;

    public ClientCounter(Long totalClients, Client client) {
        this.total = totalClients;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long totalClients) {
        this.total = totalClients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
