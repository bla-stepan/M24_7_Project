package io;

import model.Information;
import util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    5. Создать класс, отвечающий за запись JSON-файлов из Java-классов. В этом классе должен быть метод, принимающий на вход
созданную в п.1 классовую структуру. Затем этот метод выполняет сериализацию входных данных в JSON-строки и записывает
в файлы .json. Рекомендуется с помощью Java-кода создать директорию и в неё складывать генерируемые файлы. Например,
jsonReqs/req.json.
 */
public class JsonWriter {

    public JsonWriter() {
    }

    public static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public static void createJsonReq(Information information) {

        logger.log(Level.INFO, "запись json запущена успешно");
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Папка для файлов создана");
        } catch (IOException e) {
            logger.log(Level.FINE, "Папка для файлов уже существует", e);
        }
        getStudentsJson(information);
        getUniversityJson(information);
        getStatisticsJson(information);

        logger.log(Level.INFO, "Json создан");
    }

    public static void getStudentsJson(Information information) {
        String studentsJson = JsonUtil.listToJson(information.getStudents());
        try {
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/students" + information.getDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ошибка создания studentsJson", e);
        }
    }

    public static void getUniversityJson(Information information) {
        String universityJson = JsonUtil.listToJson(information.getUniversities());
        try {
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/universities" + information.getDate().getTime() + ".json");
            outputStream.write(universityJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ошибка создания universityJson", e);
        }
    }

    public static void getStatisticsJson(Information information) {
        String statisticsJson = JsonUtil.listToJson(information.getStatistics());
        try {
            FileOutputStream outputStream = new FileOutputStream("jsonReqs/statistics" + information.getDate().getTime() + ".json");
            outputStream.write(statisticsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ошибка создания statisticsJson", e);
        }
    }
}
