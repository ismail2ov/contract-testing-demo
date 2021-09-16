package contracts.java;

import org.springframework.cloud.contract.spec.Contract;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;

public class shouldReturnProducts implements Supplier<Collection<Contract>> {

    @Override
    public Collection<Contract> get() {
        return Collections.singletonList(Contract.make(contract -> {
            contract.description("Should return products list");
            contract.name("Java contract");

            contract.request(request -> {
                request.url("/products");
                request.method(request.GET());
            });

            contract.response(response -> {
                response.status(response.OK());
                response.headers(header -> {
                    header.contentType(header.applicationJson());
                });
                response.body(response.file("response/products.json"));
            });
        }));
    }

}
