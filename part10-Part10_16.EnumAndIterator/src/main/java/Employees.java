import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Employees {
    private ArrayList<Person> persons;

    public Employees() {
        this.persons = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.persons.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        for (Person temp : peopleToAdd) {
            this.persons.add(temp);
        }
    }
        
    public void print() {
       for (Person temp : this.persons) {
            System.out.println(temp);
        }
    }

    public void print(Education education) {
        Iterator<Person> iterator = this.persons.iterator();

        while (iterator.hasNext()) {
            Person testPerson = iterator.next();
            if(testPerson.getEducation() == education) {
                System.out.println(testPerson);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = this.persons.iterator();

        while (iterator.hasNext()) {
            if(iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
