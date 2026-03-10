package bai4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PhiShipBasisPathTest {

    @Test(description = "Path 1: Trọng lượng không hợp lệ")
    public void testPath1_InvalidWeight() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            PhiShipService.tinhPhiShip(-1, "noi_thanh", false);
        });
    }

    @Test(description = "Path 2: Nội thành, trọng lượng cân bằng, không là member")
    public void testPath2_NoiThanhNormalNoMember() {
        double actual = PhiShipService.tinhPhiShip(5, "noi_thanh", false);
        Assert.assertEquals(actual, 15000.0, 0.01, "Phí ship nội thành <= 5kg sai!");
    }

    @Test(description = "Path 3: Nội thành, vượt cân, là member")
    public void testPath3_NoiThanhOverweightMember() {
        double actual = PhiShipService.tinhPhiShip(6, "noi_thanh", true);
        Assert.assertEquals(actual, 15300.0, 0.01, "Phí ship nội thành > 5kg cho member sai!");
    }

    @Test(description = "Path 4: Ngoại thành, trọng lượng cân bằng, không là member")
    public void testPath4_NgoaiThanhNormalNoMember() {
        double actual = PhiShipService.tinhPhiShip(3, "ngoai_thanh", false);
        Assert.assertEquals(actual, 25000.0, 0.01, "Phí ship ngoại thành <= 3kg sai!");
    }

    @Test(description = "Path 5: Ngoại thành, vượt cân, là member")
    public void testPath5_NgoaiThanhOverweightMember() {
        double actual = PhiShipService.tinhPhiShip(4, "ngoai_thanh", true);
        Assert.assertEquals(actual, 25200.0, 0.01, "Phí ship ngoại thành > 3kg cho member sai!");
    }

    @Test(description = "Path 6: Vùng xa, trọng lượng cân bằng, không là member")
    public void testPath6_VungXaNormalNoMember() {
        double actual = PhiShipService.tinhPhiShip(2, "vung_xa", false);
        Assert.assertEquals(actual, 50000.0, 0.01, "Phí ship vùng xa <= 2kg sai!");
    }

    @Test(description = "Path 7: Vùng xa, vượt cân, là member")
    public void testPath7_VungXaOverweightMember() {
        double actual = PhiShipService.tinhPhiShip(3, "vung_xa", true);
        Assert.assertEquals(actual, 49500.0, 0.01, "Phí ship vùng xa > 2kg cho member sai!");
    }

    @Test(description = "Path 8: Nội thành, trọng lượng cân bằng, là member")
    public void testPath8_NoiThanhNormalMember() {
        double actual = PhiShipService.tinhPhiShip(5, "noi_thanh", true);
        Assert.assertEquals(actual, 13500.0, 0.01, "Phí ship nội thành member sai!");
    }
}
