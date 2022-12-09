package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

// Класс строитель объекта "Ноутбук"
public class LaptopBLBuilder {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Company сompany;

    // Конструктор
    public LaptopBLBuilder(Ram ram, Company сompany) {
        this.ram = ram;
        this.сompany = сompany;
    }

    // Создание объекта "Ноутбук"
    public LaptopBL build() {
        LaptopBL laptop = new LaptopBL();
        laptop.setRam(this.ram);
        laptop.setCompany(this.сompany);
        return laptop;
    }
}