
Introduction
============

Project "avconv4java" is a pure-java interface to the avconv commandline.

Official avconv documentation could be found here: http://libav.org/avconv.html


Features
========

* Supports most avconv commands
* Reuse a commandline multiple times for different set of parameters
* Options and operators translate into similar method-names, e.g.
    * -vcodec libx264 -> .videoCodec(AVVideoCodecType.H264)
    * -vcodec libtheora -> .videoCodec(AVVideoCodecType.THEORA)
* Parallel processing out of box
* Architecture supports arbitrary commandline-tools


Example
=======

First of all you need to configure options for avconv command. Builder pattern allows to do it as simple as possible:

```java
final AVOptions options = AVOptions.create(inputFile, outputFile)
    .builders(
        AVMainOptions.create()
            .overwriteOutput(),
        AVVideoOptions.create()
            .proportionalResizeUsingWidth(800)
            .videoCodec(AVVideoCodecType.H264)
            .movFlags(AVMovFlagsType.FAST_START),
        AVAudioOptions.create()
            .audioCodec(AVAudioCodecType.VISUAL_ON_AAC)
            .audioBitRate(128),
        AVCodecOptions.create()
            .videoBitRate(1000)
            .audioChannelsCount(2)
            .sampleRate(11025)
    )
```

To execute avconv command with needed options you should use the class com.avconv4java.core.AVCommnad:

```java
// It'll be better to configure timeout always. Debug is useful sometimes.
final AVCommand command = AVCommand.create()
    .setDebug(true)
    .setTimeout(timeout);

final int returnCode = command.run(options);
final String outputFile = options.getOutputFile();

Logger.getGlobal().info(
    String.format("Output file: %s, return code: %d", outputFile, returnCode)
);

```

This command is equivalent to the following:


```bash
/usr/bin/avconv -i inputFile -y -vf scale=w=trunc(800/2)*2:h=trunc(ow/a/2)*2 -vcodec libx264 -movflags faststart -acodec libvo_aacenc -ab 128k -b 1000k -ac 2 -ar 11025 outputFile
```


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/vbauer/avconv4java/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
