package org.example.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Main.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("20250529.pdf")).getFile());
        File converted = PdfConvertUtil.mergePdfPAgesToSingleImage(file, 150);
        converted.getParentFile().mkdirs(); // 폴더 없으면 생성
        System.out.println(converted.getName() + " converted to " + converted.getAbsolutePath());

        // 복사
        Files.copy(converted.toPath(), converted.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

}
