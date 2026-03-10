# Báo cáo kiểm thử Tính Tiền Nước (Bài 3.2)

## 1. Bảng kiểm thử độ phủ nhánh (Branch Coverage)

| TC | soM3 | loaiKhachHang | Expected | Nhánh được phủ (Branch Covered) |
|---|---|---|---|---|
| 01 | 0 | "dan_cu" | 0 | soM3 <= 0 -> True |
| 02 | 15 | "ho_ngheo" | 75000 | loaiKhachHang.equals("ho_ngheo") -> True |
| 03 | 10 | "dan_cu" | 75000 | dan_cu (True) -> soM3 <= 10 (True) |
| 04 | 15 | "dan_cu" | 148500 | dan_cu (True) -> soM3 <= 20 (True) |
| 05 | 25 | "dan_cu" | 285000 | dan_cu (True) -> soM3 > 20 (Nhánh else) |
| 06 | 10 | "kinh_doanh" | 220000 | loaiKhachHang.equals("ho_ngheo") (False) -> dan_cu (False) |

## 2. Thống kê (Phạm vi hàm tinhTienNuoc)

*   **Tổng số câu lệnh (Statements)**: Khoảng 12-15 câu lệnh (tùy cách đếm).
*   **Tổng số nhánh (Branches)**: 6 nhánh chính (soM3<=0, ho_ngheo, dan_cu, dan_cu<=10, dan_cu<=20, else/kinh_doanh).

## 3. Giải thích CFG (Control Flow Graph)

*   **Bắt đầu**: Kiểm tra `soM3 <= 0`. Nếu True, thoát và trả về 0.
*   **Nhánh 1**: Nếu `loaiKhachHang == "ho_ngheo"`, gán giá 5000.
*   **Nhánh 2**: Nếu `loaiKhachHang == "dan_cu"`, đi vào kiểm tra sâu hơn về `soM3`:
    *   `soM3 <= 10`: Giá 7500.
    *   `soM3 <= 20`: Giá 9900.
    *   `soM3 > 20`: Giá 11400.
*   **Nhánh 3 (Else)**: Cho khách hàng khác, giá 22000.
*   **Kết thúc**: Tính tiền = soM3 * don_gia.
