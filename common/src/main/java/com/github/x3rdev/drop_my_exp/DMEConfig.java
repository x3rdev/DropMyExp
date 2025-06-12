package com.github.x3rdev.drop_my_exp;

import com.teamresourceful.resourcefulconfig.api.annotations.*;

@ConfigInfo(
        titleTranslation = "config.drop_my_exp.title",
        descriptionTranslation = "config.drop_my_exp.desc"
)
@Config("drop_my_exp")
public class DMEConfig {

    @ConfigEntry(
            id = "modEnabled",
            translation = "config.drop_my_exp.modEnabled"
    )
    @Comment(value = "modEnabled", translation = "config.drop_my_exp.modEnabled.comment")
    public static boolean modEnabled = true;

    @ConfigOption.Range(min = -1, max = Integer.MAX_VALUE)
    @ConfigEntry(
            id = "expCap",
            translation = "config.drop_my_exp.expCap"
    )
    @Comment(value = "expCap", translation = "config.drop_my_exp.expCap.comment")
    public static int expCap = 100;

    @ConfigOption.Range(min = 0, max = 100)
    @ConfigEntry(
            id = "expPercent",
            translation = "config.drop_my_exp.expPercent"
    )
    @Comment(value = "expPercent", translation = "config.drop_my_exp.expPercent.comment")
    public static int expPercent = 100;

    @ConfigEntry(
            id = "oneOrb",
            translation = "config.drop_my_exp.oneOrb"
    )
    @Comment(value = "oneOrb", translation = "config.drop_my_exp.oneOrb.comment")
    public static boolean oneOrb = false;


}
