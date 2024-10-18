package fr.istic.vv;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TLSSocketFactoryTestMocks {

    private TLSSocketFactory factory;
    private SSLSocket mockSocket;

    @BeforeEach
    public void setUp() {
        factory = new TLSSocketFactory();
        mockSocket = Mockito.mock(SSLSocket.class);
    }

    /**
     * Test edge case when both supported and enabled protocols are null.
     */
    @Test
    public void testPrepareSocket_NullProtocols() {
        when(mockSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSocket.getEnabledProtocols()).thenReturn(null);

        factory.prepareSocket(mockSocket);

        // Verify that setEnabledProtocols was never called
        verify(mockSocket, never()).setEnabledProtocols(any());
    }

    /**
     * Test when supported and enabled protocols are provided in a typical case.
     */
    @Test
    public void testTypicalCase() {
        // Mock supported and enabled protocols
        when(mockSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mockSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));

        // Call the method under test
        factory.prepareSocket(mockSocket);

        // Verify the correct protocols are set
        verify(mockSocket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }

    /**
     * Utility method to shuffle an array of protocols (for randomization in tests).
     */
    private String[] shuffle(String[] in) {
        List<String> list = Arrays.asList(in);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
}
