package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client("John Doe", "johndoe@example.com");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", client.getName());
    }

    @Test
    public void testSetName() {
        client.setName("Jane Smith");
        assertEquals("Jane Smith", client.getName());
    }

    @Test
    public void testGetContactInfo() {
        assertEquals("johndoe@example.com", client.getContactInfo());
    }

    @Test
    public void testSetContactInfo() {
        client.setContactInfo("janesmith@example.com");
        assertEquals("janesmith@example.com", client.getContactInfo());
    }
}