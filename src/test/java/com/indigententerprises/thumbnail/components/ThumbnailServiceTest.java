package com.indigententerprises.thumbnail.components;

import com.indigententerprises.thumbnail.domain.ImageData;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.core.io.ClassPathResource;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ThumbnailServiceTest {

    @Test
    public void test() throws IOException {

        final ThumbnailService systemUnderTest = new ThumbnailService(0.90);
        final ClassPathResource classPathResource = new ClassPathResource("space.jpg");
        final ImageData result = systemUnderTest.resizeImage(
                classPathResource.getInputStream(),
                200,
                "PNG"
        );

        final BufferedImage bufferedImage = result.bufferedImage;
        Assert.assertEquals(200, bufferedImage.getWidth());
    }
}
