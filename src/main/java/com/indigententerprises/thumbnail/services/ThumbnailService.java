package com.indigententerprises.thumbnail.services;

import com.indigententerprises.thumbnail.domain.ImageData;

import java.io.IOException;
import java.io.InputStream;

public interface ThumbnailService {
    public ImageData resizeImage(
            final InputStream inputStream,
            final int targetWidth,
            final String type
    ) throws IOException;
}
