package tests;

import bai5.VayVonService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VayVonMCDCTest {

    @DataProvider(name = "loanCases")
    public Object[][] loanCases() {
        return new Object[][] {
                { 25, 12000000L, true, true, "TC1: Tất cả điều kiện đều thỏa mãn" },
                { 20, 12000000L, true, false, "TC2: Tuổi < 22 (A=False), các điều kiện khác thỏa mãn" },
                { 25, 8000000L, true, false, "TC3: Thu nhập < 10tr (B=False), các điều kiện khác thỏa mãn" },
                { 25, 12000000L, false, false, "TC4: Không có tài sản (C=False), các điều kiện khác thỏa mãn" }
        };
    }

    @Test(dataProvider = "loanCases", description = "Kiểm thử MC/DC cho logic xét duyệt vay vốn")
    public void testVayVonMCDC(int tuoi, long thuNhap, boolean coTaiSan, boolean expected, String description) {
        boolean actual = VayVonService.checkDuocVay(tuoi, thuNhap, coTaiSan);
        Assert.assertEquals(actual, expected, "Lỗi tại " + description);
    }

    @Test(description = "MC/DC - Điều kiện Tuổi (A) ảnh hưởng độc lập (So sánh TC1 vs TC2)")
    public void testMCDC_TuoiDocLap_A() {
        // TC1: TTT -> True
        boolean tc1 = VayVonService.checkDuocVay(25, 12000000, true);
        // TC2: FTT -> False
        boolean tc2 = VayVonService.checkDuocVay(20, 12000000, true);

        Assert.assertTrue(tc1, "TC1 (25 tuổi) phải được duyệt vay");
        Assert.assertFalse(tc2, "TC2 (20 tuổi) phải bị từ chối (Tuổi chưa đủ)");
    }

    @Test(description = "MC/DC - Điều kiện Thu nhập (B) ảnh hưởng độc lập (So sánh TC1 vs TC3)")
    public void testMCDC_ThuNhapDocLap_B() {
        // TC1: TTT -> True
        boolean tc1 = VayVonService.checkDuocVay(25, 12000000, true);
        // TC3: TFT -> False
        boolean tc3 = VayVonService.checkDuocVay(25, 8000000, true);

        Assert.assertTrue(tc1, "TC1 (Thu nhập 12tr) phải được duyệt vay");
        Assert.assertFalse(tc3, "TC3 (Thu nhập 8tr) phải bị từ chối (Thu nhập thấp)");
    }

    @Test(description = "MC/DC - Điều kiện Tài sản (C) ảnh hưởng độc lập (So sánh TC1 vs TC4)")
    public void testMCDC_TaiSanDocLap_C() {
        // TC1: TTT -> True
        boolean tc1 = VayVonService.checkDuocVay(25, 12000000, true);
        // TC4: TTF -> False
        boolean tc4 = VayVonService.checkDuocVay(25, 12000000, false);

        Assert.assertTrue(tc1, "TC1 (Có tài sản) phải được duyệt vay");
        Assert.assertFalse(tc4, "TC4 (Không tài sản) phải bị từ chối");
    }
}
