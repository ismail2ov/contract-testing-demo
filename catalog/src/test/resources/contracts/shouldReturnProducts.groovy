package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return products list"
    name "Groovy contract"

    request {
        method GET()
        url '/products'
    }

    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body(file("response/products.json"))
    }
}