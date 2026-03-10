package bai3.bai3_1;

public class XepLoaiService {
    /**
     * Phân loại học sinh dựa trên điểm trung bình và trạng thái thi lại.
     * 
     * @param diemTB   Điểm trung bình (0-10)
     * @param coThiLai Trạng thái thi lại (true/false)
     * @return Xếp loại tương ứng
     */
    public static String xepLoai(int diemTB, boolean coThiLai) {
        if (diemTB < 0 || diemTB > 10) {
            return "Diem khong hop le";
        }

        if (diemTB >= 8.5) {
            return "Gioi";
        } else if (diemTB >= 7.0) {
            return "Kha";
        } else if (diemTB >= 5.5) {
            return "Trung Binh";
        } else {
            if (coThiLai) {
                return "Thi lai";
            }
            return "Yeu - Hoc lai";
        }
    }
}
