package utils;

public class PhoneValidator {

    /**
     * Kiểm tra số điện thoại Việt Nam hợp lệ.
     * Quy tắc:
     * - Bắt đầu bằng 0 hoặc +84
     * - Sau chuẩn hóa (+84 thành 0) phải có 10 chữ số
     * - Đầu số thuộc: 03x, 05x, 07x, 08x, 09x
     * - Chỉ chứa chữ số, dấu + và khoảng trắng
     * 
     * @param phone Số điện thoại cần kiểm tra
     * @return true nếu hợp lệ, ngược lại false
     */
    public static boolean isValid(String phone) {
        // 1. Kiểm tra null hoặc rỗng (sau khi trim)
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }

        // 2. Chuẩn hóa: xóa khoảng trắng
        String normalized = phone.replace(" ", "");

        // 3. Kiểm tra các ký tự không hợp lệ (chỉ cho phép số và dấu +)
        if (!normalized.matches("^[0-9+]+$")) {
            return false;
        }

        // 4. Chuẩn hóa +84 thành đầu số 0
        if (normalized.startsWith("+84")) {
            normalized = "0" + normalized.substring(3);
        }

        // 5. Kiểm tra độ dài và định dạng đầu số Việt Nam
        // 03, 05, 07, 08, 09
        return normalized.matches("^0[35789][0-9]{8}$");
    }
}
