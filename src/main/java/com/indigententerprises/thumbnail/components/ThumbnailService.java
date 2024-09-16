package com.indigententerprises.thumbnail.components;

import com.indigententerprises.thumbnail.domain.ImageData;

import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ThumbnailService implements com.indigententerprises.thumbnail.services.ThumbnailService {

    private final double quality;

    public ThumbnailService(final double quality) {
        this.quality = quality;
    }

    @Override
    public ImageData resizeImage(final InputStream inputStream, final int targetWidth, final String type) throws IOException {
        final BufferedImage originalImage = ImageIO.read(inputStream);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            Thumbnails.of(originalImage)
                    .width(targetWidth)
                    .outputFormat(type)
                    .outputQuality(this.quality)
                    .toOutputStream(byteArrayOutputStream);

            final byte [] data = byteArrayOutputStream.toByteArray();
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

            try {
                final BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
                final ImageData result = new ImageData(bufferedImage, data.length);
                return result;
            } finally {
                byteArrayInputStream.close();
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }
}
