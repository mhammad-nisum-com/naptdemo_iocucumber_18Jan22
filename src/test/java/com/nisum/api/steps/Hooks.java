package com.nisum.api.steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;

/**
 * Hooks Class
 */
public class Hooks {

    private static final Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario sc) throws MalformedURLException {
    }


    @After
    public void afterScenario(Scenario sc) {
    }
}
