package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }
    //метод сериализации объекта студент в json
    public static String serializationStudent(Student student){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(student);
        return json;
    }

    //метод сериализации объекта университет в json
    public static String serializationUniversity(University university){
        //без создания объекта gson
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    //метод десериализации студентов
    public static Student studentFromJson(String studentJson){
        //создаем объект gson вызываем метод для перевода из json в объект класса студент
        return new Gson().fromJson(studentJson, Student.class);
    }

    //метод десериализации университета
    public static University universityFromJson(String universityJson){
        return new Gson().fromJson(universityJson, University.class);
    }

    //метод сериализации коллекции студентов в json
    public static String studentListToJson(List<Student> students){
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);//toJson(students);
    }

    //метод сериализации коллекции университетов в json
    public static String universityListToJaon(List<University> universities){
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    //метод десериализации коллекции студентов из json
    public static List<Student> studentListFromJson(String studentListJson){
        //создаем объект gson
        Gson gson = new Gson();
        //создаем объект list
        Type studentList = new TypeToken<List<Student>>(){}.getType();
        return  gson.fromJson(studentListJson, studentList);
    }

    //метод десериализации коллекции университетов
    public static List<University> universityListFromJson(String universityListJson){
        //сразу все в возврате метода
        return new Gson().fromJson(universityListJson, new TypeToken<List<University>>(){}.getType());
    }

}
