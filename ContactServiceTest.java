/*************************
 * Name: 	Gavin Bish 
 * Course: 	CS-320 
 * Date: 	September 18, 2024
 * Description: This is the unit tests for the contact service (ContactServiceTest).
 *************************/

package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import Contact.Contact;
import Contact.ContactService;

import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

	/*
	 * The following tests evaluate the ContactService class. In each test, a new service is initialized with default 
	 * values for all fields. Then, the service is asked to make a change to the contact list, and the result is checked 
	 * to ensure the updated field matches the expected value. 
	 * Since each contact is assigned a unique ContactID automatically, and the tests depend on this ContactID, 
	 * the order of test execution is determined by these values. To maintain a specific test sequence, the @Order 
	 * annotation is used. 
	 * For verification of the correct ContactID in each test, you can uncomment service.displayContactList(); 
	 * before each assertion to display the contact records in the console for error checking.
	 */
	
	@Test
	@DisplayName("Test to Update First Name.")
	@Order(1)
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact("Mr", "Gavin", "7064660133", "1190 Prides Xing");
		service.updateFirstName("Tiffany", "1");
		service.displayContactList();
		assertEquals("Sven", service.getContact("1").getFirstName(), "First name was not updated.");
	}

	@Test
	@DisplayName("Test to Update Last Name.")
	@Order(2)
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact("Mr", "Gavin", "7064660133", "1190 Prides Xing");
		service.updateLastName("Bish", "2");
		service.displayContactList();
		assertEquals("Shirley", service.getContact("2").getLastName(), "Last name was not updated.");
	}

	@Test
	@DisplayName("Test to update phone number.")
	@Order(3)
	void testUpdatePhoneNumber() {
		ContactService service = new ContactService();
		service.addContact("Mr", "Gavin", "7064660133", "1190 Prides Xing");
		service.updateNumber("1111111111", "3");
		service.displayContactList();
		assertEquals("1111111111", service.getContact("3").getNumber(), "Phone number was not updated.");
	}

	@Test
	@DisplayName("Test to update address.")
	@Order(4)
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact("Mr", "Gavin", "7064660133", "1190 Prides Xing");
		service.updateAddress("1190 Nowhere Lane", "4");
		service.displayContactList();
		assertEquals("1190 Nowhere Lane", service.getContact("4").getAddress(), "Address was not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes contacts.")
	@Order(5)
	void testDeleteContact() {
		ContactService service = new ContactService();
		service.addContact("Mr", "Gavin", "7064660133", "1190 Prides Xing");
		service.deleteContact("5");
		// Ensure that the contactList is now empty by creating a new empty contactList to compare it with
		ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
		service.displayContactList();
		assertEquals(service.contactList, contactListEmpty, "The contact was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add a contact.")
	@Order(6)
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("Mr", "Gavin", "7064660133", "1190 Prides Xing");
		service.displayContactList();
		assertNotNull(service.getContact("0"), "Contact was not added correctly.");
	}

}