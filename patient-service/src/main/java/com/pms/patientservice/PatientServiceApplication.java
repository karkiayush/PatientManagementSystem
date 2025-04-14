package com.pms.patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }
}

/*
 * gRPC(Google Remote Procedure Call)
 * gRPC is a high-performance, open-source universal RPC(Remote Procedure Call) framework that can run in any environment. It is designed for high-performance communication between microservices and supports multiple programming languages.
 *
 * gRPC uses HTTP 2 and Protocol Buffers for efficient low latency communication between its services.
 *
 * gRPC uses HTTP/2 for transport, Protocol Buffers as the interface description language, and it provides features such as authentication, load balancing, and bidirectional streaming.
 *
 * In simple terms, while REST provides an excellent way for browsers & others clients to communicate with services using JSON format, gRPC offers a faster & more efficient method for microservices to interact with each other utilizing proto buff format to send & receive data.
 *
 * While both REST & gRPC uses HTTP under the hood, gRPC is more efficient than REST because it uses HTTP/2 which allows for multiplexing multiple requests over a single connection. This means that gRPC can handle more requests with less overhead compared to REST.
 * */