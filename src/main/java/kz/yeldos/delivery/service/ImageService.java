package kz.yeldos.delivery.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Service
public class ImageService {
    private static final String bucket =  "/media";
    private static final String subFolder = "/dbImages";

    @SneakyThrows
    public String upload(String imagePath, InputStream content){
        Path fullImagePath = Path.of("."+subFolder,imagePath);
        try (content){
            Files.createDirectories(fullImagePath.getParent());
            Files.write(fullImagePath, content.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }

        return Path.of(bucket+subFolder, imagePath).toString();
    }

}