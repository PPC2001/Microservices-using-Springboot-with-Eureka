Microservices using Springboot 3 with Eureka and Resilience4j - Circuit Breaker

------------------------

Microservice Architecture - 

![WhatsApp Image 2024-04-07 at 4 03 38 PM](https://github.com/PPC2001/Microservices-using-Springboot-with-Eureka/assets/107803628/b0b554f5-62fd-42fa-9378-568452c89f71)

Eureka Server - 

![WhatsApp Image 2024-04-07 at 4 08 07 PM](https://github.com/PPC2001/Microservices-using-Springboot-with-Eureka/assets/107803628/2d08b891-c800-4dd0-b07b-b6bcb0d734ff)

The below Rest API Endpoint fetch the data from Vaccination center service and Citizen Service -

![WhatsApp Image 2024-04-07 at 4 08 31 PM](https://github.com/PPC2001/Microservices-using-Springboot-with-Eureka/assets/107803628/682da66e-ad06-4dc0-ad4f-58f92c3239f6)

Citizen Service is down still we are getting data because of Resilience4j - Circuit Breaker which is used here for fault tolerance - 

![WhatsApp Image 2024-04-07 at 4 09 36 PM (1)](https://github.com/PPC2001/Microservices-using-Springboot-with-Eureka/assets/107803628/df712b80-c800-4968-9c81-235e7a6ab03f)

Check the Circuitbreaker health using Spring Actuator - 

![WhatsApp Image 2024-04-07 at 4 10 57 PM](https://github.com/PPC2001/Microservices-using-Springboot-with-Eureka/assets/107803628/ebfa5379-5180-4790-81e0-fff2e3179f37)
