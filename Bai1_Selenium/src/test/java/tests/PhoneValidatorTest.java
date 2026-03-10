package tests;

import utils.PhoneValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneValidatorTest {

    @Test(description = "Valid phone starting with 09")
    public void testValidPhone09() {
        Assert.assertTrue(PhoneValidator.isValid("0901234567"), "Should be valid: 0901234567");
    }

    @Test(description = "Valid phone with spaces starting with +84")
    public void testValidPhoneInternational() {
        Assert.assertTrue(PhoneValidator.isValid("+84 901 234 567"), "Should be valid: +84 901 234 567");
    }

    @Test(description = "Valid phone starting with 03")
    public void testValidPhone03() {
        Assert.assertTrue(PhoneValidator.isValid("0312345678"), "Should be valid: 0312345678");
    }

    @Test(description = "Invalid prefix (e.g., 02 for landline)")
    public void testInvalidPrefix02() {
        Assert.assertFalse(PhoneValidator.isValid("0212345678"), "Should be invalid: 02 prefix");
    }

    @Test(description = "Invalid length (too short)")
    public void testInvalidLengthShort() {
        Assert.assertFalse(PhoneValidator.isValid("090123456"), "Should be invalid: length 9");
    }

    @Test(description = "Invalid length (too long)")
    public void testInvalidLengthLong() {
        Assert.assertFalse(PhoneValidator.isValid("09012345678"), "Should be invalid: length 11");
    }

    @Test(description = "Invalid characters (contains letters)")
    public void testInvalidChars() {
        Assert.assertFalse(PhoneValidator.isValid("09012a4567"), "Should be invalid: contains 'a'");
    }

    @Test(description = "Boundary case: null input")
    public void testNullInput() {
        Assert.assertFalse(PhoneValidator.isValid(null), "Should be invalid: null");
    }

    @Test(description = "Boundary case: only spaces")
    public void testEmptyInput() {
        Assert.assertFalse(PhoneValidator.isValid("   "), "Should be invalid: spaces only");
    }
}
