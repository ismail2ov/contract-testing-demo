package es.devex.shop.infrastructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "es.devex:catalog:+:stubs:8080")
class ShopControllerIntegrationTest {

    @Autowired
    private ShopController shopController;

    @Test
    void testContractToCatalogProducer() {
        var result = shopController.getProducts().getBody();

        assertNotNull(result);

        assertThat(result.getProducts()).extracting("productId")
                .contains(17035535L, 17005954L);
    }
}