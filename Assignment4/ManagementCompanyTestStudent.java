import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent 
{
	 @Test
	    void testAddProperty() {
	        ManagementCompany company = new ManagementCompany("Railey", "555555555", 15.0);
	        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);

	        assertEquals(0, company.addProperty(property));
	        assertEquals(1, company.getPropertiesCount());
	        assertFalse(company.isPropertiesFull());
	    }

	    @Test
	    void testRemoveLastProperty() {
	        ManagementCompany company = new ManagementCompany("Railey", "555555555", 15.0);
	        Property property = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson", 2, 5, 2, 2);
	        company.addProperty(property);

	        assertEquals(1, company.getPropertiesCount());
	        company.removeLastProperty();
	        assertEquals(0, company.getPropertiesCount());
	    }

	    @Test
	    void testGetHighestRentPropperty() {
	        ManagementCompany company = new ManagementCompany("Railey", "555555555", 15.0);
	        Property property1 = new Property("Sunsational", "Beckman", 2613.0, "BillyBob Wilson");
	        Property property2 = new Property("Cool Apartments", "Brightsville", 1750.0, "Alice Johnson");
	        company.addProperty(property1);
	        company.addProperty(property2);

	        assertEquals(property1, company.getHighestRentPropperty());
	    }
	}
