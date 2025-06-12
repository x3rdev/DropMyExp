package com.github.x3rdev.drop_my_exp;

import com.teamresourceful.resourcefulconfig.api.annotations.Config;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo;

@ConfigInfo(title = "Drop My Exp")
@Config("drop_my_exp")
public class DMEConfig {

    @ConfigEntry(
            id = "modEnabled",
            translation = "drop_my_exp.config.modEnabled"
    )
    public static boolean modEnabled = false;
}
