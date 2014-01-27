package com.avconv4java.option;

import com.avconv4java.core.AVOptions;
import com.avconv4java.model.AVLogLevelType;

/**
 * @author Vladislav Bauer
 */

public class AVGenericOptions extends AVOptions {

    public static final String FLAG_LOG_LEVEL = "-loglevel";


    public static AVGenericOptions create() {
        return new AVGenericOptions();
    }


    @Override
    public AVGenericOptions flags(final Object... flags) {
        return (AVGenericOptions) super.flags(flags);
    }

    @Override
    public AVGenericOptions builders(final AVOptions... builders) {
        return (AVGenericOptions) super.builders(builders);
    }


    public AVGenericOptions logLevel(final Integer level) {
        return logLevel(level == null ? null : String.valueOf(level));
    }

    public AVGenericOptions logLevel(final AVLogLevelType logLevelType) {
        return logLevel(logLevelType == null ? null : logLevelType.getName());
    }

    protected AVGenericOptions logLevel(final String logLevelName) {
        return flags(FLAG_LOG_LEVEL, logLevelName);
    }

}