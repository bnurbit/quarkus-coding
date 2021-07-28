package pt.bnurbit.coding.quarkus;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Defining the resource in test folder overrides the one in the main folder when executing tests.
 */
@QuarkusTest
class StaticContentTest {

    @TestHTTPResource("index.html")
    private URL url;

    @Test
    void testRootPath() throws IOException {
        final String body = IOUtils.toString(url, Charset.defaultCharset());
        System.out.println(body);
//        assert body.contains("Your new Cloud-Native application is ready!");
        assert body.contains("This is a test resource");
        Assertions.assertFalse(body.contains("abc"));
    }
}
