package io;

import model.Statistics;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//пункт 2 задания 27.8
//Создать класс XlsWriter, в котором реализовать метод генерации таблицы и её записи в файл. Метод получает на вход
//коллекцию объектов статистики и путь к файлу.
public class XlsWriter {
    //путь к файлу
    //private final  String filePath ="src/main/resources/statisticsInfo.xlsx";
    //конструктор
    private XlsWriter() {
    }

    public static final Logger log = Logger.getLogger(XlsWriter.class.getName());

    //метод генерации таблицы
    public static void tableGenerator(List<Statistics> statisticsList, String filePath) throws IOException {
        //логг при создании файла
        log.log(Level.INFO, "Начало создания файла статистики");

        XSSFWorkbook workbook = new XSSFWorkbook();//создали книгу
        XSSFSheet statisticSheet = workbook.createSheet("Статистика");//создаем лист
        //создаем параметры шрифта заголовка (Шрифт создаётся методом createFont(), экземпляр этого класса заполняется желаемыми значениями.)
        Font fontHeader = workbook.createFont();
        fontHeader.setBold(true);//задаем жирный шрифт
        fontHeader.setFontHeightInPoints((short) 12);//устанавливаем размер шрифта
//        Font font = workbook.createFont();
//        font.setBold(false);
//        font.setFontHeight((short) 10);
        //Далее создаётся стиль методом createCellStyle(), которому можно задать созданный шрифт.
        CellStyle cellStyleHeader = workbook.createCellStyle();
        cellStyleHeader.setFont(fontHeader);//передаем созданный стиль
        /*Аналогично для листа имеется метод createRow(), для строки — метод createCell().
        Для использования стиля используется метод setCellStyle(), вызываемый у ячейки. */

        //создаем строку заглавную
        int rowNum = 0;
        Row rowHeader = statisticSheet.createRow(rowNum++);
        //создаем колонки
        Cell profile = rowHeader.createCell(0);//создаем столбец
        profile.setCellValue("Профиль образования");//задаем значение (название)
        profile.setCellStyle(cellStyleHeader);//задаем стиль

        //средний балл
        Cell avgExamScore = rowHeader.createCell(1);
        avgExamScore.setCellValue("Средний бал");
        avgExamScore.setCellStyle(cellStyleHeader);

        //количество студентов по профилю
        Cell numOfStudentsProf = rowHeader.createCell(2);
        numOfStudentsProf.setCellValue("Количество студентов по профилю");
        numOfStudentsProf.setCellStyle(cellStyleHeader);

        //Количество университетов по профилю
        Cell numOfUniversityProf = rowHeader.createCell(3);
        numOfUniversityProf.setCellValue("Количество университетов по профилю");
        numOfUniversityProf.setCellStyle(cellStyleHeader);

        //названия университетов.
        Cell universityName = rowHeader.createCell(4);
        universityName.setCellValue("Название университетов (сокращенно)");
        universityName.setCellStyle(cellStyleHeader);

        //4. реализовать заполнение строк таблицы данными, хранящимися в коллекции элементов Statistics.
//        int rowNum = 1;
        for (Statistics statistics : statisticsList) {
            Row row = statisticSheet.createRow(rowNum++);//создаем строку
            Cell profileRow = row.createCell(0);//создаем в строке столбец
            profileRow.setCellValue(statistics.getProfile().getProfileName());//передаем данные профиля и енум метод гет
            Cell avgExamScoreRow = row.createCell(1);
            avgExamScoreRow.setCellValue(statistics.getAvgExamScore());
            Cell numOfStudentsProfRow = row.createCell(2);
            numOfStudentsProfRow.setCellValue(statistics.getNumOfStudentsProf());
            Cell numOfUniversityProfRow = row.createCell(3);
            numOfUniversityProfRow.setCellValue(statistics.getNumOfUniversityProf());
            Cell universityNameRow = row.createCell(4);
            universityNameRow.setCellValue(statistics.getUniversityName());
        }
        //Чтобы создать файл по сгенерированной книге, нужно вызвать у книги метод write() и передать ему поток FileOutputStream.
        //логг длля обработки исключения
        try {
            workbook.write(new FileOutputStream(filePath));
        } catch (IOException e) {
            log.log(Level.SEVERE, "Возникла проблема с записью в файл (" + filePath + ")", e);
        }
        log.log(Level.INFO, "Запись в файл " + filePath + " успешно завершена");
    }
}
