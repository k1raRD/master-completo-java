package com.k1rard.appcliente.ejb;

import com.k1rard.webpp.ejb.models.Producto;
import com.k1rard.webpp.ejb.service.ServiceEjbRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        ServiceEjbRemote service = null;
        ServiceEjbRemote service2 = null;
        //final Properties env = new Properties();
        //env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        //env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        //env.put("jboss.naming.client.ejb.context", true);
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote-security/ServiceEjb!com.k1rard.webpp.ejb.service.ServiceEjbRemote?stateful");
            service2 = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote-security/ServiceEjb!com.k1rard.webpp.ejb.service.ServiceEjbRemote?stateful");

            String saludo = service.saludar("Alex");
            String saludo2 = service2.saludar("John");

            System.out.println(saludo);
            System.out.println(saludo2);

            Producto p = service.crear(new Producto("sandia"));
            System.out.println("Nuevo producto " + p);

            service.listar().forEach(System.out::println);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
