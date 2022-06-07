public class Tourist {
    private String name;
    private Voucher voucher;

    public Tourist() { }

    public Tourist(String name, Voucher voucher) {
        this.name = name;
        this.voucher = voucher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "name='" + name + '\'' +
                ", voucher=" + voucher +
                '}';
    }
}
