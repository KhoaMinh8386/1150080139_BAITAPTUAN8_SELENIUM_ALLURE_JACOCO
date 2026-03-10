package bai5;

public class VayVonService {
    /**
     * Xét duyệt vay vốn dựa trên 3 điều kiện:
     * A: tuoi >= 22
     * B: thuNhap >= 10,000,000
     * C: coTaiSan
     * 
     * Logic: duocVay = A && B && C
     */
    public static boolean checkDuocVay(int tuoi, long thuNhap, boolean coTaiSan) {
        return (tuoi >= 22) && (thuNhap >= 10000000) && (coTaiSan);
    }
}
