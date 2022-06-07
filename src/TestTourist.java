import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTourist {
    public static void main(String[] args) {
        Voucher[] vouchers = {new Voucher("Отдых", 100, "самолет", 3, 14),
                new Voucher("Отдых", 200, "самолет", 3, 18),
                new Voucher("Оздоровление", 300, "автобус", 1, 21),
                new Voucher("Отдых", 50, "самолет", 3, 17),
                new Voucher("Отдых", 100, "самолет", 1, 14),
                new Voucher("Экскурсия", 300, "автобус", 3, 3),
                new Voucher("Круиз", 100, "катер", 3, 3),
                new Voucher("Круиз", 200, "катер", 1, 7)};

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Tourist tourist = choose(vouchers, reader);
            System.out.println(tourist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Tourist choose(Voucher[] vouchers, BufferedReader reader) {
        Tourist tourist = null;
        Voucher[] original = vouchers;
        printVouchers(vouchers);
        while (true) {
            boolean chosen = false;
            System.out.println("0 - отсортировать текущий список по тиу путевки");
            System.out.println("1 - отсортировать текущий список по цене");
            System.out.println("2 - отсортировать текущий список по транспорту");
            System.out.println("3 - отсортировать текущий список по питанию");
            System.out.println("4 - отсортировать текущий список по количеству дней");
            System.out.println("5 - быстрый поиск");
            System.out.println("6 - сброс");
            System.out.println("7 - сделать выбор");
            System.out.println("Другой символ - выход");
            int num = 8;
            try {
                num = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
            switch (num) {
                case (0) -> {
                    Service.sortType(vouchers);
                    printVouchers(vouchers);
                }
                case (1) -> {
                    Service.sortPrice(vouchers);
                    printVouchers(vouchers);
                }
                case (2) -> {
                    Service.sortTransport(vouchers);
                    printVouchers(vouchers);
                }
                case (3) -> {
                    Service.sortNutrition(vouchers);
                    printVouchers(vouchers);
                }
                case (4) -> {
                    Service.sortNumberOfDays(vouchers);
                    printVouchers(vouchers);
                }
                case (5) -> {
                    vouchers = dateForQuickSearch(vouchers, reader);
                    if (vouchers == null || vouchers.length == 0) {
                        System.out.println("Таких путевок нет");
                        vouchers = original;
                    } else {
                        printVouchers(vouchers);
                    }
                }
                case (6) -> {
                    vouchers = original;
                    printVouchers(vouchers);
                }
                case (7) -> {
                    tourist = makeChoice(vouchers, reader);
                    if (tourist != null) {
                        chosen = true;
                    } else {
                        printVouchers(vouchers);
                    }
                }
                default -> {chosen = true;}
            }
            if (chosen) {
                break;
            }
        }
        return tourist;
    }

    public static Tourist makeChoice(Voucher[] vouchers, BufferedReader reader) {
        Tourist tourist = null;
        try {
            System.out.println("Номер путевки, которую вы выбрали");
            int number = Integer.parseInt(reader.readLine()) - 1;
            if (number > vouchers.length - 1 && number < vouchers.length + 1) {
                System.out.println("Такой путевки нет");
                return null;
            }
            System.out.println("Введите ваше имя");
            String name = reader.readLine();
            tourist = new Tourist(name, vouchers[number]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tourist;
    }

    public static void printVouchers(Voucher[] vouchers) {
        for (int i = 0; i < vouchers.length; i++) {
            System.out.printf("№%d Тип: %s Стоимость: %d$ Транспорт: %s Питание: %d-x разовое Кол-во дней: %d\n",
                    i + 1, vouchers[i].getType(), vouchers[i].getPrice(), vouchers[i].getTransport(),
                    vouchers[i].getNutrition(), vouchers[i].getNumberOfDays());
        }
    }

    public static Voucher[] dateForQuickSearch(Voucher[] vouchers, BufferedReader reader) {
        try {
            System.out.println("Напишите название страны либо -");
            String type = reader.readLine();
            System.out.println("Напишите цену ниже которой хотите видеть предложения либо -");
            String price = reader.readLine();
            System.out.println("Напишите тип транспорта либо -");
            String transport = reader.readLine();
            System.out.println("Напишите сколько разовое питание (1, 2, 3...) либо -");
            String nutrition = reader.readLine();
            System.out.println("Напишите количество дней либо -");
            String numberOfDays = reader.readLine();
            return Service.quickSearch(type, price, transport, nutrition, numberOfDays, vouchers);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return null;
    }
}
