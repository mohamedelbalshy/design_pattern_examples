package FilterPattern;

import java.util.ArrayList;
import java.util.List;

enum Gender {
    Female,
    Male
}

enum MaritalStatus {
    Married,
    Single
}

class Person {
    private String name;
    private Gender gender;
    private MaritalStatus maritalStatus;

    public Person(String name, Gender gender, MaritalStatus maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

}

interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}

class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender() == Gender.Male) {
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}

class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if (person.getGender() == Gender.Female) {
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}

class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}

class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> firstCriteriaItems = criteria.meetCriteria(persons);
        List<Person> otherCriteriaItems = otherCriteria.meetCriteria(persons);

        for (Person person : firstCriteriaItems) {
            if (!otherCriteriaItems.contains(person)) {
                otherCriteriaItems.add(person);
            }
        }

        return otherCriteriaItems;
    }
}

public class FilternPattern {

    public static void main(String[] args) {

        Person person1 = new Person("Mohamed", Gender.Male, MaritalStatus.Married);
        Person person2 = new Person("Mona", Gender.Female, MaritalStatus.Married);

        List<Person> persons = new ArrayList<Person>();
        persons.add(person1);
        persons.add(person2);

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria OrCriteria = new OrCriteria(male, female);

        printPersons(male.meetCriteria(persons));

        printPersons(female.meetCriteria(persons));

        printPersons(OrCriteria.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {

        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }
}