package ru.lid.servlet.service;


import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.lid.servlet.util.PropertiesUtil;

import javax.swing.text.html.Option;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ImageService {

    private static final ImageService INSTANCE = new ImageService();
    private final String basePath = PropertiesUtil.get("image.base.url");

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent) {
        var imageFullPath = Path.of(basePath, imagePath);

        try (imageContent) {
            //image.base.url/users/image.png - ???? ??????? ??? ??????????, ??? ?? image.png
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath, imageContent.readAllBytes(), StandardOpenOption.CREATE,  StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

    public static ImageService getINSTANCE() {
        return INSTANCE;
    }

    @SneakyThrows
    public Optional<InputStream> get(String imagePath) {
        var imageFullPath = Path.of(basePath, imagePath);

        return Files.exists(imageFullPath)
                ? Optional.of(Files.newInputStream(imageFullPath))
                : Optional.empty();
    }
}
