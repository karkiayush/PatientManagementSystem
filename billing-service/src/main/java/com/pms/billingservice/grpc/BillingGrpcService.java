package com.pms.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Here, we store the gRPC server logic, starting the server, receiving messages, sending responses, etc...*/
// This file is the contract for communication between the client and server.
@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(
            billing.BillingRequest billingRequest,
            /*once we're ready to respond to the request, we use StreamObserver, which is a powerful concept in gRPC as it allows earning multiple responses to the client at the same time and also accept back-forth communication to that client*/
            StreamObserver<billing.BillingResponse> responseObserver
    ) {
        log.info("Create billing account request received: {}", billingRequest.toString());
        /*
         * Any business logic in the middle
         * */
        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        // This onNext() method is used to send the response back to the client from our gRPC server
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
