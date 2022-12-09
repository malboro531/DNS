package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

import java.io.Serializable;

// Класс "Ноутбук"
public class LaptopBL implements Serializable {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Company сompany;

    // Конструктор
    public LaptopBL(Ram ram, Company сompany) {
        this.ram = ram;
        this.сompany = сompany;
    }

    // Сеттеры и геттеры
    // Оперативная память
    public void setRam(Ram ram) {
        this.ram = ram;
    }
    public Ram getRam() {
        return this.ram;
    }

    // Производитель
    public void setCompany(Company сompany) {
        this.сompany = сompany;
    }
    public Company getCompany() {
        return this.сompany;
    }

}