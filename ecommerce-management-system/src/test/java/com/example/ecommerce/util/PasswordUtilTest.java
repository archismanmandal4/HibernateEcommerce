package com.example.ecommerce.util;
import static org.junit.jupiter.api.Assertions.*; import org.junit.jupiter.api.Test;
class PasswordUtilTest { @Test void hashCanBeVerified(){String hash=PasswordUtil.hash("secret"); assertTrue(PasswordUtil.matches("secret",hash));assertFalse(PasswordUtil.matches("wrong",hash));} }
