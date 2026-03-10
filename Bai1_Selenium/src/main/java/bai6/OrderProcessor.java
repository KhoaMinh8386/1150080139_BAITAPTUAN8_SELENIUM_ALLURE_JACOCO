package bai6;

import java.util.List;

public class OrderProcessor {
    /**
     * Tính tổng tiền đơn hàng dựa trên danh sách sản phẩm, mã giảm giá, hạng thành
     * viên và phương thức thanh toán.
     * 
     * @param items         Danh sách sản phẩm (không được null hoặc rỗng)
     * @param couponCode    Mã giảm giá (SALE10, SALE20)
     * @param memberLevel   Hạng thành viên (NORMAL, GOLD, PLATINUM)
     * @param paymentMethod Phương thức thanh toán (COD hoặc khác)
     * @return Tổng số tiền phải thanh toán
     */
    public double calculateTotal(List<Item> items, String couponCode, String memberLevel, String paymentMethod) {
        if (items == null || items.isEmpty()) { // D1
            throw new IllegalArgumentException("Gio hang trong");
        }

        double subtotal = items.stream().mapToDouble(Item::getPrice).sum();
        double discount = 0;

        // Giảm giá theo coupon
        if (couponCode != null && !couponCode.isEmpty()) { // D2
            if (couponCode.equals("SALE10")) { // D3
                discount = subtotal * 0.10;
            } else if (couponCode.equals("SALE20")) { // D4
                discount = subtotal * 0.20;
            } else {
                throw new IllegalArgumentException("Ma giam gia khong hop le");
            }
        }

        // Giảm giá theo thành viên
        double memberDiscount = 0;
        if (memberLevel.equals("GOLD")) { // D5
            memberDiscount = (subtotal - discount) * 0.05;
        } else if (memberLevel.equals("PLATINUM")) { // D6
            memberDiscount = (subtotal - discount) * 0.10;
        }

        double total = subtotal - discount - memberDiscount;

        // Phí ship if total < 500,000
        if (total < 500000) { // D7
            if (!paymentMethod.equals("COD")) { // D8
                total += 30000; // Online/Other
            } else {
                total += 20000; // COD
            }
        }

        return total;
    }
}
