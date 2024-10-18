# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.


## Answer

The current tests for `TLSSocketFactory` fail to fully verify the behavior of the `prepareSocket` method, as removing its code doesn't cause any tests to fail. This happens because manually built stubs and mocks for `SSLSocket` are insufficient to test the method thoroughly.

To solve this, we can use Mockito to mock the `SSLSocket` interactions and verify expected behaviors. Mockito allows us to:
1. **Mock `SSLSocket`**: Simulate supported and enabled protocols without manually building stubs.
2. **Verify interactions**: Ensure `setEnabledProtocols()` is called with the correct protocols.
3. **Cover edge cases**: Test scenarios like null protocols, unsupported protocols, or already correct configurations.

By using Mockito, we ensure that the tests fail if `prepareSocket` doesn’t behave as expected, improving test coverage and reliability.