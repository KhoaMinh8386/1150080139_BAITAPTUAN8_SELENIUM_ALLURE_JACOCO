package bai6;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp kiểm thử cho OrderProcessor tích hợp Allure và JaCoCo.
 * Mục tiêu: Đạt >= 90% Branch Coverage và báo cáo trực quan.
 */
@Feature("Order Processing")
public class OrderProcessorTest {
    private final OrderProcessor processor = new OrderProcessor();

    private List<Item> createItems(double... prices) {
        List<Item> items = new ArrayList<>();
        for (double p : prices) {
            items.add(new Item(p));
        }
        return items;
    }

    @Test(description = "P1: Giỏ hàng bị null")
    @Story("Xử lý ngoại lệ")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Xác minh IllegalArgumentException khi danh sách items là null (D1-True branch 1).")
    public void testP1_NullCart() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            processor.calculateTotal(null, null, "NORMAL", "COD");
        });
    }

    @Test(description = "P1: Giỏ hàng trống")
    @Story("Xử lý ngoại lệ")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Xác minh IllegalArgumentException khi danh sách items rỗng (D1-True branch 2).")
    public void testP1_EmptyCart() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            processor.calculateTotal(new ArrayList<>(), null, "NORMAL", "COD");
        });
    }

    @Test(description = "P2: Khách hàng thường, không coupon, đơn hàng lớn")
    @Story("Tính tổng tiền cơ bản")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Xác minh tính toán khi không có giảm giá và không tính phí ship (Total >= 500k).")
    public void testP2_NormalNoCouponHighTotal() {
        double result = processor.calculateTotal(createItems(600000), null, "NORMAL", "COD");
        Assert.assertEquals(result, 600000.0);
    }

    @Test(description = "P3: Sử dụng coupon SALE10")
    @Story("Coupon Discount")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Xác minh áp dụng giảm giá 10% cho mã SALE10.")
    public void testSale10Coupon() {
        double result = processor.calculateTotal(createItems(500000), "SALE10", "NORMAL", "COD");
        Assert.assertEquals(result, 450000.0 + 20000.0); // 450k (<500k) + 20k ship
    }

    @Test(description = "P4: Sử dụng coupon SALE20")
    @Story("Coupon Discount")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Xác minh áp dụng giảm giá 20% cho mã SALE20.")
    public void testSale20Coupon() {
        double result = processor.calculateTotal(createItems(600000), "SALE20", "NORMAL", "COD");
        Assert.assertEquals(result, 480000.0 + 20000.0); // 480k (<500k) + 20k ship
    }

    @Test(description = "P5: Mã coupon không hợp lệ")
    @Story("Xử lý ngoại lệ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Xác minh ném lỗi khi nhập mã giảm giá sai.")
    public void testInvalidCoupon() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            processor.calculateTotal(createItems(100000), "INVALID", "NORMAL", "COD");
        });
    }

    @Test(description = "P6: Khách hàng GOLD")
    @Story("Member Discount")
    @Severity(SeverityLevel.NORMAL)
    @Description("Xác minh giảm giá 5% cho thành viên GOLD.")
    public void testGoldMember() {
        double result = processor.calculateTotal(createItems(600000), null, "GOLD", "COD");
        Assert.assertEquals(result, 570000.0);
    }

    @Test(description = "P7: Khách hàng PLATINUM")
    @Story("Member Discount")
    @Severity(SeverityLevel.NORMAL)
    @Description("Xác minh giảm giá 10% cho thành viên PLATINUM.")
    public void testPlatinumMember() {
        double result = processor.calculateTotal(createItems(1000000), null, "PLATINUM", "COD");
        Assert.assertEquals(result, 900000.0);
    }

    @Test(description = "P8: Đơn hàng nhỏ, thanh toán Online (Ship 30k)")
    @Story("Tính phí vận chuyển")
    @Severity(SeverityLevel.MINOR)
    @Description("Xác minh phí ship 30,000đ cho đơn hàng < 500k và không phải COD.")
    public void testShippingOnline() {
        double result = processor.calculateTotal(createItems(300000), null, "NORMAL", "ONLINE");
        Assert.assertEquals(result, 330000.0);
    }

    @Test(description = "P9: Đơn hàng nhỏ, thanh toán COD (Ship 20k)")
    @Story("Tính phí vận chuyển")
    @Severity(SeverityLevel.MINOR)
    @Description("Xác minh phí ship 20,000đ cho đơn hàng < 500k và thanh toán COD.")
    public void testShippingCod() {
        double result = processor.calculateTotal(createItems(100000), null, "NORMAL", "COD");
        Assert.assertEquals(result, 120000.0);
    }
}
