package bai3.bai3_2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TinhTienNuocTest {

    @Test
    public void testSoM3Zero() {
        Assert.assertEquals(TinhTienNuocService.tinhTienNuoc(0, "dan_cu"), 0.0, "Sai khi soM3 <= 0");
    }

    @Test
    public void testHoNgheo() {
        Assert.assertEquals(TinhTienNuocService.tinhTienNuoc(15, "ho_ngheo"), 15 * 5000.0,
                "Sai khi loaiKhachHang la ho_ngheo");
    }

    @Test
    public void testDanCuNhoHon10() {
        Assert.assertEquals(TinhTienNuocService.tinhTienNuoc(10, "dan_cu"), 10 * 7500.0,
                "Sai khi dan_cu va soM3 <= 10");
    }

    @Test
    public void testDanCuNhoHon20() {
        Assert.assertEquals(TinhTienNuocService.tinhTienNuoc(15, "dan_cu"), 15 * 9900.0,
                "Sai khi dan_cu va 10 < soM3 <= 20");
    }

    @Test
    public void testDanCuLonHon20() {
        Assert.assertEquals(TinhTienNuocService.tinhTienNuoc(25, "dan_cu"), 25 * 11400.0,
                "Sai khi dan_cu va soM3 > 20");
    }

    @Test
    public void testKinhDoanh() {
        Assert.assertEquals(TinhTienNuocService.tinhTienNuoc(10, "kinh_doanh"), 10 * 22000.0,
                "Sai khi loaiKhachHang khac ho_ngheo va dan_cu");
    }
}
