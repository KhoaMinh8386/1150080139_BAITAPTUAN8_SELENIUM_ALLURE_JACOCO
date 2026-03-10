# 1150080139_BAITAPTUAN8_SELENIUM_ALLURE_JACOCO

Repository này chứa các bài tập từ **Bài 1 → Bài 7** của môn **Kiểm thử phần mềm**.  
Các bài tập bao gồm phân tích White-box Testing, viết Unit Test, Selenium Testing và tích hợp báo cáo kiểm thử.

---

# 📂 Cấu trúc thư mục dự án

```
1150080139_BAITAPTUAN8_SELENIUM_ALLURE_JACOCO
│
├── bai1_mcdc
│   └── Phân tích MC/DC cho các điều kiện logic
│
├── bai2_cfg
│   └── Xây dựng Control Flow Graph (CFG)
│
├── bai3_cyclomatic_complexity
│   └── Tính Cyclomatic Complexity
│
├── bai4_basis_path
│   └── Thiết kế Basis Path Testing
│
├── bai5_testng_unit_test
│   └── Viết Unit Test bằng TestNG
│
├── bai6_selenium_whitebox
│   ├── pages
│   │   └── TextBoxPage.java
│   │
│   └── tests
│       └── TextBoxWhiteBoxTest.java
│
└── bai7_orderprocessor_testing
    ├── analysis
    │   ├── cfg_diagram.md
    │   ├── cyclomatic_complexity.md
    │   └── basis_path.md
    │
    ├── src
    │   ├── main
    │   │   └── OrderProcessor.java
    │   │
    │   └── test
    │       └── OrderProcessorTest.java
    │
    └── reports
        ├── allure-report
        └── jacoco-report
```

---

# 📑 Mô tả các bài

## Bài 1 – MC/DC
Phân tích **Modified Condition Decision Coverage (MC/DC)** để đảm bảo mỗi điều kiện trong biểu thức logic có thể ảnh hưởng độc lập đến kết quả quyết định.

---

## Bài 2 – Control Flow Graph (CFG)
Xây dựng **Control Flow Graph** để mô tả luồng thực thi của chương trình.

Bao gồm:
- Node (khối lệnh)
- Edge (luồng điều khiển)

---

## Bài 3 – Cyclomatic Complexity
Tính **Cyclomatic Complexity (CC)** để xác định số lượng test case tối thiểu cần thiết.

Công thức:

```
CC = D + 1
CC = E - N + 2P
```

Trong đó:
- D: số decision node
- E: số edge
- N: số node
- P: số thành phần liên thông

---

## Bài 4 – Basis Path Testing
Xác định các **Basis Paths** từ CFG để đảm bảo bao phủ tất cả các đường đi độc lập của chương trình.

---

## Bài 5 – TestNG Unit Test
Viết **Unit Test bằng TestNG** dựa trên:
- Basis Path
- MC/DC

---

## Bài 6 – Selenium White-Box Testing

Kiểm thử form web bằng **Selenium WebDriver** sử dụng **Page Object Model (POM)**.

Trang được kiểm thử:

```
https://demoqa.com/text-box
```

Bao gồm:
- `TextBoxPage.java` – Page Object
- `TextBoxWhiteBoxTest.java` – Test cases

---

## Bài 7 – OrderProcessor Testing

Thiết kế **Test Suite toàn diện** cho lớp xử lý đơn hàng thương mại điện tử.

### Nội dung thực hiện
- Vẽ CFG
- Tính Cyclomatic Complexity
- Xác định Basis Path
- Phân tích MC/DC
- Viết TestNG Test

### Báo cáo kiểm thử
Dự án tích hợp:

- **Allure Report** – hiển thị kết quả test chi tiết
- **JaCoCo** – đo code coverage

Các báo cáo được lưu tại:

```
bai7_orderprocessor_testing/reports
```

---

# 🧪 Chạy test

Chạy toàn bộ test bằng Maven:

```
mvn clean test
```

Tạo báo cáo JaCoCo:

```
mvn jacoco:report
```

Mở Allure Report:

```
allure serve
```

---

# 👨‍💻 Thông tin sinh viên

**Họ tên:** Huỳnh Minh Khoa  
**MSSV:** 1150080139  
**Môn học:** Kiểm thử phần mềm
