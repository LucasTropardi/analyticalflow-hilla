package com.ltsoftwaresupport.analyticalflow;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@author Lucas Tropardi
 */
@SpringBootApplication
@Theme(value = "analyticalflow")
public class AnalyticalFlowApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(AnalyticalFlowApplication.class, args);
    }

}
