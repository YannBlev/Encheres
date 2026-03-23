package org.eni.encheres.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileArticleService {

    private final Path uploadDir = Paths.get("uploads/");

    public String save(MultipartFile file) throws IOException {
        if (file.isEmpty()) return null;

        try {
            // Vérifier que le dossier n'est pas existant
            Files.createDirectories(uploadDir);

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path target = uploadDir.resolve(fileName);
            Files.write(target, file.getBytes());
            return "/uploads/" + fileName;
        } catch (Exception e) {
            System.out.println("Changer le message");
        }

        return null;
    }
}