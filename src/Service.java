import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public static void sortType(Voucher[] vouchers) {
        Arrays.sort(vouchers, Voucher.typeComparator);
    }

    public static void sortPrice(Voucher[] vouchers) {
        Arrays.sort(vouchers, Voucher.priceComparator);
    }

    public static void sortTransport(Voucher[] vouchers) {
        Arrays.sort(vouchers, Voucher.transportComparator);
    }

    public static void sortNutrition(Voucher[] vouchers) {
        Arrays.sort(vouchers, Voucher.nutritionComparator);
    }

    public static void sortNumberOfDays(Voucher[] vouchers) {
        Arrays.sort(vouchers, Voucher.numberOfDaysComparator);
    }

    public static Voucher[] quickSearch(String type, String price, String transport, String nutrition, String numberOfDays, Voucher[] vouchers) {
        List<Voucher> result;
        if (type.equals("-")) {
            result = Arrays.asList(vouchers);
        } else {
            result = Arrays.stream(vouchers).filter(x -> x.getType().equals(type)).collect(Collectors.toList());
        }

        if (!price.equals("-")) {
            try {
                int priceInt = Integer.parseInt(price);
                result = result.stream().filter(x -> x.getPrice() < priceInt).collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!transport.equals("-")) {
            result = result.stream().filter(x -> x.getTransport().equals(transport)).collect(Collectors.toList());
        }

        if (!nutrition.equals("-")) {
            try {
                int nutritionInt = Integer.parseInt(nutrition);
                result = result.stream().filter(x -> x.getNutrition() == nutritionInt).collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!numberOfDays.equals("-")) {
            try {
                int numberOfDaysInt = Integer.parseInt(numberOfDays);
                result = result.stream().filter(x -> x.getNumberOfDays() == numberOfDaysInt).collect(Collectors.toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Voucher[] newVouchers = new Voucher[result.size()];
        for (int i = 0; i < result.size(); i++) {
            newVouchers[i] = result.get(i);
        }

        return newVouchers;
    }
}
