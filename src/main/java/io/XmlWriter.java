package io;

import model.Information;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Создать класс, отвечающий за запись XML-файлов из Java-класса. В этом классе должен быть метод, принимающий на
вход созданную в п.1 классовую структуру. Затем этот метод выполняет маршаллинг входных параметров и записывает
в файл .xml. Рекомендуется с помощью Java-кода создать директорию и в неё складывать генерируемые файлы. Например, xmlReqs/req.xml.
 */
public class XmlWriter {
    //логируем стар программы
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    public XmlWriter() {
    }

    public static void createXmlReqs(Information information) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMMM dd");
        String date = dateFormat.format(Calendar.getInstance());

        try {
            //логируем начало преобразования класса в XML
            logger.log(Level.INFO, "процесс преобразования класса Information в XML (маршаллинг) запущен");
            JAXBContext jaxbContext = JAXBContext.newInstance(Information.class);
            //создаем маршалинг
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //создаем дирректорию, куда будем грузить файл
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                //логируем создание папки
                logger.log(Level.INFO, "Папка для файлов создана");
            } catch (IOException e) {
                //ошибка создания - папка есть логируем
                logger.log(Level.INFO, "Папка для файлов уже существует", e);
            }
            //создаем объект файла и логируем
            logger.log(Level.INFO, "старт создания файла");
            File file = new File("xmlReqs/Req" + date + ".xml");
            marshaller.marshal(information, file);
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, "Ошибка создания файла XML", e);
        }
        //логируем завершение процесса маршаллинга
        logger.log(Level.INFO, "процесс маршаллинга завершен успешно");
    }
}
