package com.k1rard.webapp.jsf3.primefaces.controllers;

import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Model
public class LogoutController {

    @Inject
    private FacesContext facesContext;

    public String logout() throws ServletException {
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        request.logout();
        request.getSession().invalidate();
        facesContext.addMessage(null, new FacesMessage("Haz cerrado sesion con exito!"));
        return "login.xhtml?faces-redirect=true";
    }
}
