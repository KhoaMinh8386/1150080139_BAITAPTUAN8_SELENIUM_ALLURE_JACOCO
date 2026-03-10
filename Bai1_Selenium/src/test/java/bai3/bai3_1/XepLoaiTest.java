package bai3.bai3_1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class XepLoaiTest {

    @Test
    public void testInvalidScoreMin() {
        Assert.assertEquals(XepLoaiService.xepLoai(-1, false), "Diem khong hop le", "Sai khi diem < 0");
    }

    @Test
    public void testInvalidScoreMax() {
        Assert.assertEquals(XepLoaiService.xepLoai(11, false), "Diem khong hop le", "Sai khi diem > 10");
    }

    @Test
    public void testXepLoaiGioi() {
        Assert.assertEquals(XepLoaiService.xepLoai(9, false), "Gioi", "Sai khi diem >= 8.5");
    }

    @Test
    public void testXepLoaiKha() {
        Assert.assertEquals(XepLoaiService.xepLoai(7, false), "Kha", "Sai khi 7.0 <= diem < 8.5");
    }

    @Test
    public void testXepLoaiTrungBinh() {
        Assert.assertEquals(XepLoaiService.xepLoai(6, false), "Trung Binh", "Sai khi 5.5 <= diem < 7.0");
    }

    @Test
    public void testXepLoaiThiLai() {
        Assert.assertEquals(XepLoaiService.xepLoai(4, true), "Thi lai", "Sai khi diem < 5.5 va co thilai");
    }

    @Test
    public void testXepLoaiYeu() {
        // Sử dụng 5.4 để kiểm tra nhánh False của các điều kiện trước đó và False của
        // coThiLai
        Assert.assertEquals(XepLoaiService.xepLoai(5, false), "Yeu - Hoc lai", "Sai khi diem < 5.5 va khong thilai");
    }
}
