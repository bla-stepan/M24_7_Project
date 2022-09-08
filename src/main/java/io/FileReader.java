package io;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
класс, отвечающий за чтение файла и создание из него коллекций студентов и университетов
 */
public class FileReader {
    //private final String fileName = "src/main/resources/universityInfo.xlsx";

    //метод чтения файла для студентов
    public static List<Student> readerFileStudent(String fileName) throws IOException {
        //создаем список студентов
        List<Student> students = new ArrayList<>();

        /* Создаём экземпляр класса XSSFWorkbook, передав его конструктору на вход стрим файла.
        Для файлов XLS (более старый формат) используется аналогичный класс HSSFWorkbook.
        Здесь Workbook — это сам документ Excel, его представление как объекта.*/
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));

        /* Надо получить страницу/лист. Для этого используем метод workbook.getSheet(имя_страницы).
        Метод возвращает экземпляр класса XSSFSheet (либо HSSFSheet, если мы работаем с XLS).
        Этот класс — представление конкретного листа из файла Excel.
        Можно получать листы как по их индексу (порядковый номер), так и по названию листа.*/
        XSSFSheet sheet = workbook.getSheet("Студенты");//индекс 1

        /*С листом мы работаем при помощи итератора. Создаём итератор, который перебирает строки нашего листа.
        Например, sheet.iterator().*/
        Iterator<Row> rows = sheet.iterator();

        /*Если в файле есть заголовок, нам надо его пропустить. Для этого достаточно просто вызвать iterator.next()
        перед тем, как мы будем обрабатывать информацию внутри цикла.*/
        rows.next();

        //Затем в цикле while перебираем строки, предоставляемые итератором (экземпляры класса Row).
        while (rows.hasNext()){
            Row currentRow = rows.next();//задаем текущую строку
            Student student = new Student();//создаем объект класса студент
            students.add(student);//Добавляем в список студентов объект студента (с пустыми параментрами пока)
            /*Строки, очевидно, содержат в себе ячейки таблицы — элементы класса Cell.
            Взятие ячейки из строки происходит с помощью метода row.getCell() по индексу ячейки.
            Для получения значения из ячейки существует ряд методов, позволяющий прочитать значения различных типов.
            Например, getNumericCellValue(), getStringCellValue().*/
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());//возвращаем строковое значение
            student.setFullName(currentRow.getCell(1).getStringCellValue());//возвращаем значение
            student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());//сделано приведение к интовой переменной
            student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());//применено приведение к флоатовой переменной
        }

        return students;//вернули коллекцию студентов
    }
    //Пишем тот же метод для университетов
    public static List<University> readerFileUniversity(String fileName) throws IOException{
        List<University> universities = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
        XSSFSheet sheet = workbook.getSheet("Университеты");
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()){
            Row currentRow = rows.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
            //выводим отдельно класс енум
            university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }
        return universities;
    }
}

