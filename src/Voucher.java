import java.util.Comparator;

public class Voucher {
    private String type;
    private int price;
    private String transport;
    private int nutrition;
    private int numberOfDays;

    public Voucher() { }

    public Voucher(String type, int price, String transport, int nutrition, int numberOfDays) {
        this.type = type;
        this.price = price;
        this.transport = transport;
        this.nutrition = nutrition;
        this.numberOfDays = numberOfDays;
    }

    public static final Comparator<Voucher> typeComparator = Comparator.comparing(Voucher::getType);

    public static final Comparator<Voucher> priceComparator = Comparator.comparing(Voucher::getPrice);

    public static final Comparator<Voucher> transportComparator = Comparator.comparing(Voucher::getTransport);

    public static final Comparator<Voucher> nutritionComparator = Comparator.comparing(Voucher::getNutrition);

    public static final Comparator<Voucher> numberOfDaysComparator = Comparator.comparing(Voucher::getNumberOfDays);

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getNutrition() {
        return nutrition;
    }

    public void setNutrition(int nutrition) {
        this.nutrition = nutrition;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", transport='" + transport + '\'' +
                ", nutrition='" + nutrition + '\'' +
                ", numberOfDays=" + numberOfDays +
                '}';
    }
}