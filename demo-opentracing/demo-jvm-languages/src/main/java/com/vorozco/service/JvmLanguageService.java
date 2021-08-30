package com.vorozco.service;

import com.vorozco.model.JvmLanguage;
import org.eclipse.microprofile.opentracing.Traced;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class JvmLanguageService {

    List<JvmLanguage> jvmLanguages;

    @PostConstruct
    public void init(){
        jvmLanguages = List.of(
                new JvmLanguage("Java", 1996),
                new JvmLanguage("Scala", 2004),
                new JvmLanguage("Kotlin", 2011),
                new JvmLanguage("Ballerina", 2017)
        );
    }

    @Traced
    public List<JvmLanguage> getJvmLanguageList(){
        try{
            Thread.sleep(3000);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return this.jvmLanguages;
    }
}
