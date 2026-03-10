# 🧪 KIỂM THỬ PHẦN MỀM - LAB PROJECT (LAB 1 - LAB 7)

Dự án này là tập hợp các bài tập thực hành kiểm thử phần mềm (Testing) sử dụng ngôn ngữ **Java**, framework **Selenium WebDriver**, **TestNG**, và các công cụ báo cáo Coverage/Testing chuyên sâu như **JaCoCo**, **Allure Report**.

---

## 📂 Danh Sách Bài Tập & Cấu Trúc Thư Mục

Dưới đây là ánh xạ chi tiết giữa các bài tập Lab và vị trí mã nguồn trong dự án:

### 🌐 Bài 1 & 2: Selenium Automation (SauceDemo)
*   **Nội dung**: Tự động hóa kiểm thử trang [SauceDemo](https://www.saucedemo.com) bằng mô hình **Page Object Model (POM)**. Thực hiện Login, quản lý giỏ hàng và thanh toán.
*   **Mã nguồn**: `src/test/java/dtm/` (Các package `bai1_1`, `bai1_2`, `bai2_1`, `bai2_2`)
*   **Tiện ích**: `src/test/java/dtm/utils/ScreenshotUtil.java` (Chụp ảnh màn hình khi lỗi).

### 📊 Bài 3: White-box Testing - CFG & Branch Coverage
*   **Nội dung**: Vẽ đồ thị luồng điều khiển (CFG) và thiết kế bộ kiểm thử đạt **100% Branch Coverage**.
*   **Mã nguồn**:
    *   Logic: `src/main/java/bai3/` (`XepLoaiService`, `TinhTienNuocService`)
    *   Unit Test: `src/test/java/bai3/`
*   **Báo cáo chi tiết**: `bai3/bai3_1/`, `bai3/bai3_2/` (Chứa bảng thiết kế test case).

### 🗺️ Bài 4: White-box Testing - Basis Path Testing
*   **Nội dung**: Xác định số Cyclomatic Complexity (CC) và bộ đường đi độc lập (Basis Paths) cho logic tính phí vận chuyển.
*   **Mã nguồn**:
    *   Logic: `src/main/java/bai4/PhiShipService.java`
    *   Unit Test: `src/test/java/bai4/PhiShipBasisPathTest.java`
*   **Tài liệu**: `bai4/bai4_1/report.md` (Phân tích CC và Basis Paths).

### 🧪 Bài 5: White-box Testing - MC/DC Testing
*   **Nội dung**: Thiết kế bộ kiểm thử tối ưu theo phương pháp **Modified Condition/Decision Coverage (MC/DC)** cho logic xét duyệt vay vốn.
*   **Mã nguồn**:
    *   Logic: `src/main/java/bai5/VayVonService.java`
    *   Unit Test: `src/test/java/tests/VayVonMCDCTest.java`

### 🛒 Bài 6: Test Suite Design & Integration Testing
*   **Nội dung**: Thiết kế Test Suite (XML) và kiểm thử tính toán tổng tiền đơn hàng (Order Processing) với nhiều điều kiện giảm giá, phí ship.
*   **Mã nguồn**:
    *   Logic: `src/main/java/bai6/OrderProcessor.java`
    *   Unit Test: `src/test/java/bai6/OrderProcessorTest.java`
    *   Suite XML: `testng.xml`

### 📈 Bài 7: Tổng Hợp Báo cáo (Jacoco & Allure Report)
*   **Nội dung**: Tích hợp công cụ đo độ bao phủ mã nguồn (**JaCoCo**) và tạo báo cáo kiểm thử chuyên nghiệp (**Allure**).
*   **Cấu hình**: `pom.xml` (Plugins: `allure-maven`, `jacoco-maven-plugin`).
*   **Vị trí báo cáo**:
    *   **JaCoCo**: `target/site/jacoco/index.html` (Mở bằng trình duyệt để xem % Coverage).
    *   **Allure Result**: Thư mục `allure-results/`.

---

## 🛠️ Công Nghệ Sử Dụng
*   **Language**: Java 17
*   **Testing Framework**: TestNG 7.9.0
*   **Automation**: Selenium WebDriver 4.18.1, WebDriverManager 5.7.0
*   **Coverage**: JaCoCo 0.8.11
*   **Reporting**: Allure Report 2.25.0

---

## 🚀 Hướng Dẫn Chạy Dự Án

1.  **Chạy toàn bộ kiểm thử và tạo dữ liệu báo cáo**:
    ```bash
    mvn clean test
    ```
2.  **Xem báo cáo JaCoCo (Code Coverage)**:
    Sau khi chạy lệnh trên, truy cập: `target/site/jacoco/index.html`
3.  **Xem báo cáo Allure (Test Result)**:
    Sử dụng lệnh sau để khởi chạy máy chủ Allure (Yêu cầu đã cài đặt Allure CLI):
    ```bash
    allure serve allure-results
    ```

---

## 📸 Hình Ảnh Minh Họa
*   Ảnh chụp màn hình các bài kiểm thử lỗi được lưu tự động tại thư mục: `/screenshots`

> [!TIP]
> Để đạt kết quả tốt nhất, hãy đảm bảo bạn đã cài đặt JDK 17 và Chrome Browser phiên bản mới nhất.
