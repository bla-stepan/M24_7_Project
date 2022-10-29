package model;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")//Указывает, что это корневой класс XML-структуры. Параметр name задаёт имя, которое будет использовано для этого уровня структуры в XML.
@XmlAccessorType(XmlAccessType.FIELD)//параметр указывает, что является элементами XML-структуры (поля, геттеры/сеттеры и т.д.).
public class Information {

    //студенты
    @XmlElementWrapper(name = "studentsInfo")//ставится, над полем-коллекцией в классе, указывает, что элементы коллекции должны быть обёрнуты внутрь структуры с указанным именем.
    @XmlElement(name = "studentEntry")//ставится над полями класса, указывает их имена для XML-структуры.
    private List<Student> students;

    //ВУЗы
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universities;

    //статитстика
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statistics;

    @XmlElement(name = "processedAt")
    private Date date;

    //конструктор
    public Information() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public Information setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public Information setUniversities(List<University> universities) {
        this.universities = universities;
        return this;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public Information setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Information setDate(Date date) {
        this.date = date;
        return this;
    }
}
