package com.vorozco.demo.metrics;

import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Random;

@Path("/demo-metrics")
@ApplicationScoped
public class DemoMetricsController {

    @GET
    @Path("/concurrent")
    @ConcurrentGauge(name="usuariosEnVivo", displayName = "Usuarios concurrentes en vivo", description = "Muestra de forma concurrente los usuarios que llaman a este metodo")
    public String concurrentUsersMethod() throws InterruptedException {
        Thread.sleep(500);
        return "Concurrencia " + getIpAddr()  + "\n";
    }

    @GET
    @Path("/count")
    @Counted(name="incremento", displayName = "Contador de llamadas", description = "Muestra cuantas veces se ha invocado el metodo")
    public String incrementMethod(){
        return "Cuenta " + getIpAddr()  + "\n";
    }

    @GET
    @Path("/gauge")
    public String gaugeMethod(){
        myGauge();
        return "Cuenta " + getIpAddr()  + "\n";
    }

    @Gauge(name = "tacometro", displayName = "Medidor de valores arbitrarios", description = "Muestra un valor arbitrario", unit = "tuxrandoms", absolute = true)
    public Integer myGauge() {
        return new Random().nextInt(500);
    }

    @GET
    @Path("/timed")
    @Timed(name="temporizado", displayName="Metrica con timed", description = "Muestra de un valor temporizado")
    public String timedMethod() throws InterruptedException {
        Thread.sleep(1000);
        return "Concurrencia " + getIpAddr()  + "\n";
    }

    @GET
    @Path("/metered")
    @Timed(name="medido", displayName="Metrica con metered", description = "Muestra de un valor medido")
    public String meteredMethod() throws InterruptedException {
        Thread.sleep(1000);
        return "Concurrencia " + getIpAddr()  + "\n";
    }

    public String getIpAddr(){
        try {
            return Inet4Address.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "No address available";
    }
}
