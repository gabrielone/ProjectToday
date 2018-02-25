package com.infosys.barniv1.application;

import android.app.Application;

import com.infosys.barniv1.manager.BarniRestManager;

/**
 * Barni application.
 */

public class BarniApplication extends Application {

    private static BarniApplication instance;

    private BarniRestManager barniManager;

    @Override
    public void onCreate() {
        super.onCreate();
        BarniApplication.instance = this;
        this.barniManager = new BarniRestManager();
    }

    public static BarniApplication getInstance() {
        return instance;
    }

    public BarniRestManager getManager() {
        return barniManager;
    }

}
