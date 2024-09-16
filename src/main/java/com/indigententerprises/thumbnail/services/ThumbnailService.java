package com.indigententerprises.thumbnail.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public interface ThumbnailService {
    public BufferedImage resizeImage(
            final InputStream inputStream,
            final int targetWidth,
            final String type
    ) throws IOException;
}
