package comparator;

import enums.StudyProfile;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityMainProfileComparator implements UniversityComparator{
// задача 2
    @Override
    public int compare(University o1, University o2){
        //если поле (профиль) какого либо объекта класса университет не указан
//        if (o1.getMainProfile() == null){
//            return 1;
//        } else if (o2.getMainProfile()==null){
//            return -1;
//        }
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());//к геттерам добавочный метод name класс enum
    }
}
