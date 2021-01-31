package shelter;

import animals.Animal;

import java.util.Date;

public class ShelteredAnimal {

    private final Animal animal;
    private final Date admissionDate;
    private final Integer admissionNumber;

    public ShelteredAnimal(Animal animal, Date admissionDate, Integer admissionNumber) {
        this.animal = animal;
        this.admissionDate = admissionDate;
        this.admissionNumber = admissionNumber;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public Integer getAdmissionNumber() {
        return this.admissionNumber;
    }
}
