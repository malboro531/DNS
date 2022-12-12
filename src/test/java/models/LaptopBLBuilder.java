package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

// Класс строитель объекта "Ноутбук"
public class LaptopBLBuilder {
    // Оперативная память
    private Ram ram;
    // Производитель
    private Company company;

    // Конструктор
    public LaptopBLBuilder(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    // Создание объекта "Ноутбук"
    public LaptopBL build() {
        LaptopBL laptop = new LaptopBL();
        laptop.setRam(this.ram);
        laptop.setCompany(this.company);
        return laptop;
    }
}