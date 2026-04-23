import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@Test
	void testIsStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("HELLO"));
		assertFalse(CryptoManager.isStringInBounds("{Hello"));
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("KHOOR", CryptoManager.caesarEncryption("HELLO", 3));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("hflmo", CryptoManager.bellasoEncryption("HELLO", " !"));
	}

	@Test
	void testCaesarDecryption() {
		assertEquals("HELLO", CryptoManager.caesarDecryption("KHOOR", 3));
	}

	@Test
	void testBellasoDecryption() {
		assertEquals("HELLO", CryptoManager.bellasoDecryption("hflmo", " !"));
	}

}
