package comparator;

import model.University;

public class UniversityYearOfFoundationComparator implements UniversityComparator{
    //задача 2
    @Override
    public int compare(University o1, University o2){
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
