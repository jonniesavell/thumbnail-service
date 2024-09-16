package com.indigententerprises.thumbnail.domain;

import java.awt.image.BufferedImage;

public class ImageData {

    public final BufferedImage bufferedImage;
    public final int size;

    public ImageData(
            final BufferedImage bufferedImage,
            final int size
    ) {
        this.bufferedImage = bufferedImage;
        this.size = size;
    }
}
