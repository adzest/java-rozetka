package com.ua.rozetka.isakov.helpers;

import com.ua.rozetka.isakov.helpers.client.WebClient;

public class App {
    private WebClient clientWeb;
    private Jira jira;
    private Base base;

    public Jira jira() {
        return jira == null ? jira = new Jira() : jira;
    }

    public Base base() {
        return base == null ? base = new Base() : base;
    }

    public WebClient WebClient() {
        return clientWeb == null ? clientWeb = new WebClient() : clientWeb;
    }
}