package com.github.x3rdev.drop_my_exp;

import com.teamresourceful.resourcefulconfig.api.loader.Configurator;

public class CommonClass {

    public static final Configurator CONFIGURATOR = new Configurator(Constants.MOD_ID);

    public static void init() {
        Constants.LOG.info("Initializing {}", Constants.MOD_ID);
        CONFIGURATOR.register(DMEConfig.class);

    }
}