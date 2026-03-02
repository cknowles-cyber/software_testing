package com.mycompany.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {
    @Mock
    private ResourceRepository mockRepository;

    @Mock
    private EmailProvider mockEmailProvider;

    private LibraryService libraryService;

    private final UUID validId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
    private final String email = "test@gmail.com";

    @BeforeEach
    public void setUp() {
        libraryService = new LibraryService(mockEmailProvider, mockRepository);
    }

    // Test case 1.1: resourceId is null
    @Test
    public void testCheckoutResource_NullId() throws Exception {
       boolean result = libraryService.checkoutResource(null, email);
        assertEquals(false, result, "Checkout test for null resourceId failed: " + result);
    }

    // Test case 1.2: book not available
    @Test
    public void testCheckoutResource_BookNotAvailable() throws Exception {
        when(mockRepository.isResourceAvailable(validId)).thenReturn(false);

        boolean result = libraryService.checkoutResource(validId, email);
        assertEquals(false, result, "Checkout test for unavailable resource " + validId + " failed: " + result);
    }

    // Test case 1.3: successful checkout
    @Test
    public void testCheckoutResource_Success() throws Exception {
        when(mockRepository.isResourceAvailable(validId)).thenReturn(true);
        when(mockRepository.updateStatus(validId, false)).thenReturn(true);
        String emailSend = "Resource ID: " + validId + " checked out.";
        when(mockEmailProvider.sendEmail(email, emailSend)).thenReturn(true);

        boolean result = libraryService.checkoutResource(validId, email);
        assertEquals(true, result, "Checkout test for available resource " + validId + " failed: " + result);
    }

    // Test case 1.4: database failure
    @Test
    public void testCheckoutResource_DatabaseFailure() throws Exception {
        when(mockRepository.isResourceAvailable(validId)).thenReturn(true);
        when(mockRepository.updateStatus(validId, false)).thenReturn(false);

        assertThrows(DatabaseFailureException.class,
                () -> libraryService.checkoutResource(validId, email),
                "Expected DatabaseFailureException when updateStatus fails");
    }

    // Test case 1.5: email failure
    @Test
    public void testCheckoutResource_EmailFailure() throws Exception {
        when(mockRepository.isResourceAvailable(validId)).thenReturn(true);
        when(mockRepository.updateStatus(validId, false)).thenReturn(true);
        String emailSend = "Resource ID: " + validId + " checked out.";
        when(mockEmailProvider.sendEmail(email, emailSend)).thenReturn(false);

        assertThrows(EmailFailureException.class,
                () -> libraryService.checkoutResource(validId, email),
                "Expected DatabaseFailureException when updateStatus fails");
    }

}
