package com.avconv4java.option;

import com.avconv4java.core.AVGenericOptions;
import com.avconv4java.model.AVStrictType;

/**
 * @author Vladislav Bauer
 */

public class AVCodecOptions extends AVGenericOptions {

    public static AVCodecOptions create() {
        return new AVCodecOptions();
    }


    @Override
    public AVCodecOptions flags(final Object... flags) {
        return (AVCodecOptions) super.flags(flags);
    }

    @Override
    public AVCodecOptions builders(final AVGenericOptions... builders) {
        return (AVCodecOptions) super.builders(builders);
    }


    public AVCodecOptions strict(final AVStrictType strictType) {
        return strict(strictType == null ? null : strictType.getName());
    }

    public AVCodecOptions strict(final String strictTypeName) {
        return flags("-strict", strictTypeName);
    }

    public AVCodecOptions videoBitRate(final Integer bitRate) {
        return bitRate == null ? this : flags("-b", bitRate + "k");
    }

}
