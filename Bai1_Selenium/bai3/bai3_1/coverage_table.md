# Báo cáo kiểm thử Xếp Loại (Bài 3.1)

## 1. Bảng kiểm thử độ phủ nhánh (Branch Coverage)

| TC | diemTB | coThiLai | Expected | Nhánh được phủ (Branch Covered) |
|---|---|---|---|---|
| 01 | -1 | false | "Diem khong hop le" | Node 2 (diemTB < 0) -> True |
| 02 | 11 | false | "Diem khong hop le" | Node 2 (diemTB > 10) -> True |
| 03 | 9 | false | "Gioi" | Node 3 (diemTB >= 8.5) -> True |
| 04 | 7 | false | "Kha" | Node 4 (diemTB >= 7.0) -> True |
| 05 | 6 | false | "Trung Binh" | Node 5 (diemTB >= 5.5) -> True |
| 06 | 4 | true | "Thi lai" | Node 6 (coThiLai) -> True |
| 07 | 5 | false | "Yeu - Hoc lai" | Node 6 (coThiLai) -> False |

## 2. Giải thích Coverage

*   **Statement Coverage**: Đảm bảo mọi câu lệnh trong mã nguồn được thực thi ít nhất một lần.
*   **Branch Coverage**: Đảm bảo mọi kết quả của một quyết định (True/False của các câu lệnh IF) đều được thực thi ít nhất một lần. Branch Coverage bao hàm Statement Coverage.

## 3. Mô tả CFG (Control Flow Graph)

*   **Node 1**: Start - Nhận vào diemTB, coThiLai.
*   **Node 2**: Kiểm tra `diemTB < 0 || diemTB > 10`.
    *   *True*: Trả về "Diem khong hop le".
    *   *False*: Chuyển đến Node 3.
*   **Node 3**: Kiểm tra `diemTB >= 8.5`.
    *   *True*: Trả về "Gioi".
    *   *False*: Chuyển đến Node 4.
*   **Node 4**: Kiểm tra `diemTB >= 7.0`.
    *   *True*: Trả về "Kha".
    *   *False*: Chuyển đến Node 5.
*   **Node 5**: Kiểm tra `diemTB >= 5.5`.
    *   *True*: Trả về "Trung Binh".
    *   *False*: Chuyển đến Node 6.
*   **Node 6**: Kiểm tra `coThiLai`.
    *   *True*: Trả về "Thi lai".
    *   *False*: Trả về "Yeu - Hoc lai".
