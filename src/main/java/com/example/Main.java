package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Car;
import com.example.model.Driver;
import com.example.model.Engine;

/**
 * Демонстрационное консольное приложение для работы с классами
 * {@link Car}, {@link Driver} и {@link Engine}.
 * Выполняет задание варианта 5:
 * <ul>
 *     <li>вывод водителей со стажем более 5 лет;</li>
 *     <li>вывод автомобилей советского производства.</li>
 * </ul>
 *
 * @author Student
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создание водителей
        Driver driver1 = new Driver("Иванов Иван Иванович", 10);
        Driver driver2 = new Driver("Петров Пётр Петрович", 3);
        Driver driver3 = new Driver("Сидоров Сидор Сидорович", 7);
        Driver driver4 = new Driver("Кузнецов Алексей Николаевич", 2);
        Driver driver5 = new Driver("Смирнов Дмитрий Олегович", 12);

        // Создание моторов
        Engine engine1 = new Engine(120, "ВАЗ");
        Engine engine2 = new Engine(150, "Toyota");
        Engine engine3 = new Engine(90, "ВАЗ");
        Engine engine4 = new Engine(200, "BMW");
        Engine engine5 = new Engine(75, "ГАЗ");

        // Создание автомобилей
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ВАЗ-2107", "седан", 1050, driver1, engine1));
        cars.add(new Car("Toyota Camry", "седан", 1560, driver2, engine2));
        cars.add(new Car("ВАЗ-2110", "седан", 1020, driver3, engine3));
        cars.add(new Car("BMW X5", "внедорожник", 2200, driver4, engine4));
        cars.add(new Car("ГАЗ-3110", "седан", 1400, driver5, engine5));

        // Вывод всех автомобилей
        System.out.println("=== Список всех автомобилей ===");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();

        // Пункт 5: водители со стажем более 5 лет
        System.out.println("==== Водители со стажем более 5 лет ====");
        for (Car car : cars) {
            if (car.getDriver().getDrivingExperience() > 5) {
                System.out.println(car.getDriver().getFullName()
                        + " (стаж: " + car.getDriver().getDrivingExperience()
                        + " лет) - управляет " + car.getBrand());
            }
        }
        System.out.println();

        // Пункт 6: автомобили советского производства
        // Определяем советские марки по производителю двигателя
        // (упрощённо: ВАЗ, ГАЗ, ЗАЗ, Москвич и т.п.)
        System.out.println("==== Автомобили советского производства ====");
        for (Car car : cars) {
            String manufacturer = car.getEngine().getManufacturer();
            if (isSovietManufacturer(manufacturer)) {
                System.out.println(car.getBrand()
                        + " (мотор: " + manufacturer
                        + ", мощность: " + car.getEngine().getPower() + " л.с.)");
            }
        }
    }

    /**
     * Проверяет, является ли производитель двигателя советским
     * (или постсоветским, но исторически советским) предприятием.
     *
     * @param manufacturer название производителя
     * @return {@code true}, если производитель советский
     */
    private static boolean isSovietManufacturer(String manufacturer) {
        if (manufacturer == null) {
            return false;
        }
        String m = manufacturer.trim().toUpperCase();
        return m.equals("ВАЗ") || m.equals("ГАЗ") || m.equals("ЗАЗ")
                || m.equals("МОСКВИЧ") || m.equals("ИЖ")
                || m.equals("УАЗ") || m.equals("КАМАЗ");
    }
}